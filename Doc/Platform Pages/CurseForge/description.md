<p align="center">
<a href="https://discord.gg/EV99bgAFqb"><img src="https://img.shields.io/badge/Discord-Join_Community-5865F2?style=for-the-badge&amp;logo=discord&amp;logoColor=white" alt="Join Discord"></a>
<a href="https://modrinth.com/mod/fabric-api"><img src="https://img.shields.io/badge/Requires-Fabric_API-blue?style=for-the-badge&amp;logo=fabric" alt="Requires Fabric API"></a>
<img src="https://img.shields.io/badge/Environment-Server_&amp;_Client-success?style=for-the-badge" alt="Server &amp; Client">
<img src="https://img.shields.io/badge/Language-Java_25-orange?style=for-the-badge&amp;logo=java" alt="Java 25">
<img src="https://img.shields.io/badge/License-GPLv3-green?style=for-the-badge" alt="License GPLv3">
<img src="https://img.shields.io/badge/Minecraft-26.2+-brightgreen?style=for-the-badge" alt="Minecraft 26.2+">
</p>
<h2>🧪 Potion Stacker Addon</h2>
<blockquote><p><strong>"Brew More, Clutter Less. Stack Drinkable, Splash, and Lingering Potions Safely."</strong></p></blockquote>
<hr>
<h2>📖 Introduction</h2>
<p>Ever since alchemy was introduced to Minecraft, potions have remained stubbornly limited to an unstackable single item per inventory slot. Preparing for an arduous boss battle against the Wither or Ender Dragon, navigating deep Ancient Cities, or exploring Nether Fortresses turns your inventory into a cluttered mess where a standard combat buff loadout (Speed, Fire Resistance, Strength, Regeneration, Healing) completely wipes out your available bag space.</p>
<p><strong>Potion Stacker Addon</strong> solves the alchemy storage dilemma under the <strong>Instant Gratification</strong> design philosophy. It seamlessly stacks standard Drinkable Potions, Splash Potions, and Lingering Potions up to <strong>16</strong> (or custom limits) in your inventory, chests, and brewing stands. Engineered with smooth split-stack drinking mechanics, automatic empty glass bottle returns, dispenser firing compatibility, and client-server sync, your potion combat experience becomes effortless and organized.</p>
<blockquote><p><strong>1 Jar 1 Version Policy:</strong> I build <strong>1 dedicated JAR for each Minecraft version</strong> (e.g. MC 26.2, MC 26.3). Please download the exact build that matches your Minecraft installation. <strong>Addon &amp; Standalone Synergy:</strong> Functions as an optional companion addon for <strong>Stack Size Adjuster</strong> or as a 100% self-contained standalone potion mod!</p></blockquote>
<p>Part of the <strong>Instant Gratification Collection</strong> — mods that respect the player's time.</p>
<hr>
<h2>✨ Features</h2>
<h3>🍶 Safe Potion Stacking (Up to 16 by Default)</h3>
<ul>
  <li><strong>Unified Alchemy Stacking:</strong> Drinkable potions, Splash Potions, and Lingering Potions stack up to <strong>16</strong> by default (configurable up to <strong>64</strong>).</li>
  <li><strong>Matching NBT &amp; Component Validation:</strong> Potions only stack if they possess identical potion effects, durations, and custom amplification components (<code>DataComponents.POTION_CONTENTS</code>), preventing accidental mixing of healing and poison.</li>
</ul>
<h3>💨 Fluid Combat Drinking &amp; Bottle Management</h3>
<ul>
  <li><strong>Single-Bottle Consumption:</strong> Drinking from a potion stack consumes exactly 1 dose, decrementing the stack count while granting you full status effects.</li>
  <li><strong>Smart Bottle Recovery:</strong> The returned empty Glass Bottle automatically attempts to stack with existing empty bottles in your inventory. If your inventory is completely full, it cleanly drops at your feet without swallowing items.</li>
  <li><strong>Dispenser &amp; Dropper Integration:</strong> Dispensers loaded with splash potion stacks fire exactly 1 splash potion per redstone pulse, enabling compact, high-capacity automated defensive turret traps.</li>
</ul>
<h3>⚗️ Brewing Stand Automated Batch Loading</h3>
<ul>
  <li>Place stacks of awkward potions directly into brewing stand slots. Brew an entire batch of 16 potions simultaneously with a single nether wart, glowstone dust, or fermented spider eye!</li>
</ul>
<hr>
<h2>📊 Inventory Combat Loadout Comparison</h2>
<table>
  <thead>
    <tr>
      <th>Combat Scenario</th>
      <th>Vanilla Inventory Footprint</th>
      <th>With Potion Stacker Addon</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td><strong>Wither Fight (12 Healing II Potions)</strong></td>
      <td>12 inventory slots</td>
      <td><strong>1 single inventory slot</strong></td>
    </tr>
    <tr>
      <td><strong>Nether Exploration (8 Fire Res Potions)</strong></td>
      <td>8 inventory slots</td>
      <td><strong>1 single inventory slot</strong></td>
    </tr>
    <tr>
      <td><strong>PvP Loadout (4 Speed II + 4 Strength II)</strong></td>
      <td>8 inventory slots</td>
      <td><strong>2 inventory slots</strong></td>
    </tr>
    <tr>
      <td><strong>Ender Dragon Lingering Breath Harvest</strong></td>
      <td>16 empty bottles + 16 lingering potions</td>
      <td><strong>2 compact stacks</strong></td>
    </tr>
  </tbody>
</table>
<hr>
<h2>⚙️ Native GameRules &amp; Configuration</h2>
<p>Configure potion stacking rules in-game:</p>
<table>
  <thead>
    <tr>
      <th>GameRule Key</th>
      <th>Type</th>
      <th>Default</th>
      <th>Valid Range</th>
      <th>Description</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td><code>potion_stacker:max_drinkable_stack</code></td>
      <td><code>Integer</code></td>
      <td><code>16</code></td>
      <td><code>1 – 64</code></td>
      <td>Maximum stack size for drinkable glass bottle potions.</td>
    </tr>
    <tr>
      <td><code>potion_stacker:max_splash_stack</code></td>
      <td><code>Integer</code></td>
      <td><code>16</code></td>
      <td><code>1 – 64</code></td>
      <td>Maximum stack size for throwable splash potions.</td>
    </tr>
    <tr>
      <td><code>potion_stacker:max_lingering_stack</code></td>
      <td><code>Integer</code></td>
      <td><code>16</code></td>
      <td><code>1 – 64</code></td>
      <td>Maximum stack size for lingering area-of-effect potions.</td>
    </tr>
    <tr>
      <td><code>potion_stacker:empty_bottle_behavior</code></td>
      <td><code>Enum</code></td>
      <td><code>INVENTORY_OR_DROP</code></td>
      <td><code>INVENTORY / DROP / VOID</code></td>
      <td>Destination for empty glass bottles upon drinking.</td>
    </tr>
  </tbody>
</table>
<hr>
<h2>📖 In-Depth How-To &amp; Gameplay Playbook</h2>
<h3>Step 1: Installation &amp; Setup</h3>
<ol>
  <li>Install <strong>Fabric Loader</strong> and <strong>Fabric API</strong> for Minecraft 26.2+ / 26.3+.</li>
  <li>Place <code>potion-stacker-addon-x.y.z+<version>.jar</code> into your <code>mods/</code> directory.</li>
  <li>Launch Minecraft. Potions of identical type in your chests and inventory will now stack automatically when clicked together!</li>
</ol>
<h3>Step 2: Optimizing Combat Hotbars</h3>
<ul>
  <li>Consolidate your combat bag: place a stack of 8 Splash Potions of Healing II on your hotbar key <code>8</code>, and a stack of 4 Swiftness II potions on key <code>9</code>.</li>
  <li>Free up 10+ inventory slots for mob drops, ancient city loot, and armor switches!</li>
</ul>
<hr>
<h2>☕ Support &amp; Creator Community</h2>
<p>I am an independent solo developer creating lightweight, vanilla-enhancing mods that respect your time and game performance. If Potion Stacker Addon streamlines your survival, consider supporting future development:</p>
<p align="center">
<a href="https://ko-fi.com/rifaditya"><img src="https://img.shields.io/badge/Ko--fi-Support_on_Ko--fi-F16061?style=for-the-badge&amp;logo=ko-fi&amp;logoColor=white" alt="Support on Ko-fi"></a>
<a href="https://sociabuzz.com/rifaditya"><img src="https://img.shields.io/badge/SocioBuzz-Support_Creator-00A651?style=for-the-badge" alt="Support on SocioBuzz"></a>
<a href="https://saweria.co/rifaditya"><img src="https://img.shields.io/badge/Saweria-Support_Local-FFA500?style=for-the-badge" alt="Support on Saweria"></a>
</p>
<blockquote><p><strong>🇮🇩 Indonesian Local Payment Note:</strong> Indonesian supporters can also support my development work directly using local payment options (<strong>GoPay, OVO, Dana, QRIS, LinkAja</strong>) via <strong>Saweria</strong> or <strong>SocioBuzz</strong>!</p></blockquote>
<p>Join our official Discord community for live development updates, early test builds, and friendly support:</p>
<ul>
  <li>💬 <strong>Discord Community:</strong> <a href="https://discord.gg/EV99bgAFqb" target="_blank" rel="noopener">https://discord.gg/EV99bgAFqb</a></li>
</ul>
<hr>
<h2>📜 Metadata &amp; Permissions</h2>
<table>
  <thead>
    <tr>
      <th>Property</th>
      <th>Value</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td><strong>Mod Name</strong></td>
      <td>Potion Stacker Addon</td>
    </tr>
    <tr>
      <td><strong>Namespace / Mod ID</strong></td>
      <td><code>potion_stacker</code></td>
    </tr>
    <tr>
      <td><strong>License</strong></td>
      <td>GNU General Public License v3.0 (GPLv3)</td>
    </tr>
    <tr>
      <td><strong>Side Safety</strong></td>
      <td>Server &amp; Client (Synchronized)</td>
    </tr>
    <tr>
      <td><strong>Source Code</strong></td>
      <td><a href="https://github.com/Rifaditya/Instant-Gratification-potion-stacker-addon" target="_blank" rel="noopener">GitHub Repository</a></td>
    </tr>
    <tr>
      <td><strong>Issue Tracker</strong></td>
      <td><a href="https://github.com/Rifaditya/Instant-Gratification-potion-stacker-addon/issues" target="_blank" rel="noopener">GitHub Issues</a></td>
    </tr>
  </tbody>
</table>
<blockquote><p><strong>📦 Modpack Permissions &amp; Distribution:</strong><br> You are fully welcome to include this mod in any modpack on any platform! However, the mod file must be downloaded directly through official distribution channels (<strong>Modrinth</strong> or <strong>CurseForge</strong>). Re-uploading, mirroring, or redistributing the original mod JAR to third-party mirror sites, scraper portals, or unauthorized launchers is strictly prohibited. <br><br> <strong>⚖️ License &amp; Fork Guidelines (No Zero-Change Re-uploads):</strong><br> This project is open-source under the <strong>GNU GPLv3</strong>. You are fully encouraged to inspect the code, learn from it, and fork the repository to create genuine modifications, substantial feature expansions, or community ports—provided your project remains open-source under GPLv3 with proper attribution.<br> <strong>However, straight 1:1 re-uploads, clone forks with no meaningful functional changes, or re-publishing identical builds under different project names (e.g. to farm downloads or rewards) are strictly forbidden.</strong></p></blockquote>
<hr>
<div align="center">
<strong>Made with ❤️ for the Minecraft community</strong>
<em>Part of the Instant Gratification Collection</em>
</div>
