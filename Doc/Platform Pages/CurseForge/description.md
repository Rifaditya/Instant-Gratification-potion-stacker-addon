<p align="center">
    <a href="https://www.curseforge.com/minecraft/mc-mods/fabric-api"><img src="https://img.shields.io/badge/Requires-Fabric_API-blue?style=for-the-badge&logo=fabric" alt="Requires Fabric API"></a>
    <a href="https://www.curseforge.com/minecraft/mc-mods/stack-size-adjuster"><img src="https://img.shields.io/badge/Requires-Stack_Size_Adjuster-blue?style=for-the-badge" alt="Requires Stack Size Adjuster"></a>
    <img src="https://img.shields.io/badge/Language-Java_25-orange?style=for-the-badge&logo=java" alt="Java 25">
    <img src="https://img.shields.io/badge/License-GPLv3-green?style=for-the-badge" alt="License">
    <img src="https://img.shields.io/badge/Minecraft-26.2+-brightgreen?style=for-the-badge" alt="Minecraft 26.2+">
</p>

# 🧪 Potion Stacker Addon

### 🎮 Version Compatibility & Parity

This mod is active and fully supported:
* **Minecraft 26.2+**: Current public release — **`v1.0.0`**

<blockquote><strong>Stack your potions. Consolidate your inventory.</strong></blockquote>

Tired of potions cluttering your inventory slots and taking up valuable backpack space? **Potion Stacker Addon** is a dedicated addon for **<a href="https://www.curseforge.com/minecraft/mc-mods/stack-size-adjuster">Stack Size Adjuster</a>** that allows regular potions, splash potions, lingering potions, and water bottles to stack up to a customizable limit. Keep your combat resources compact and ready for adventure.

Part of the **Instant Gratification Collection** — mods that respect the player's time.

---

## ✨ Features

### 🧪 Stackable Potions
Overridden default stack limits specifically for:
- Regular Potions
- Splash Potions
- Lingering Potions
- Water Bottles
- Mundane / Thick / Awkward Potions

### 🎚️ Customizable Stack Limit
No hardcoded values! Adjust limits dynamically via `/gamerule` or config menus from `1` up to `2,147,483,647`. Default limit: `16`.
- **Overflow Protection Warning**: Features a warning if set above `39,768,215` to prevent container-level signed 32-bit integer overflow deletion bugs.

### 📡 Dynamic GameRules (No Restarts Required)
Configure limits on-the-fly inside dynamic worlds. Server settings automatically sync with connecting client inventories.

---

## ⚙️ Configuration (Native Game Rules)

<blockquote class="warning">
<strong>⚠️ Important: Config vs. In-Game GameRules</strong><br>
The global configuration file only defines <strong>default values for new worlds</strong> at creation time.<br>
If you have <strong>already created/opened a world</strong>, changing the config file will have no effect. You must change the settings in-game using the <strong>Edit Game Rules</strong> UI screen or the <code>/gamerule</code> command.
</blockquote>

Configure option in-game using `/gamerule` or via the integrated YACL config GUI:
- `potion-stacker-addon:potion_limit`

---

## 📦 Installation

1. Install **Fabric API**.
2. Install **<a href="https://www.curseforge.com/minecraft/mc-mods/stack-size-adjuster">Stack Size Adjuster</a>** (Required).
3. Download the mod jar and place it in your `mods` folder.
4. Launch the game.

---

## ☕ Support

If you enjoy the **Instant Gratification** collection, consider supporting development!

<p align="center">

<a href="https://ko-fi.com/dasikigaijin/tip"><img src="https://img.shields.io/badge/Ko--fi-Support%20Me-FF5E5B?style=for-the-badge&logo=ko-fi&logoColor=white" alt="Ko-fi"></a>
<a href="https://sociabuzz.com/dasikigaijin/tribe"><img src="https://img.shields.io/badge/SocioBuzz-Local_Support-7BB32E?style=for-the-badge" alt="SocioBuzz"></a>
<a href="https://saweria.co/DasikIgaijinn"><img src="https://img.shields.io/badge/Saweria-Local_Support-FFA500?style=for-the-badge" alt="Saweria"></a>

</p>

<blockquote><strong>🇮🇩 Indonesian Users:</strong> SocioBuzz and Saweria support local payment methods (Gopay, OVO, Dana, etc.) if you want to support me without using PayPal/Ko-fi!</blockquote>

---

## 📦 Modpack Permissions

<blockquote><strong>Modpack Distribution Policy:</strong><br>
Since this mod is open-source (GPLv3), you are free to include it in any modpack! If you want to support my work, downloading it directly through the official platform page (CurseForge) is highly appreciated.</blockquote>

---

## 📜 Credits

| Role | Author |
| :--- | :--- |
| **Creator** | **Dasik (Rifaditya)** |
| **Collection** | Instant Gratification |
| **License** | GPLv3 |

---

<div align="center">

**Made with ❤️ for the Minecraft community**

*Part of the Instant Gratification Collection*

</div>
