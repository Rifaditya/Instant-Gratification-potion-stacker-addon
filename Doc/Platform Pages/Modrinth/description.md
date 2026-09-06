<p align="center">
  <a href="https://modrinth.com/mod/fabric-api"><img src="https://img.shields.io/badge/Requires-Fabric_API-blue?style=for-the-badge&logo=fabric" alt="Requires Fabric API"></a>
  <a href="https://modrinth.com/mod/dasik-library"><img src="https://img.shields.io/badge/Requires-Dasik_Library-8A2BE2?style=for-the-badge" alt="Requires Dasik Library"></a>
  <a href="https://modrinth.com/mod/ig-stack-size-adjuster"><img src="https://img.shields.io/badge/Requires-Stack_Size_Adjuster-blue?style=for-the-badge" alt="Requires Stack Size Adjuster"></a>
  <img src="https://img.shields.io/badge/Language-Java_25-orange?style=for-the-badge&logo=java" alt="Java 25">
  <img src="https://img.shields.io/badge/License-GPLv3-green?style=for-the-badge" alt="License GPLv3">
  <img src="https://img.shields.io/badge/Minecraft-26.2+-brightgreen?style=for-the-badge" alt="Minecraft 26.2+">
</p>

# 🧪 Potion Stacker Addon

> **"Consolidate Your Alchemy. Stack Potions and Reclaim Your Inventory."**

> [!NOTE]
> **1 Jar 1 Version Policy:** I build **1 dedicated JAR for each Minecraft version** (e.g. MC 26.2, MC 26.3). Please download the exact build that matches your Minecraft installation.
> <br><br>
> **Dependency Requirement:** For modern Minecraft 26.x releases (26.2, 26.3+), this mod requires **Fabric API**, **Dasik Library** (`v1.8.2+`), and **[Stack Size Adjuster](https://modrinth.com/mod/ig-stack-size-adjuster)** (`v1.4.10+26.2`).

Few things in vanilla Minecraft are as frustrating as preparing for a dangerous boss raid or trial chamber, only to discover that every single potion hogs an entire inventory slot. You are forced to choose between bringing essential healing potions, combat buffs, weapons, or collecting spoils and treasure.

**Potion Stacker Addon** solves alchemy inventory clutter permanently. As an official addon for **Stack Size Adjuster**, it enables full stackability for all regular potions, splash potions, lingering potions, and water bottles up to 16, 64, or any custom limit—with flawless empty bottle returns and brewing stand parity!

Part of the **Instant Gratification Collection** — mods that respect the player's time.

---

## ✨ Features

### 🧪 Universal Potion Stacking
Stack all liquid alchemy bottles neatly in your hotbar, backpacks, and chests:
- **Regular Potions**: Instant Health, Speed, Regeneration, Fire Resistance, Strength, and all standard brews.
- **Splash & Lingering Potions**: Stack throwable combat potions for rapid-fire deployment during boss battles.
- **Water Bottles & Bases**: Awkward Potions, Thick Potions, Mundane Potions, and pure Water Bottles stack smoothly for streamlined alchemy brewing sessions.

### 🍶 Safe Empty Glass Bottle Handling
- Drinking from a stacked potion decrements the stack count by 1 and deposits an empty glass bottle into your inventory.
- If your inventory is completely full, the empty bottle drops safely at your feet rather than voiding or duplicating.
- Throwing splash potions naturally shatters the glass as in vanilla gameplay!

### ⚗️ Brewing Stand & Hopper Compatibility
- Place stacked water bottles and potions directly into brewing stand slots.
- Compatible with automated hopper brewing lines and alchemy contraptions without jamming or glitching vanilla brewing progress bars.

### 🍲 Smart Built-in Stew Fallback
- Includes built-in support for stacking stews (mushroom stew, rabbit stew, beetroot soup, suspicious stew).
- **Intelligent Coexistence**: If **Stew Stacker Addon** is installed, Potion Stacker automatically defers all stew handling to avoid mod conflicts or duplicate overrides.

### 🛡️ 32-Bit Signed Integer Overflow Guard
- Stacking limits can be set from `1` up to `2,147,483,647`.
- Features an automated safety ceiling warning above `39,768,215` to protect Double Chest save files from signed 32-bit integer overflow deletion bugs.

### 📡 Real-Time Client Inventory Sync
- Automatically broadcasts configured limits to connecting players via `PotionLimitSyncPayload`.
- Updates all open container and player inventory screens instantly when GameRules change in-game with zero world reload!

---

## 📊 Quick Reference & Mechanics Matrix

| Item Category | Supported Items | Default Stack Limit | Maximum Safe Limit | Tuning GameRule |
| :--- | :--- | :---: | :---: | :--- |
| **Drinkable Potions** | All vanilla & modded `PotionItem` bottles | **`16`** | `39,768,215` | `potion-stacker-addon:potion_limit` |
| **Splash Potions** | Splash potions of all effect types | **`16`** | `39,768,215` | `potion-stacker-addon:potion_limit` |
| **Lingering Potions** | Lingering area-of-effect potions | **`16`** | `39,768,215` | `potion-stacker-addon:potion_limit` |
| **Water & Bases** | Water Bottles, Awkward, Mundane, Thick | **`16`** | `39,768,215` | `potion-stacker-addon:potion_limit` |
| **Stews (Fallback)** | Mushroom, Rabbit, Beetroot, Suspicious | **`16`** | `39,768,215` | `potion-stacker-addon:stew_limit` |

---

## 🚀 In-Game Commands & Quick Start

Potion Stacker Addon uses native Minecraft `/gamerule` commands with tab completion:

```text
/gamerule potion-stacker-addon:potion_limit <stack_size>   → Set maximum stack limit for potions (e.g. 16, 64)
/gamerule potion-stacker-addon:stew_limit <stack_size>     → Set fallback stack limit for stews (e.g. 16, 64)
```

---

## ⚙️ Configuration (Native GameRules)

> [!IMPORTANT]
> **💡 Config vs. In-Game GameRules:** The global configuration file (`config/potion-stacker-addon.json`) only defines default values for newly created worlds. In existing worlds, change settings in-game via the **Edit Game Rules** UI screen or the `/gamerule` command.

| GameRule Name | Type | Default | Valid Range | Description |
| :--- | :---: | :---: | :---: | :--- |
| `potion-stacker-addon:potion_limit` | `Integer` | `16` | `1` to `2147483647` | Maximum stack size for all potions, splash potions, lingering potions, and water bottles. |
| `potion-stacker-addon:stew_limit` | `Integer` | `16` | `1` to `2147483647` | Maximum stack size for stews and beetroot soup (fallback when Stew Stacker Addon is absent). |

---

## 📖 In-Depth How-To & Operational Playbook

### 1. Drop-In Setup & Requirements
1. Ensure **Stack Size Adjuster** (`v1.4.10+26.2`), **Fabric API**, and **Dasik Library** are present in your `mods` folder.
2. Drop `potion-stacker-addon-*.jar` into `mods/` and launch the game.
3. Open any chest or brewing stand to immediately begin stacking potions up to 16!

### 2. Live In-Game Tuning vs. Global Template
- **For New Worlds**: Edit `config/potion-stacker-addon.json` or configure options in ModMenu + YACL.
- **For Existing Worlds**: Open your world and type `/gamerule potion-stacker-addon:potion_limit 64`. Your inventory and containers refresh dynamically with full 64-potion stacks!

### 3. Combat & Raid Preparation
- Stack 16 Splash Potions of Healing II into a single hotbar slot for instant rapid healing during intense Trial Chamber or Warden encounters.
- Carry a single stack of 16 Fire Resistance potions during Nether mining trips, freeing up your entire inventory for ores and ancient debris.

### 4. Automated Alchemy Brewing
- Feed stacks of water bottles through top hoppers into brewing stands.
- Brewing stands process the bottles and produce stacked finished potions without jamming item slots.

### 5. Managing Empty Bottle Returns
- Drinking from a potion stack returns an empty glass bottle into your inventory.
- Keep at least 1 free inventory slot open when drinking on the move to catch the empty bottle, or let it collect at your feet to recycle into your next brewing batch.

---

## 🧩 Recommended Sister Mods

If you enjoy **Potion Stacker Addon**, these companion mods from the **Instant Gratification Collection** plug in seamlessly:

* 📦 [**Stack Size Adjuster**](https://modrinth.com/mod/ig-stack-size-adjuster): The core foundational engine that unlocks customizable stack limits across all Minecraft items.
* 🍲 [**Stew Stacker Addon**](https://modrinth.com/mod/ig-stew-stacker-addon): Stack mushroom stew, rabbit stew, beetroot soup, and suspicious stews up to 16 or 64.
* 🗃️ [**Item Clumps**](https://modrinth.com/mod/ig-item-clumps): Aggregates dropped items into single holographic clumps to eliminate ground entity lag.

> 🌟 *Explore the full [**Instant Gratification Collection**](https://modrinth.com/collection/instant-gratification) for more high-convenience enhancements.*

---

## ☕ Support

If you enjoy the **Instant Gratification Collection**, consider fueling future development!

<p align="center">
  <a href="https://ko-fi.com/dasikigaijin/tip"><img src="https://img.shields.io/badge/Ko--fi-Support%20Me-FF5E5B?style=for-the-badge&logo=ko-fi&logoColor=white" alt="Ko-fi"></a>
  <a href="https://sociabuzz.com/dasikigaijin/tribe"><img src="https://img.shields.io/badge/SocioBuzz-Local_Support-7BB32E?style=for-the-badge" alt="SocioBuzz"></a>
  <a href="https://saweria.co/DasikIgaijinn"><img src="https://img.shields.io/badge/Saweria-Local_Support-FFA500?style=for-the-badge" alt="Saweria"></a>
</p>

> [!NOTE]
> **🇮🇩 Indonesian Users:** SocioBuzz and Saweria support local payment methods (Gopay, OVO, Dana, etc.) if you want to support me without using PayPal/Ko-fi!

> [!TIP]
> **Dedicated Server Hosting Partner:**
> Looking for a reliable server to play with friends? Check out **BisectHosting** for 1-click modpack installations, automated backups, and 24/7 dedicated customer support.

---

## 📜 Credits & Modpack Permissions

| Property | Information |
| :--- | :--- |
| **Creator / Author** | **Dasik** (Rifaditya) |
| **Collection** | Instant Gratification Collection |
| **License** | [GNU General Public License v3.0 (GPLv3)](https://www.gnu.org/licenses/gpl-3.0.html) |
| **Source Code** | [GitHub - Rifaditya/Instant-Gratification-potion-stacker-addon](https://github.com/Rifaditya/Instant-Gratification-potion-stacker-addon) |
| **Issue Tracker** | [GitHub Issues](https://github.com/Rifaditya/Instant-Gratification-potion-stacker-addon/issues) |
| **Documentation / Wiki** | [GitHub Wiki](https://github.com/Rifaditya/Instant-Gratification-potion-stacker-addon/wiki) |

> [!IMPORTANT]
> **📦 Modpack Permissions & Distribution:**<br>
> You are fully welcome to include this mod in any modpack on any platform! However, the mod file must be downloaded directly through official distribution channels (**Modrinth** or **CurseForge**). Re-uploading, mirroring, or redistributing the original mod JAR to third-party mirror sites, scraper portals, or unauthorized launchers is strictly prohibited.
> <br><br>
> **⚖️ License & Fork Guidelines (No Zero-Change Re-uploads):**<br>
> This project is open-source under the **GNU GPLv3**. You are fully encouraged to inspect the code, learn from it, and fork the repository to create genuine modifications, substantial feature expansions, or community ports—provided your project remains open-source under GPLv3 with proper attribution.<br>
> **However, straight 1:1 re-uploads, clone forks with no meaningful functional changes, or re-publishing identical builds under different project names (e.g. to farm downloads or rewards) are strictly forbidden.**

---

<p align="center">
  <strong>Made with ❤️ for the Minecraft community</strong><br>
  <em>Part of the Instant Gratification Collection</em>
</p>
