# 🧪 Instant Gratification: Potion Stacker Addon Wiki

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **Avertissement relatif à la source du dépôt** : La documentation de ce wiki reflète **l'état actuel du code source dans le dépôt**, qui peut inclure des commits récents non publiés ou des fonctionnalités en développement avant les versions publiques sur CurseForge et Modrinth.

Bienvenue sur la documentation technique officielle de **Instant Gratification: Potion Stacker Addon**. Extension haute performance pour **Stack Size Adjuster** sur Fabric, permettant d'empiler potions, potions jetables, potions persistantes, fioles d'eau et ragoûts de manière dynamique.

---

## 🧭 Portails de documentation par version

| Minecraft Target | Mod Version | Fabric Loader | Portal Link |
| :--- | :---: | :---: | :--- |
| **Minecraft 26.2** | `1.1.3+26.2` | `>=0.19.1` | [[👉 Enter Minecraft 26.2 Documentation Portal|26.2-Home]] |
| **Minecraft 26.3** | `1.1.3+26.3` | `>=0.19.3` | [[👉 Enter Minecraft 26.3 Documentation Portal|26.3-Home]] |

---

## ⚡ Piliers d'ingénierie et architecture

1. **Inventaire libéré** : Limite par défaut à 16, configurable jusqu'à 2 147 483 647 sans restriction.
2. **Ergonomie de l'alambic** : Respect strict de la capacité de 1 bouteille par emplacement d'alambic lors du Shift-clic.
3. **Synchronisation réseau en direct** : Élimination totale des objets fantômes via `PotionLimitSyncPayload` et `broadcastFullState()`.
4. **Coexistence avec Stew Stacker Addon** : Détection automatique et délégation totale de la gestion des soupes.
5. **Zéro surcharge Mixin** : Architecture basée sur l'enregistrement direct via `StackSizeManager.registerOverride`.

---

## 📊 Tableau de référence des GameRules

| GameRule | Type | Default | Range | Target Items |
| :--- | :---: | :---: | :---: | :--- |
| `potion-stacker-addon:potion_limit` | Integer | `16` | 1 .. 2,147,483,647 | Regular, Splash, Lingering Potions, Water Bottles |
| `potion-stacker-addon:stew_limit` | Integer | `16` | 1 .. 2,147,483,647 | Mushroom Stew, Rabbit Stew, Beetroot Soup, Suspicious Stew |

---

## 📚 Liens essentiels de documentation

* [[📊 Version Compatibility Matrix|Version-Compatibility]]
* [[🔧 Troubleshooting & FAQ Guide|Troubleshooting-and-FAQ]]
* [[🛠️ Developer Setup & Build Guide|Developer-Setup-and-Building]]
* [[🏠 Return to Main Home Portal|Home]]
