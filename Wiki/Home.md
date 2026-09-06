# 🧪 Instant Gratification: Potion Stacker Addon Wiki

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **Repository Source Disclaimer**: The documentation in this Wiki reflects the **current source code state in the repository**, which may include recent unreleased commits or developmental features ahead of public release builds on CurseForge and Modrinth.

Welcome to the official technical documentation for **Instant Gratification: Potion Stacker Addon**. Engineered for Minecraft Fabric as a specialized high-performance expansion for **Stack Size Adjuster**, this mod liberates players from unstackable bottle clutter by introducing configurable stack limits for all potion items (regular potions, splash potions, lingering potions, and water bottles) and emergency fallback stacking for soups and stews.

---

## 🧭 Multi-Version Documentation Portals

Potion Stacker Addon is developed under the **1 Jar 1 Version Policy** across distinct Minecraft version anchors. Select your target game version below to access dedicated, isolated documentation trees:

| Version Anchor | Target Minecraft Release | Mod SemVer | Fabric Loader | Dedicated Version Portal |
| :--- | :--- | :---: | :---: | :--- |
| **Minecraft 26.2** | `MC 26.1.2` / `26.2` | `1.1.3+26.2` | `>=0.19.1` | [[👉 Enter Minecraft 26.2 Documentation Portal|26.2-Home]] |
| **Minecraft 26.3** | `MC 26.3-snapshot-6` / `26.3` | `1.1.3+26.3` | `>=0.19.3` | [[👉 Enter Minecraft 26.3 Documentation Portal|26.3-Home]] |

---

## ⚡ Core Philosophy & Architectural Pillars

The **Instant Gratification (IG)** series is founded upon a single engineering invariant: *"Respect the Player's Time, Not the Game's Rules."* Potion Stacker Addon delivers on this promise through five core architectural pillars:

1. **Liberated Inventory Space**:
   Since the introduction of brewing in Beta 1.9, potions have consumed one entire inventory slot per bottle. Potion Stacker Addon elevates the default stack size to `16` (and supports unbounded freedom up to $2,147,483,647$), drastically condensing hotbar and chest footprints.

2. **Ergonomic Brewing Stand & Container Mechanics**:
   Brewing stands natively enforce single-bottle processing per brew slot. When shift-clicking or hopper-feeding into a brewing stand, the engine smoothly deposits exactly 1 bottle per slot while leaving remaining stacks in player inventory or source hoppers.

3. **Live Server-Client Network Synchronization**:
   Powered by Fabric networking and `PotionLimitSyncPayload`, whenever an operator alters stack limits via in-game `/gamerule`, the server immediately broadcasts updated boundaries and calls `broadcastFullState()` on all open player container and inventory menus, eliminating client ghost items.

4. **Intelligent Addon Coexistence**:
   When paired with `stew-stacker-addon`, Potion Stacker Addon automatically detects its sibling mod (`FabricLoader.getInstance().isModLoaded("stew-stacker-addon")`) and defers all stew/soup handling to prevent configuration collisions.

5. **Zero Mixin Overhead**:
   Unlike legacy mods that inject high-frequency mixins into item tick loops, Potion Stacker Addon uses a pure event-driven and API-driven design, registering a single `CustomStackSizeOverride` directly into Stack Size Adjuster's `StackSizeManager`.

---

## 📊 Quick Reference: Default GameRule Matrix

| GameRule Identifier | Type | Default Value | Valid Range | Target Category / Items |
| :--- | :---: | :---: | :---: | :--- |
| `potion-stacker-addon:potion_limit` | Integer | `16` | 1 to 2,147,483,647 | Regular Potions, Splash Potions, Lingering Potions, Water Bottles |
| `potion-stacker-addon:stew_limit` | Integer | `16` | 1 to 2,147,483,647 | Mushroom Stew, Rabbit Stew, Beetroot Soup, Suspicious Stew |

---

## 📚 Essential Documentation Hubs

* [[📊 Version Compatibility Matrix|Version-Compatibility]]: Complete lifecycle support, Loom environments, Java 25 requirements, and library dependencies.
* [[🔧 Troubleshooting & FAQ Guide|Troubleshooting-and-FAQ]]: Brewing stand mechanics, hopper routing, container menu syncing, and multi-addon priority resolution.
* [[🛠️ Developer Setup & Build Guide|Developer-Setup-and-Building]]: Unified Gradle 9.3+ instructions, Loom compiler flags, API registration hooks, and client-server sync payloads.

---

## ⚖️ License & Provenance

* **Author & Lead Architect**: Dasik (Rifaditya)
* **License**: GNU General Public License v3.0 (GPLv3)
* **Design Philosophy**: Instant Gratification (IG)
* **Upstream Repository**: [GitHub Source Repository](https://github.com/Rifaditya/Instant-Gratification-potion-stacker-addon)
