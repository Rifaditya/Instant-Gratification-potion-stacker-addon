// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package net.instantgratification.potionstacker.test;

import net.instantgratification.potionstacker.util.PotionStackerManager;
import net.minecraft.SharedConstants;
import net.minecraft.server.Bootstrap;
import net.minecraft.world.item.Items;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

/**
 * PotionStackerStressFuzzTest: Pillar 1 Chaos & Property Fuzzing Suite
 *
 * Executes 20,000 randomized iterations with deterministic seed 0xDA51C262L
 * testing PotionStackerManager.getModifiedStackSize and dynamic limit math
 * against extreme inputs, boundary conditions, and non-positive size preservation.
 */
public class PotionStackerStressFuzzTest {

    private static final long SEED = 0xDA51C262L;
    private static final int ITERATIONS = 20_000;

    private static final int[] EXTREME_INTS = {
        Integer.MIN_VALUE, Integer.MIN_VALUE + 1, -1_000_000, -100, -1,
        0, 1, 2, 16, 32, 64, 100, 1_000, 64_000, 1_000_000,
        1_000_000_000, Integer.MAX_VALUE - 1, Integer.MAX_VALUE
    };

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
    @DisplayName("Pillar 1: 20,000-Iteration Chaos Property Fuzzing of PotionStackerManager.getModifiedStackSize")
    void testStressFuzzingStackSizeCalculations() {
        Random rng = new Random(SEED);

        for (int i = 0; i < ITERATIONS; i++) {
            int originalSize;
            if (i < EXTREME_INTS.length) {
                originalSize = EXTREME_INTS[i];
            } else {
                int mode = rng.nextInt(5);
                if (mode == 0) {
                    originalSize = -1 - rng.nextInt(Integer.MAX_VALUE);
                } else if (mode == 1) {
                    originalSize = rng.nextInt(2); // 0 or 1
                } else if (mode == 2) {
                    originalSize = 1 + rng.nextInt(64); // 1 to 64
                } else if (mode == 3) {
                    originalSize = 65 + rng.nextInt(1_000_000);
                } else {
                    originalSize = Integer.MAX_VALUE - rng.nextInt(1_000_000);
                }
            }

            int randomizedLimit = 1 + rng.nextInt(Integer.MAX_VALUE);
            PotionStackerManager.setClientLimit(randomizedLimit, randomizedLimit);

            // 1. Non-positive size invariant: must return original unchanged without exceptions
            int nonPositiveResult = PotionStackerManager.getModifiedStackSize(Items.POTION, originalSize <= 0 ? originalSize : -originalSize);
            assertTrue(nonPositiveResult <= 0, "Non-positive size must return non-positive original");

            // 2. Potions must return active potionLimit for originalSize > 0
            if (originalSize > 0) {
                int potionResult = PotionStackerManager.getModifiedStackSize(Items.POTION, originalSize);
                assertEquals(randomizedLimit, potionResult, "Potion stack size must return configured limit for positive count");

                // Splash potion check (subclass of PotionItem)
                int splashResult = PotionStackerManager.getModifiedStackSize(Items.SPLASH_POTION, originalSize);
                assertEquals(randomizedLimit, splashResult, "Splash potion stack size must return configured limit");

                // Lingering potion check (subclass of PotionItem)
                int lingeringResult = PotionStackerManager.getModifiedStackSize(Items.LINGERING_POTION, originalSize);
                assertEquals(randomizedLimit, lingeringResult, "Lingering potion stack size must return configured limit");

                // 3. Unrelated items must return -1 (defer to vanilla / other mods)
                int unrelatedResult = PotionStackerManager.getModifiedStackSize(Items.DIAMOND, originalSize);
                assertEquals(-1, unrelatedResult, "Unrelated item must return -1 to defer");

                int nullResult = PotionStackerManager.getModifiedStackSize(null, originalSize);
                assertEquals(-1, nullResult, "Null item must return -1 to defer");
            }
        }
    }

    @Test
    @DisplayName("Pillar 1: Explicit Boundary Saturation & Edge Cases")
    void testBoundarySaturation() {
        for (int val : EXTREME_INTS) {
            if (val <= 0) {
                assertEquals(val, PotionStackerManager.getModifiedStackSize(null, val),
                        "Original <= 0 must be preserved: " + val);
                assertEquals(val, PotionStackerManager.getModifiedStackSize(Items.POTION, val),
                        "Original <= 0 must be preserved for potion: " + val);
            } else {
                assertEquals(16, PotionStackerManager.getModifiedStackSize(Items.POTION, val),
                        "Potion stack size should return default limit 16 for val: " + val);
                assertEquals(-1, PotionStackerManager.getModifiedStackSize(null, val),
                        "Unrelated/null item should return -1 for positive val: " + val);
            }
        }

        // Test extreme limit values in manager
        PotionStackerManager.setClientLimit(Integer.MAX_VALUE, Integer.MAX_VALUE);
        assertEquals(Integer.MAX_VALUE, PotionStackerManager.getPotionLimit());
        assertEquals(Integer.MAX_VALUE, PotionStackerManager.getModifiedStackSize(Items.POTION, 1));

        PotionStackerManager.setClientLimit(Integer.MIN_VALUE, Integer.MIN_VALUE);
        assertEquals(Integer.MIN_VALUE, PotionStackerManager.getPotionLimit());
        assertEquals(Integer.MIN_VALUE, PotionStackerManager.getModifiedStackSize(Items.POTION, 1));
    }
}
