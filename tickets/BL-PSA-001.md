# 🎫 [BL-PSA-001] Multi-Era Anchor Porting: Potion Stacker Addon

- **Ticket ID**: `[BL-PSA-001]`
- **Category**: `[FEATURE]`
- **Priority**: `[HIGH]`
- **Scope**: `All Anchors` (`1.20.1`, `1.21.1`, `1.21.11`, `26.1`, `26.2`, `26.3`)
- **Status**: `✅ RESOLVED`
- **Target Repository / Root**: `Instant Gratification Collection/Potion Stacker Addon`

---

## 🎯 1. Problem Statement & Player Impact
Currently, this mod only exists on modern baseline anchors (MC 26.2 and MC 26.3). Players playing on legacy long-term support versions (MC 1.20.1, MC 1.21.1, and MC 1.21.11) or modern transitional releases (MC 26.1.2) cannot use this mod. In accordance with the studio's "1 Jar 1 Version Policy" and Multi-Era Anchor Parity Law, this mod must be ported across all missing anchors to ensure zero orphaned ports.

In-game behavior before vs. after:
- **Before**: Mod is unavailable on MC 1.20.1, MC 1.21.1, MC 1.21.11, and MC 26.1.2.
- **After**: Players on all 6 version anchors experience 100% identical Stackable potion item entities and drinking consumption mechanics, GameRule synchronization, and configuration controls.

## 🔬 2. Architectural Blueprint & Target Classes
- Subproject Directory Structure:
  - `<Mod Title> v1.20.1/` (targeting Minecraft 1.20.1, Java 17)
  - `<Mod Title> v1.21.1/` (targeting Minecraft 1.21.1, Java 21)
  - `<Mod Title> v1.21.11/` (targeting Minecraft 1.21.11, Java 21)
  - `<Mod Title> v26.1.2/` (targeting Minecraft 26.1.2, Java 25)
- Core Classes to Port & Adapt:
  - `PotionItemMixin.java`, `PotionStackerConfig.java`, `PotionStackerGameRules.java`
  - `DynamicGameRuleManager` integration and config synchronizers
- Build Toolchain Scaffolding per Anchor:
  - `build.gradle` (Loom configuration, dependencies, repository blocks)
  - `gradle.properties` (exact version tags, `archives_base_name`, `mod_version`)
  - `settings.gradle` and `fabric.mod.json`

## ⚓ 3. Multi-Era Anchor Parity Specifications
- **Modern Sovereign Anchors (Java 25, Loom 1.15+, No Mappings Block)**:
  - `MC 26.1 / 26.1.2`: Java 25, Loom 1.15+, `Identifier.fromNamespaceAndPath`, `dasik-library` 26.1.
  - `MC 26.2`: Java 25, Loom 1.15+, active baseline.
  - `MC 26.3`: Java 25, Loom 1.15+, `minecraft_version=26.3-snapshot-6`, `fabric_version=0.156.1+26.3`.
- **Older Anchors (Mojang Mappings, Java 21 / 17)**:
  - `MC 1.21.11`: Java 21, Loom 1.15-SNAPSHOT (`fabric-loom-remap`), Mojang mappings, `Identifier.of`, `Optional<T>` CompoundTag, relocated entity packages, SDL3.
  - `MC 1.21.1`: Java 21, Loom 1.10+, Mojang mappings, `Identifier.of`, `DataComponents`, native `Attributes.SCALE`.
  - `MC 1.20.1`: Java 17, Loom 1.4-1.10, Mojang mappings, `new Identifier`, primitive NBT `CompoundTag`, `FabricItemSettings`, `GameRules.Category` enum.

## 🛡️ 4. Edge Cases, Collisions & Failure Modes
- Knot ClassLoader Runtime Safety: never call deobfuscated reflection; declare version bounds strictly in `fabric.mod.json`.
- Missing DasikLibrary: declare exact version parameter `${project.dasik_library_version}` in `gradle.properties`.
- Dedicated Server Crash Prevention: 0 client classes (`net.minecraft.client.*`) in common code.
- Anti-Snapshot Law: snapshot tags permanently quarantined; official releases target release IDs only.

## 🚀 5. Implementation Steps (Code-Level Plan)
1. Scaffold missing subproject directories using studio template standards.
2. Adapt mixins and source code to anchor-specific vanilla API shifts.
3. Wire 5-Pillar test suite in `src/test/java/` per anchor.
4. Execute `./gradlew test --no-daemon` and `./gradlew build --no-daemon`.
5. Execute Mandatory Universal 4-Point Distribution:
   - Local Archive: `<Mod>/Archive Jar of all versions/`
   - Central Hub Archive: `minecraft-mod-release-hub/archives/`
   - External Vault: `D:\`
   - Launcher Test Profile: `.minecraft/mods`
6. Register queued version in `RELEASE_QUEUE.md` (`- [ ]`) and `CHANGELOG.md`.

## 🏁 6. 5-Pillar Verification Checklist
- [x] **Pillar 1 (Chaos Fuzzing)**: Chaos property fuzzing passes 10k-50k iterations.
- [x] **Pillar 2 (Concurrency Load)**: Multi-threaded state stress test across 50 virtual threads.
- [x] **Pillar 3 (Brigadier AST)**: Brigadier command tree AST and permissions validated headlessly.
- [x] **Pillar 4 (GameTest)**: In-engine headless assertions pass cleanly.
- [x] **Pillar 5 (Sidedness & Hygiene)**: Sidedness contract asserts 0 client imports in common code; single-line GPLv3 headers.
- [x] **Anchor Compilation**: Clean `./gradlew test build` across all 6 anchors (`1.20.1`, `1.21.1`, `1.21.11`, `26.1.2`, `26.2`, `26.3`).
