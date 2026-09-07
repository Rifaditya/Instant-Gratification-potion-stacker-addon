# 🧪 Minecraft 26.2 Documentation Portal

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **Haftungsausschluss zur Repository-Quelle**: Die Dokumentation in diesem Wiki spiegelt den **aktuellen Quellcode-Zustand im Repository** wider, der neuere, unveröffentlichte Commits oder Entwicklungsfunktionen vor öffentlichen Builds auf CurseForge und Modrinth enthalten kann.

Willkommen im technischen Dokumentationsportal für **Instant Gratification: Potion Stacker Addon** auf **Minecraft 26.2** (Ziel: `MC 26.1.2 / 26.2`). Alle Dokumente in diesem Versionsbaum spiegeln exakt die Bytecode-Mappings, Loom-Abhängigkeiten und Funktionsspezifikationen wider.

---

## 🧭 Minecraft 26.2 Navigationsmatrix

| Funktion / Subsystem | Beschreibung | Spezielle Wiki-Seite |
| :--- | :--- | :--- |
| **Tränkestapelung & Inventar-Ergonomie** | Stapelmechanik, Braustand-Ergonomie, Behälter-Komprimierungsmathematik | [[26.2 Tränkestapelung & Inventar-Ergonomie|de_de-26.2-Potion-Stacking-and-Inventory-Ergonomics]] |
| **Netzwerksynchronisation & Payloads** | S2C-Payload-Lebenszyklus, Handshake-Pakete, dynamische Menüaktualisierung | [[26.2 Netzwerksynchronisation & Payloads|de_de-26.2-Network-Synchronization-and-Payloads]] |
| **Konfiguration & dynamische GameRules** | Vollständige Referenzmatrix aller GameRules und YACL v3-Optionen | [[26.2 Konfiguration & dynamische GameRules|de_de-26.2-Configuration-and-GameRules]] |
| **Architektur & Addon-Hooks** | Paketarchitektur, Null-Mixin-Design, CustomStackSizeOverride | [[26.2 Architektur & Addon-Hooks|de_de-26.2-Architecture-and-Addon-Hooks]] |
| **Entwickler-Setup & Toolchain** | JDK 25-Umgebung, Gradle 9.3+ Build-Befehle, Loom-Setup | [[26.2 Entwickler-Setup & Toolchain|de_de-26.2-Developer-Setup-and-Building]] |

---

## 📊 Technische Spezifikations-Infobox

| Parameter | Versionsspezifikation |
| :--- | :--- |
| **Minecraft Release Target** | `MC 26.1.2 / 26.2` |
| **Mod SemVer Release** | `1.1.3+26.2` |
| **Fabric Loader Requirement** | `>=0.19.1` |
| **Java Platform** | OpenJDK 25 (Hotspot 64-bit) |
| **Fabric API Dependency** | `0.150.1+26.2` |
| **DasikLibrary Dependency** | `>=1.8.3` |
| **Stack Size Adjuster Dependency** | `>=1.4.10+26.2` |
| **Mixin Footprint** | 0 Mixins (Pure Callback Delegation) |
| **Primary Network Payload** | `potion-stacker:sync_limit` |

---

## 🧪 Kern-Subsystem-Highlights

1. **Volle Trankfamilien-Unterstützung**: Konfigurierbare Stapelgrößen für alle Trankarten: Trinktränke, Wurftränke, Verweiltränke und Wasserflaschen.
2. **Braustand-Slotintegrität**: Schützt die Braustandlogik, indem beim Umschaltklick exakt 1 Flasche pro Slot platziert wird, ohne Rezepte zu zerstören.
3. **Dynamische GameRule-Verwaltung**: Direkte Anpassung im Spiel ohne Neustart über `potion-stacker-addon:potion_limit` und `potion-stacker-addon:stew_limit`.
4. **Intelligente Koexistenz**: Erkennt das Geschwister-Addon `stew-stacker-addon` und überlässt diesem automatisch die Eintopf-Logik.

---

## 🔗 Globale Navigation
* [[🏠 Zurück zum Hauptportal|de_de-Home]]
* [[📊 Versionskompatibilitätsmatrix anzeigen|de_de-Version-Compatibility]]
* [[🔧 Fehlerbehebung & FAQ konsultieren|de_de-Troubleshooting-and-FAQ]]
