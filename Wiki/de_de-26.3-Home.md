# 🧪 Minecraft 26.3 Documentation Portal

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **Haftungsausschluss zur Repository-Quelle**: Die Dokumentation in diesem Wiki spiegelt den **aktuellen Quellcode-Zustand im Repository** wider, der neuere, unveröffentlichte Commits oder Entwicklungsfunktionen vor öffentlichen Builds auf CurseForge und Modrinth enthalten kann.

Willkommen im technischen Dokumentationsportal für **Instant Gratification: Potion Stacker Addon** auf **Minecraft 26.3** (Ziel: `MC 26.3-snapshot-6 / 26.3`). Alle Dokumente in diesem Versionsbaum spiegeln exakt die Bytecode-Mappings, Loom-Abhängigkeiten und Funktionsspezifikationen wider.

---

## 🧭 Minecraft 26.3 Navigationsmatrix

| Funktion / Subsystem | Beschreibung | Spezielle Wiki-Seite |
| :--- | :--- | :--- |
| **Tränkestapelung & Inventar-Ergonomie** | Stapelmechanik, Braustand-Ergonomie, Behälter-Komprimierungsmathematik | [[26.3 Tränkestapelung & Inventar-Ergonomie|de_de-26.3-Potion-Stacking-and-Inventory-Ergonomics]] |
| **Netzwerksynchronisation & Payloads** | S2C-Payload-Lebenszyklus, Handshake-Pakete, dynamische Menüaktualisierung | [[26.3 Netzwerksynchronisation & Payloads|de_de-26.3-Network-Synchronization-and-Payloads]] |
| **Konfiguration & dynamische GameRules** | Vollständige Referenzmatrix aller GameRules und YACL v3-Optionen | [[26.3 Konfiguration & dynamische GameRules|de_de-26.3-Configuration-and-GameRules]] |
| **Architektur & Addon-Hooks** | Paketarchitektur, Null-Mixin-Design, CustomStackSizeOverride | [[26.3 Architektur & Addon-Hooks|de_de-26.3-Architecture-and-Addon-Hooks]] |
| **Entwickler-Setup & Toolchain** | JDK 25-Umgebung, Gradle 9.3+ Build-Befehle, Loom-Setup | [[26.3 Entwickler-Setup & Toolchain|de_de-26.3-Developer-Setup-and-Building]] |

---

## 📊 Technische Spezifikations-Infobox

| Parameter | Versionsspezifikation |
| :--- | :--- |
| **Minecraft Release Target** | `MC 26.3-snapshot-6 / 26.3` |
| **Mod SemVer Release** | `1.1.3+26.3` |
| **Fabric Loader Requirement** | `>=0.19.3` |
| **Java Platform** | OpenJDK 25 (Hotspot 64-bit) |
| **Fabric API Dependency** | `0.156.1+26.3` |
| **DasikLibrary Dependency** | `>=1.8.36` |
| **Stack Size Adjuster Dependency** | `>=1.4.18` |
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
