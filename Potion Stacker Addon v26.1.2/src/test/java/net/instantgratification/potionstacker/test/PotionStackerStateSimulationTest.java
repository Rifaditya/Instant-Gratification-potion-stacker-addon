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

import static org.junit.jupiter.api.Assertions.*;

/**
 * PotionStackerStateSimulationTest: Pillar 4 Headless State Simulation Suite
 *
 * Verifies default limit values, dynamic client limit synchronization,
 * non-positive original size preservation, and deferral on unrelated items.
 */
public class PotionStackerStateSimulationTest {

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
    @DisplayName("Pillar 4: Initial Default Limits are 16")
    void testInitialDefaultLimits() {
        assertEquals(16, PotionStackerManager.getPotionLimit(), "Default potionLimit must be 16");
        assertEquals(16, PotionStackerManager.getStewLimit(), "Default stewLimit must be 16");
    }

    @Test
    @DisplayName("Pillar 4: Dynamic Client Limit Update")
    void testDynamicClientLimitUpdate() {
        PotionStackerManager.setClientLimit(32, 64);
        assertEquals(32, PotionStackerManager.getPotionLimit(), "Updated potionLimit must be 32");
        assertEquals(64, PotionStackerManager.getStewLimit(), "Updated stewLimit must be 64");

        assertEquals(32, PotionStackerManager.getModifiedStackSize(Items.POTION, 1));
        assertEquals(32, PotionStackerManager.getModifiedStackSize(Items.SPLASH_POTION, 1));
        assertEquals(32, PotionStackerManager.getModifiedStackSize(Items.LINGERING_POTION, 1));

        PotionStackerManager.setClientLimit(16, 16);
        assertEquals(16, PotionStackerManager.getPotionLimit());
        assertEquals(16, PotionStackerManager.getStewLimit());
    }

    @Test
    @DisplayName("Pillar 4: Non-Positive Original Size Preservation")
    void testNonPositiveOriginalSizePreservation() {
        assertEquals(0, PotionStackerManager.getModifiedStackSize(null, 0), "Stack size 0 must be preserved");
        assertEquals(-1, PotionStackerManager.getModifiedStackSize(null, -1), "Stack size -1 must be preserved");
        assertEquals(-64, PotionStackerManager.getModifiedStackSize(null, -64), "Negative stack size must be preserved");
        assertEquals(0, PotionStackerManager.getModifiedStackSize(Items.POTION, 0), "Potion stack size 0 must be preserved");
        assertEquals(-5, PotionStackerManager.getModifiedStackSize(Items.POTION, -5), "Negative potion size must be preserved");
    }

    @Test
    @DisplayName("Pillar 4: Unrelated Item Deference")
    void testUnrelatedItemDeference() {
        assertEquals(-1, PotionStackerManager.getModifiedStackSize(null, 64), "Null item must return -1");
        assertEquals(-1, PotionStackerManager.getModifiedStackSize(Items.DIAMOND, 64), "Diamond must return -1");
        assertEquals(-1, PotionStackerManager.getModifiedStackSize(Items.APPLE, 1), "Apple must return -1");
        assertEquals(-1, PotionStackerManager.getModifiedStackSize(Items.IRON_SWORD, 1), "Sword must return -1");

        // Verify potion items are NOT deferred
        assertEquals(16, PotionStackerManager.getModifiedStackSize(Items.POTION, 1), "Potion must return limit 16");
    }

    @Test
    @DisplayName("Pillar 4: Stew and Soup Item Detection")
    void testStewAndSoupIdentification() {
        assertTrue(PotionStackerManager.isStewOrSoup(Items.MUSHROOM_STEW), "Mushroom stew must be detected");
        assertTrue(PotionStackerManager.isStewOrSoup(Items.RABBIT_STEW), "Rabbit stew must be detected");
        assertTrue(PotionStackerManager.isStewOrSoup(Items.BEETROOT_SOUP), "Beetroot soup must be detected");
        assertTrue(PotionStackerManager.isStewOrSoup(Items.SUSPICIOUS_STEW), "Suspicious stew must be detected");

        assertFalse(PotionStackerManager.isStewOrSoup(Items.POTION), "Potion is not stew");
        assertFalse(PotionStackerManager.isStewOrSoup(Items.BOWL), "Bowl is not stew");
        assertFalse(PotionStackerManager.isStewOrSoup(null), "Null is not stew");
    }
}
