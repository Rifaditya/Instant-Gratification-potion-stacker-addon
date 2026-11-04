<p align="center">
  <a href="https://discord.gg/EV99bgAFqb"><img src="https://img.shields.io/badge/Discord-Join_Community-5865F2?style=for-the-badge&logo=discord&logoColor=white" alt="Join Discord"></a>
  <a href="https://modrinth.com/mod/fabric-api"><img src="https://img.shields.io/badge/Requires-Fabric_API-blue?style=for-the-badge&logo=fabric" alt="Requires Fabric API"></a>
  <a href="https://modrinth.com/mod/dasik-library"><img src="https://img.shields.io/badge/Requires-Dasik_Library-purple?style=for-the-badge" alt="Requires Dasik Library"></a>
  <a href="https://modrinth.com/mod/ig-stack-size-adjuster"><img src="https://img.shields.io/badge/Requires-Stack_Size_Adjuster-teal?style=for-the-badge" alt="Requires Stack Size Adjuster"></a>
  <img src="https://img.shields.io/badge/Environment-Server_&_Client-success?style=for-the-badge" alt="Server & Client">
  <img src="https://img.shields.io/badge/License-GPLv3-green?style=for-the-badge" alt="License GPLv3">
  <img src="https://img.shields.io/badge/Minecraft-1.20.1_to_26.x-brightgreen?style=for-the-badge" alt="Minecraft 1.20.1 to 26.x">
</p>

# 🧪 Potion Stacker Addon

> **"Brew More, Clutter Less. Stack Drinkable, Splash, and Lingering Potions Safely."**

---

## 📖 Introduction

In vanilla Minecraft, alchemy items have remained unstackable since their inception. Preparing for boss encounters against the Wither or Ender Dragon, navigating deep Ancient Cities, or raiding Nether Fortresses turns your inventory into a cluttered mess where a standard combat buff loadout (Speed, Fire Resistance, Strength, Regeneration, Healing) consumes virtually all available slots.

**Potion Stacker Addon** is an official companion addon for **Stack Size Adjuster**, created under the **Instant Gratification** design philosophy. It registers dedicated item override handlers to stack drinkable potions, splash potions, lingering potions, and water bottles up to **16** (or custom limits) in your inventory and storage containers. It also includes built-in stacking for vanilla stews and soups with automatic conflict avoidance if you install **Stew Stacker Addon**.

> [!IMPORTANT]
> **Companion Addon Requirement:** Potion Stacker Addon is designed specifically as an addon for **Stack Size Adjuster**. You must have **Stack Size Adjuster** and **Dasik Library** installed alongside this mod for it to function.

> [!NOTE]
> **1 Jar 1 Version Policy:** I build **1 dedicated JAR for each Minecraft version** (e.g., 1.20.1, 1.21.1, 1.21.11, 26.1.2, 26.2, 26.3). Download the exact build that matches your Minecraft version.

Part of the **Instant Gratification Collection** — mods that respect the player's time.

---

## ✨ Features

### 🍶 Safe Potion Stacking (Default: 16)
- **All Potion Forms Supported:** Standard drinkable potions, splash potions, lingering potions, and water bottles stack up to **16** by default.
- **Component & NBT Safety:** Vanilla item matching ensures potions only stack when their potion contents, effects, and durations are identical.
- **Normal Consumption Mechanics:** Drinking or throwing a potion consumes exactly 1 item from the stack as expected.

### 🍲 Bonus Stew & Soup Stacking (Default: 16)
- Stacks Mushroom Stew, Rabbit Stew, Suspicious Stew, and Beetroot Soup up to **16** by default.
- **Zero-Conflict Handoff:** If you also run **Stew Stacker Addon**, Potion Stacker Addon automatically defers stew handling to that mod to ensure seamless compatibility.

### ⚡ Dynamic Real-Time Client-Server Sync
- Server GameRule modifications synchronize immediately to connected clients over custom network payloads (`PotionLimitSyncPayload`).
- Active container menus and inventories refresh dynamically when limits change without needing a server or world restart.

### 🔓 Uncapped Customization Freedom
- Adheres to the **Freedom Over Anti-Crash** philosophy. Stack size limits are uncapped integers (`1` to `2,147,483,647`), allowing server administrators and singleplayer worlds to configure any custom stack threshold.

### 🖥️ Dual-Context Configuration & In-Game GUI
- Configuration template stored at `config/potion-stacker.json`.
- When generating a brand-new world, your baseline JSON config template is automatically applied to the world's GameRules.
- Client configuration screen available in-game via **ModMenu** and **YetAnotherConfigLib (YACL)**.

---

## 📊 Inventory Combat Loadout Comparison

| Combat Scenario | Vanilla Footprint | With Potion Stacker Addon |
| :--- | :---: | :---: |
| **Wither Fight (12 Healing II Potions)** | 12 inventory slots | **1 single inventory slot** |
| **Nether Exploration (8 Fire Res Potions)** | 8 inventory slots | **1 single inventory slot** |
| **PvP Loadout (4 Speed II + 4 Strength II)** | 8 inventory slots | **2 inventory slots** |
| **End Raid (16 Splash / Lingering Potions)** | 16 inventory slots | **1 single inventory slot** |

---

## ⚙️ Dynamic GameRules

Configure limits in real-time in-game using vanilla GameRule commands:

| GameRule Key | Type | Default | Valid Range | Description |
| :--- | :---: | :---: | :---: | :--- |
| `potion-stacker-addon:potion_limit` | `Integer` | `16` | `1 – 2147483647` | Maximum stack size for potions (drinkable, splash, lingering, water bottles). |
| `potion-stacker-addon:stew_limit` | `Integer` | `16` | `1 – 2147483647` | Maximum stack size for stews and soups (deferred to Stew Stacker Addon if loaded). |

---

## 📖 Installation & Setup

1. Install **Fabric Loader** and **Fabric API** for your target Minecraft version.
2. Install **Dasik Library** and **Stack Size Adjuster**.
3. Place `potion-stacker-addon-<version>.jar` into your `.minecraft/mods` folder.
4. *(Optional)* Install **ModMenu** and **YetAnotherConfigLib (YACL)** for in-game settings GUI access.

---

## ☕ Support & Creator Community

I am an independent solo developer creating lightweight, vanilla-enhancing mods that respect your time and game performance. If Potion Stacker Addon streamlines your survival, consider supporting future development:

<p align="center">
  <a href="https://ko-fi.com/rifaditya"><img src="https://img.shields.io/badge/Ko--fi-Support_on_Ko--fi-F16061?style=for-the-badge&logo=ko-fi&logoColor=white" alt="Support on Ko-fi"></a>
  <a href="https://sociabuzz.com/rifaditya"><img src="https://img.shields.io/badge/SocioBuzz-Support_Creator-00A651?style=for-the-badge" alt="Support on SocioBuzz"></a>
  <a href="https://saweria.co/rifaditya"><img src="https://img.shields.io/badge/Saweria-Support_Local-FFA500?style=for-the-badge" alt="Support on Saweria"></a>
</p>

> [!TIP]
> **🇮🇩 Indonesian Local Payment Note:** Indonesian supporters can support my work directly using local payment methods (**GoPay, OVO, Dana, QRIS, LinkAja**) via **Saweria** or **SocioBuzz**!

Join my official Discord community for development updates, early test builds, and friendly support:
- 💬 **Discord Community:** [https://discord.gg/EV99bgAFqb](https://discord.gg/EV99bgAFqb)

---

## 📜 Metadata & Permissions

| Property | Value |
| :--- | :--- |
| **Mod Name** | Potion Stacker Addon |
| **Namespace / Mod ID** | `potion-stacker-addon` |
| **License** | GNU General Public License v3.0 (GPLv3) |
| **Side Safety** | Server & Client (Synchronized) |
| **Required Dependencies** | Fabric API, Dasik Library, Stack Size Adjuster |
| **Optional Dependencies** | ModMenu, YetAnotherConfigLib (YACL), Stew Stacker Addon |
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
