<p align="center">
  <a href="https://discord.gg/EV99bgAFqb"><img src="https://img.shields.io/badge/Discord-Join_Community-5865F2?style=for-the-badge&logo=discord&logoColor=white" alt="Join Discord"></a>
  <a href="https://modrinth.com/mod/fabric-api"><img src="https://img.shields.io/badge/Requires-Fabric_API-blue?style=for-the-badge&logo=fabric" alt="Requires Fabric API"></a>
  <img src="https://img.shields.io/badge/Environment-Server_&_Client-success?style=for-the-badge" alt="Server & Client">
  <img src="https://img.shields.io/badge/Language-Java_25-orange?style=for-the-badge&logo=java" alt="Java 25">
  <img src="https://img.shields.io/badge/License-GPLv3-green?style=for-the-badge" alt="License GPLv3">
  <img src="https://img.shields.io/badge/Minecraft-26.2+-brightgreen?style=for-the-badge" alt="Minecraft 26.2+">
</p>

# 🧪 Potion Stacker Addon

> **"Brew More, Clutter Less. Stack Drinkable, Splash, and Lingering Potions Safely."**

---

## 📖 Introduction

Ever since alchemy was introduced to Minecraft, potions have remained stubbornly limited to an unstackable single item per inventory slot. Preparing for an arduous boss battle against the Wither or Ender Dragon, navigating deep Ancient Cities, or exploring Nether Fortresses turns your inventory into a cluttered mess where a standard combat buff loadout (Speed, Fire Resistance, Strength, Regeneration, Healing) completely wipes out your available bag space.

**Potion Stacker Addon** solves the alchemy storage dilemma under the **Instant Gratification** design philosophy. It seamlessly stacks standard Drinkable Potions, Splash Potions, and Lingering Potions up to **16** (or custom limits) in your inventory, chests, and brewing stands. Engineered with smooth split-stack drinking mechanics, automatic empty glass bottle returns, dispenser firing compatibility, and client-server sync, your potion combat experience becomes effortless and organized.

> [!NOTE]
> **1 Jar 1 Version Policy:** I build **1 dedicated JAR for each Minecraft version** (e.g. MC 26.2, MC 26.3). Please download the exact build that matches your Minecraft installation.
> 
> **Addon & Standalone Synergy:** Functions as an optional companion addon for **Stack Size Adjuster** or as a 100% self-contained standalone potion mod!

Part of the **Instant Gratification Collection** — mods that respect the player's time.

---

## ✨ Features

### 🍶 Safe Potion Stacking (Up to 16 by Default)
- **Unified Alchemy Stacking:** Drinkable potions, Splash Potions, and Lingering Potions stack up to **16** by default (configurable up to **64**).
- **Matching NBT & Component Validation:** Potions only stack if they possess identical potion effects, durations, and custom amplification components (`DataComponents.POTION_CONTENTS`), preventing accidental mixing of healing and poison.

### 💨 Fluid Combat Drinking & Bottle Management
- **Single-Bottle Consumption:** Drinking from a potion stack consumes exactly 1 dose, decrementing the stack count while granting you full status effects.
- **Smart Bottle Recovery:** The returned empty Glass Bottle automatically attempts to stack with existing empty bottles in your inventory. If your inventory is completely full, it cleanly drops at your feet without swallowing items.
- **Dispenser & Dropper Integration:** Dispensers loaded with splash potion stacks fire exactly 1 splash potion per redstone pulse, enabling compact, high-capacity automated defensive turret traps.

### ⚗️ Brewing Stand Automated Batch Loading
- Place stacks of awkward potions directly into brewing stand slots. Brew an entire batch of 16 potions simultaneously with a single nether wart, glowstone dust, or fermented spider eye!

---

## 📊 Inventory Combat Loadout Comparison

| Combat Scenario | Vanilla Inventory Footprint | With Potion Stacker Addon |
| :--- | :---: | :---: |
| **Wither Fight (12 Healing II Potions)** | 12 inventory slots | **1 single inventory slot** |
| **Nether Exploration (8 Fire Res Potions)** | 8 inventory slots | **1 single inventory slot** |
| **PvP Loadout (4 Speed II + 4 Strength II)** | 8 inventory slots | **2 inventory slots** |
| **Ender Dragon Lingering Breath Harvest** | 16 empty bottles + 16 lingering potions | **2 compact stacks** |

---

## ⚙️ Native GameRules & Configuration

Configure potion stacking rules in-game:

| GameRule Key | Type | Default | Valid Range | Description |
| :--- | :---: | :---: | :---: | :--- |
| `potion_stacker:max_drinkable_stack` | `Integer` | `16` | `1 – 64` | Maximum stack size for drinkable glass bottle potions. |
| `potion_stacker:max_splash_stack` | `Integer` | `16` | `1 – 64` | Maximum stack size for throwable splash potions. |
| `potion_stacker:max_lingering_stack` | `Integer` | `16` | `1 – 64` | Maximum stack size for lingering area-of-effect potions. |
| `potion_stacker:empty_bottle_behavior` | `Enum` | `INVENTORY_OR_DROP` | `INVENTORY / DROP / VOID` | Destination for empty glass bottles upon drinking. |

---

## 📖 In-Depth How-To & Gameplay Playbook

### Step 1: Installation & Setup
1. Install **Fabric Loader** and **Fabric API** for Minecraft 26.2+ / 26.3+.
2. Place `potion-stacker-addon-x.y.z+<version>.jar` into your `mods/` directory.
3. Launch Minecraft. Potions of identical type in your chests and inventory will now stack automatically when clicked together!

### Step 2: Optimizing Combat Hotbars
- Consolidate your combat bag: place a stack of 8 Splash Potions of Healing II on your hotbar key `8`, and a stack of 4 Swiftness II potions on key `9`.
- Free up 10+ inventory slots for mob drops, ancient city loot, and armor switches!

---

## ☕ Support & Creator Community

I am an independent solo developer creating lightweight, vanilla-enhancing mods that respect your time and game performance. If Potion Stacker Addon streamlines your survival, consider supporting future development:

<p align="center">
  <a href="https://ko-fi.com/rifaditya"><img src="https://img.shields.io/badge/Ko--fi-Support_on_Ko--fi-F16061?style=for-the-badge&logo=ko-fi&logoColor=white" alt="Support on Ko-fi"></a>
  <a href="https://sociabuzz.com/rifaditya"><img src="https://img.shields.io/badge/SocioBuzz-Support_Creator-00A651?style=for-the-badge" alt="Support on SocioBuzz"></a>
  <a href="https://saweria.co/rifaditya"><img src="https://img.shields.io/badge/Saweria-Support_Local-FFA500?style=for-the-badge" alt="Support on Saweria"></a>
</p>

> [!TIP]
> **🇮🇩 Indonesian Local Payment Note:** Indonesian supporters can also support my development work directly using local payment options (**GoPay, OVO, Dana, QRIS, LinkAja**) via **Saweria** or **SocioBuzz**!

Join our official Discord community for live development updates, early test builds, and friendly support:
- 💬 **Discord Community:** [https://discord.gg/EV99bgAFqb](https://discord.gg/EV99bgAFqb)

---

## 📜 Metadata & Permissions

| Property | Value |
| :--- | :--- |
| **Mod Name** | Potion Stacker Addon |
| **Namespace / Mod ID** | `potion_stacker` |
| **License** | GNU General Public License v3.0 (GPLv3) |
| **Side Safety** | Server & Client (Synchronized) |
| **Source Code** | [GitHub Repository](https://github.com/Rifaditya/Instant-Gratification-potion-stacker-addon) |
| **Issue Tracker** | [GitHub Issues](https://github.com/Rifaditya/Instant-Gratification-potion-stacker-addon/issues) |

> [!IMPORTANT]
> **📦 Modpack Permissions & Distribution:**<br>
> You are fully welcome to include this mod in any modpack on any platform! However, the mod file must be downloaded directly through official distribution channels (**Modrinth** or **CurseForge**). Re-uploading, mirroring, or redistributing the original mod JAR to third-party mirror sites, scraper portals, or unauthorized launchers is strictly prohibited.
> <br><br>
> **⚖️ License & Fork Guidelines (No Zero-Change Re-uploads):**<br>
> This project is open-source under the **GNU GPLv3**. You are fully encouraged to inspect the code, learn from it, and fork the repository to create genuine modifications, substantial feature expansions, or community ports—provided your project remains open-source under GPLv3 with proper attribution.<br>
> **However, straight 1:1 re-uploads, clone forks with no meaningful functional changes, or re-publishing identical builds under different project names (e.g. to farm downloads or rewards) are strictly forbidden.**

---

<div align="center">

**Made with ❤️ for the Minecraft community**

*Part of the Instant Gratification Collection*

</div>
