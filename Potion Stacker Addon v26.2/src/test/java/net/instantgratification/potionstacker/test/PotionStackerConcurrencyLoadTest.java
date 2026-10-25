// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package net.instantgratification.potionstacker.test;

import net.instantgratification.potionstacker.util.PotionStackerManager;
import net.minecraft.SharedConstants;
import net.minecraft.server.Bootstrap;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

import static org.junit.jupiter.api.Assertions.*;

/**
 * PotionStackerConcurrencyLoadTest: Pillar 2 Concurrency & Thread-Safety Load Suite
 *
 * Spawns 50 concurrent worker threads executing simultaneous limit reads, writes,
 * and stack size evaluations under CountDownLatch contention without race conditions or deadlock.
 */
public class PotionStackerConcurrencyLoadTest {

    private static final int THREAD_COUNT = 50;
    private static final int OPS_PER_THREAD = 400;

    @BeforeAll
    public static void init() {
        SharedConstants.tryDetectVersion();
        Bootstrap.bootStrap();
    }

    @AfterEach
    void tearDown() {
        PotionStackerManager.setClientLimit(16, 16);
    }

    @Test
    @DisplayName("Pillar 2: 50-Thread Concurrent Manager Operations Load Test")
    void testConcurrentManagerOperations() throws Exception {
        ExecutorService pool = Executors.newFixedThreadPool(THREAD_COUNT);
        CountDownLatch readyLatch = new CountDownLatch(THREAD_COUNT);
        CountDownLatch startLatch = new CountDownLatch(1);
        List<Future<?>> futures = new ArrayList<>(THREAD_COUNT);

        AtomicLong totalOps = new AtomicLong(0);

        for (int t = 0; t < THREAD_COUNT; t++) {
            final int threadId = t;
            futures.add(pool.submit(() -> {
                readyLatch.countDown();
                try {
                    if (!startLatch.await(10, TimeUnit.SECONDS)) {
                        throw new IllegalStateException("Timed out waiting for test start latch");
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException("Worker thread interrupted", e);
                }

                for (int i = 0; i < OPS_PER_THREAD; i++) {
                    int pVal = 1 + ((threadId * 17 + i) % 128);
                    int sVal = 1 + ((threadId * 31 + i) % 128);

                    // Alternate between mutations and reads
                    if (i % 2 == 0) {
                        PotionStackerManager.setClientLimit(pVal, sVal);
                    } else {
                        PotionStackerManager.setLimits(pVal, sVal, null);
                    }

                    int currentPotionLimit = PotionStackerManager.getPotionLimit();
                    int currentStewLimit = PotionStackerManager.getStewLimit();

                    assertTrue(currentPotionLimit > 0, "Potion limit must be positive");
                    assertTrue(currentStewLimit > 0, "Stew limit must be positive");

                    // Evaluate stack size calculation concurrently
                    int modified = PotionStackerManager.getModifiedStackSize(null, 0);
                    assertEquals(0, modified);

                    int unrelated = PotionStackerManager.getModifiedStackSize(null, 64);
                    assertEquals(-1, unrelated);

                    totalOps.incrementAndGet();
                }
                return null;
            }));
        }

        assertTrue(readyLatch.await(5, TimeUnit.SECONDS), "Timed out waiting for worker threads to become ready");
        startLatch.countDown();

        for (Future<?> future : futures) {
            assertDoesNotThrow(() -> future.get(10, TimeUnit.SECONDS),
                    "Concurrent worker task threw an exception or deadlocked");
        }

        pool.shutdown();
        assertTrue(pool.awaitTermination(10, TimeUnit.SECONDS), "Thread pool failed to terminate cleanly");

        assertEquals((long) THREAD_COUNT * OPS_PER_THREAD, totalOps.get(),
                "All concurrent operations must complete deterministically");
    }
}
