// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package net.instantgratification.potionstacker.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * PotionStackerSidednessContractTest: Pillar 5 Sidedness & Mixin Contract Verification Suite
 *
 * Verifies:
 * - Zero unguarded net.minecraft.client.* or com.mojang.blaze3d.* references in common sources and bytecode.
 * - Single-line GNU GPLv3 license headers on line 1 across all Java source files.
 * - Total absence of legacy ModVersionGuard.java and zero Class.forName calls in PotionStackerFabric.java.
 * - Integrity of fabric.mod.json environment (*), entrypoints, and identifiers.
 */
public class PotionStackerSidednessContractTest {

    private static final String EXPECTED_LICENSE_HEADER = "// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3";

    @Test
    @DisplayName("Pillar 5: Common Sources & Bytecode Contain Zero Unguarded Client References")
    void testCommonSourceSidednessIsolation() throws IOException {
        Path srcRoot = Paths.get("src/main/java");
        assertTrue(Files.exists(srcRoot), "src/main/java directory must exist");

        try (Stream<Path> stream = Files.walk(srcRoot)) {
            List<Path> javaFiles = stream.filter(p -> p.toString().endsWith(".java")).toList();
            assertFalse(javaFiles.isEmpty(), "Java source files must exist");

            for (Path file : javaFiles) {
                String normalized = file.toString().replace('\\', '/');

                // Skip dedicated client entrypoints and client packages
                if (normalized.contains("/client/") || normalized.endsWith("Client.java")) {
                    continue;
                }

                String content = Files.readString(file, StandardCharsets.UTF_8);

                // ModMenu / Client GUI integration classes carry client annotations
                if (content.contains("@Environment(EnvType.CLIENT)")) {
                    continue;
                }

                assertFalse(content.contains("net.minecraft.client."),
                        "Forbidden client package reference in common source file: " + normalized);
                assertFalse(content.contains("com.mojang.blaze3d."),
                        "Forbidden Blaze3D reference in common source file: " + normalized);
            }
        }

        Path classesRoot = Paths.get("build/classes/java/main");
        if (Files.exists(classesRoot)) {
            try (Stream<Path> stream = Files.walk(classesRoot)) {
                List<Path> classFiles = stream.filter(p -> p.toString().endsWith(".class")).toList();
                assertFalse(classFiles.isEmpty(), "build/classes/java/main must contain compiled class files");
                for (Path classFile : classFiles) {
                    String normalized = classFile.toString().replace('\\', '/');
                    if (normalized.contains("/client/")
                            || normalized.endsWith("Client.class")
                            || normalized.contains("ModMenuIntegration")) {
                        continue;
                    }
                    String rawBytes = new String(Files.readAllBytes(classFile), StandardCharsets.ISO_8859_1);
                    assertFalse(rawBytes.contains("net/minecraft/client/"),
                            "Forbidden net/minecraft/client/ reference in common bytecode: " + normalized);
                    assertFalse(rawBytes.contains("com/mojang/blaze3d/"),
                            "Forbidden com/mojang/blaze3d/ reference in common bytecode: " + normalized);
                }
            }
        }
    }

    @Test
    @DisplayName("Pillar 5: Exact Single-Line GPLv3 License Header Present On Line 1")
    void testLicenseHeaders() throws IOException {
        Path[] roots = new Path[] {
                Paths.get("src/main/java"),
                Paths.get("src/test/java")
        };

        for (Path root : roots) {
            assertTrue(Files.exists(root), "Source root must exist: " + root.toAbsolutePath());
            try (Stream<Path> stream = Files.walk(root)) {
                List<Path> javaFiles = stream.filter(p -> p.toString().endsWith(".java")).toList();
                assertFalse(javaFiles.isEmpty(), "Java files must exist in: " + root);

                for (Path file : javaFiles) {
                    List<String> lines = Files.readAllLines(file, StandardCharsets.UTF_8);
                    assertFalse(lines.isEmpty(), "Java source file must not be empty: " + file);
                    String line1 = lines.get(0).trim();
                    assertEquals(EXPECTED_LICENSE_HEADER, line1,
                            "Missing or invalid GPLv3 license header on line 1 in: " + file.toString().replace('\\', '/'));
                }
            }
        }
    }

    @Test
    @DisplayName("Pillar 5: Zero ModVersionGuard and Zero Class.forName in Entrypoint")
    void testZeroModVersionGuard() throws IOException {
        Path guardPath = Paths.get("src/main/java/net/instantgratification/potionstacker/util/ModVersionGuard.java");
        assertFalse(Files.exists(guardPath), "Obsolete ModVersionGuard.java must not exist");

        Path entrypointPath = Paths.get("src/main/java/net/instantgratification/potionstacker/PotionStackerFabric.java");
        assertTrue(Files.exists(entrypointPath), "PotionStackerFabric.java must exist");
        String entrypointContent = Files.readString(entrypointPath, StandardCharsets.UTF_8);
        assertFalse(entrypointContent.contains("ModVersionGuard"),
                "PotionStackerFabric.java must not reference ModVersionGuard");
        assertFalse(entrypointContent.contains("Class.forName"),
                "PotionStackerFabric.java must not invoke Class.forName");
    }

    @Test
    @DisplayName("Pillar 5: fabric.mod.json Environment and Entrypoint Contract")
    void testFabricModJsonContract() throws IOException {
        Path modJsonPath = Paths.get("src/main/resources/fabric.mod.json");
        assertTrue(Files.exists(modJsonPath), "fabric.mod.json must exist");

        String json = Files.readString(modJsonPath, StandardCharsets.UTF_8);
        assertTrue(json.contains("\"environment\": \"*\""), "Environment must be '*'");
        assertTrue(json.contains("\"id\": \"potion-stacker-addon\""), "Mod ID must be 'potion-stacker-addon'");
        assertTrue(json.contains("net.instantgratification.potionstacker.PotionStackerFabric"),
                "Main entrypoint must be PotionStackerFabric");
        assertTrue(json.contains("net.instantgratification.potionstacker.PotionStackerFabricClient"),
                "Client entrypoint must be PotionStackerFabricClient");
    }
}
