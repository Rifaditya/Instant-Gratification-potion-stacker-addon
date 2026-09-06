# 🧪 Instant Gratification: Potion Stacker Addon Wiki

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **Hinweis zur Repository-Quelle**: Die Dokumentation in diesem Wiki spiegelt den **aktuellen Stand des Quellcodes im Repository** wider, der neuere, noch nicht veröffentlichte Commits oder Entwicklungsfunktionen vor den öffentlichen Builds auf CurseForge und Modrinth enthalten kann.

Willkommen in der offiziellen Dokumentation für **Instant Gratification: Potion Stacker Addon**. Ein Addon für **Stack Size Adjuster** auf Fabric, mit dem Tränke, Wurftränke, Verweiltränke, Wasserflaschen sowie Suppen und Eintöpfe dynamisch gestapelt werden können.

---

## 🧭 Versionsspezifische Dokumentationsportale

| Minecraft Target | Mod Version | Fabric Loader | Portal Link |
| :--- | :---: | :---: | :--- |
| **Minecraft 26.2** | `1.1.3+26.2` | `>=0.19.1` | [[👉 Enter Minecraft 26.2 Documentation Portal|26.2-Home]] |
| **Minecraft 26.3** | `1.1.3+26.3` | `>=0.19.3` | [[👉 Enter Minecraft 26.3 Documentation Portal|26.3-Home]] |

---

## ⚡ Kernphilosophie und Architektur

1. **Inventarfreiheit**: Standard-Stacklimit von 16, frei konfigurierbar bis zu 2.147.483.647.
2. **Braustand-Ergonomie**: Braustände nehmen pro Steckplatz genau 1 Trank auf, wodurch Braurezepte geschützt bleiben.
3. **Netzwerksynchronisierung**: Live-Aktualisierung über `PotionLimitSyncPayload` und `broadcastFullState()` verhindert Geister-Items.
4. **Koexistenz mit Stew Stacker Addon**: Automatische Übergabe der Suppen-Logik bei gemeinsamer Installation.
5. **Kein Mixin-Overhead**: Saubere API-Integration über `StackSizeManager.registerOverride`.

---

## 📊 Standard GameRule-Referenztabelle

| GameRule | Type | Default | Range | Target Items |
| :--- | :---: | :---: | :---: | :--- |
| `potion-stacker-addon:potion_limit` | Integer | `16` | 1 .. 2,147,483,647 | Regular, Splash, Lingering Potions, Water Bottles |
| `potion-stacker-addon:stew_limit` | Integer | `16` | 1 .. 2,147,483,647 | Mushroom Stew, Rabbit Stew, Beetroot Soup, Suspicious Stew |

---

## 📚 Wichtige Dokumentationslinks

* [[📊 Version Compatibility Matrix|Version-Compatibility]]
* [[🔧 Troubleshooting & FAQ Guide|Troubleshooting-and-FAQ]]
* [[🛠️ Developer Setup & Build Guide|Developer-Setup-and-Building]]
* [[🏠 Return to Main Home Portal|Home]]
