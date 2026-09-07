# 🧪 Minecraft 26.3 Documentation Portal

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **Avertissement sur la source du dépôt** : La documentation de ce wiki reflète **l'état actuel du code source dans le dépôt**, qui peut inclure des commits non publiés ou des fonctionnalités en cours de développement en avance sur CurseForge et Modrinth.

Bienvenue sur le portail de documentation technique dédié d'**Instant Gratification: Potion Stacker Addon** sur **Minecraft 26.3** (ciblant `MC 26.3-snapshot-6 / 26.3`). Tous les documents reflètent les correspondances de bytecode exactes, les dépendances Loom et les spécifications de cette version.

---

## 🧭 Matrice de Navigation Minecraft 26.3

| Fonctionnalité / Sous-système | Description | Page Wiki Dédiée |
| :--- | :--- | :--- |
| **Empilement de Potions & Ergonomie d'Inventaire** | Mécaniques d'empilement, gestion de l'alambic, mathématiques de compression | [[26.3 Empilement de Potions & Ergonomie d'Inventaire|fr_fr-26.3-Potion-Stacking-and-Inventory-Ergonomics]] |
| **Synchronisation Réseau & Données Utiles** | Cycle de vie des paquets S2C, poignée de main, rafraîchissement des menus | [[26.3 Synchronisation Réseau & Données Utiles|fr_fr-26.3-Network-Synchronization-and-Payloads]] |
| **Configuration & GameRules Dynamiques** | Matrice de référence complète des GameRules et options YACL v3 | [[26.3 Configuration & GameRules Dynamiques|fr_fr-26.3-Configuration-and-GameRules]] |
| **Architecture & Crochets d'Extension** | Architecture logicielle, zéro mixin, CustomStackSizeOverride | [[26.3 Architecture & Crochets d'Extension|fr_fr-26.3-Architecture-and-Addon-Hooks]] |
| **Environnement Développeur & Outils** | Environnement JDK 25, commandes Gradle 9.3+, configuration Loom | [[26.3 Environnement Développeur & Outils|fr_fr-26.3-Developer-Setup-and-Building]] |

---

## 📊 Infobox des Spécifications Techniques

| Paramètre | Spécification de Version |
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

## 🧪 Points Forts du Sous-système

1. **Support complet de la famille de potions** : Tailles de pile configurables pour toutes les potions : buvables, jetables, persistantes et fioles d'eau.
2. **Intégrité des emplacements de l'alambic** : Respecte l'alambic vanilla en ne déposant qu'une seule fiole par emplacement lors d'un Shift-clic, préservant la pile restante.
3. **GameRules dynamiques** : Modification instantanée en jeu sans redémarrage via `potion-stacker-addon:potion_limit` et `potion-stacker-addon:stew_limit`.
4. **Coexistence intelligente** : Détecte `stew-stacker-addon` et lui cède automatiquement la gestion des soupes et ragoûts.

---

## 🔗 Navigation Globale
* [[🏠 Retour au Portail Principal|fr_fr-Home]]
* [[📊 Consulter la Matrice de Compatibilité des Versions|fr_fr-Version-Compatibility]]
* [[🔧 Consulter le Guide de Dépannage et FAQ|fr_fr-Troubleshooting-and-FAQ]]
