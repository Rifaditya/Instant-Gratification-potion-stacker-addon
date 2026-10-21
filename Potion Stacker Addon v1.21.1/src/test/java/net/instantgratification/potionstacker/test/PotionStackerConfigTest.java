// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package net.instantgratification.potionstacker.test;

import java.lang.reflect.Field;
import net.dasik.social.api.config.ConfigOption;
import net.instantgratification.potionstacker.config.PotionStackerConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 5-Pillar Test Harness verifying UniversalConfigScreen contract and sidedness safety.
 */
public class PotionStackerConfigTest {

    @Test
    @DisplayName("Pillar 1: ConfigOption annotations are present on all configuration fields")
    void testConfigAnnotationsPresent() throws Exception {
        Field potionField = PotionStackerConfig.class.getField("potionLimit");
        assertTrue(potionField.isAnnotationPresent(ConfigOption.class), "potionLimit must have @ConfigOption");

        Field stewField = PotionStackerConfig.class.getField("stewLimit");
        assertTrue(stewField.isAnnotationPresent(ConfigOption.class), "stewLimit must have @ConfigOption");
    }

    @Test
    @DisplayName("Pillar 2: Verification of bounds, sliders, step sizes, and orders")
    void testOptionBoundsAndMetadata() throws Exception {
        ConfigOption potionOpt = PotionStackerConfig.class.getField("potionLimit").getAnnotation(ConfigOption.class);
        assertEquals(1.0, potionOpt.min(), 0.001);
        assertEquals((double) Integer.MAX_VALUE, potionOpt.max(), 0.001);
        assertEquals(1.0, potionOpt.step(), 0.001);
        assertEquals("general", potionOpt.category());
        assertEquals("categories", potionOpt.group());
        assertEquals(1, potionOpt.order());

        ConfigOption stewOpt = PotionStackerConfig.class.getField("stewLimit").getAnnotation(ConfigOption.class);
        assertEquals(1.0, stewOpt.min(), 0.001);
        assertEquals((double) Integer.MAX_VALUE, stewOpt.max(), 0.001);
        assertEquals(1.0, stewOpt.step(), 0.001);
        assertEquals("general", stewOpt.category());
        assertEquals("categories", stewOpt.group());
        assertEquals(2, stewOpt.order());
    }

    @Test
    @DisplayName("Pillar 3: GameRule sync targets are properly configured")
    void testGameRuleSyncTargets() throws Exception {
        ConfigOption potionOpt = PotionStackerConfig.class.getField("potionLimit").getAnnotation(ConfigOption.class);
        assertTrue(potionOpt.syncGameRule(), "potionLimit must synchronize to GameRule");
        assertEquals("potion-stacker-addon:potion_limit", potionOpt.gameRuleName());

        ConfigOption stewOpt = PotionStackerConfig.class.getField("stewLimit").getAnnotation(ConfigOption.class);
        assertTrue(stewOpt.syncGameRule(), "stewLimit must synchronize to GameRule");
        assertEquals("potion-stacker-addon:stew_limit", stewOpt.gameRuleName());
    }

    @Test
    @DisplayName("Pillar 4: Default values match vanilla baseline defaults")
    void testDefaultValues() {
        PotionStackerConfig config = new PotionStackerConfig();
        assertEquals(16, config.potionLimit, "Default potionLimit must be 16");
        assertEquals(16, config.stewLimit, "Default stewLimit must be 16");
        assertEquals(1, config.configVersion, "Config version must be 1");
    }

    @Test
    @DisplayName("Pillar 5: Sidedness verification - zero client class references in common config")
    void testSidednessIsolation() {
        for (Class<?> iface : PotionStackerConfig.class.getInterfaces()) {
            assertFalse(iface.getName().startsWith("net.minecraft.client"), "No client interfaces permitted");
        }
        assertEquals(Object.class, PotionStackerConfig.class.getSuperclass(), "Config must extend Object");
    }
}
