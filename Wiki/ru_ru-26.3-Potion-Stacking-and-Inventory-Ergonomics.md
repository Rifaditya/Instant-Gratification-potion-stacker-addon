# 🧪 Стаки зелий и эргономика инвентаря (Minecraft 26.3)

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **Отказ от ответственности за источник репозитория**: Документация в этой вики отражает **текущее состояние исходного кода в репозитории**, которое может включать недавние невыпущенные коммиты или разрабатываемые функции, опережающие общедоступные сборки на CurseForge и Modrinth.

## 1. Official Infobox
| Parameter | Technical Details |
| :--- | :--- |
| **Subsystem Name** | Potion Stacking & Inventory Ergonomics Engine |
| **Implementation Class** | `PotionStackerManager.java` (`getModifiedStackSize`) |
| **Registration Interface** | `CustomStackSizeOverride` (Stack Size Adjuster API) |
| **Target Item Types** | `PotionItem` (Regular, Splash, Lingering, Water Bottles) |
| **Secondary Fallback Items** | `MUSHROOM_STEW`, `RABBIT_STEW`, `BEETROOT_SOUP`, `SUSPICIOUS_STEW` |
| **Controlling GameRule** | `potion-stacker-addon:potion_limit` (Default: `16`) |
| **Secondary GameRule** | `potion-stacker-addon:stew_limit` (Default: `16`) |
| **Upper Bound Limit** | `Integer.MAX_VALUE` (2,147,483,647) |
| **Recommended Safe Ceiling** | `39,768,215` (prevents Large Chest 32-bit integer overflow) |

---

## 2. Step-by-Step Player Survival Workflow

1. **Brewing Potions at the Brewing Stand**:
   Place blaze powder into the fuel slot. Insert three water bottles or awkward potions into the bottom three brewing slots. When shift-clicking from a stack of bottles in your inventory, exactly **1 bottle** enters each empty slot, while the rest remains stacked in your hand or inventory.

2. **Collecting Brewed Potions**:
   When brewing finishes, shift-click the finished potions into your inventory. Identical potions (matching effects, duration, and potency) automatically merge into single item stacks up to the active `potionLimit` (default: 16).

3. **Drinking & Throwing Potions in Combat**:
   * **Regular Potions**: Drinking a stacked potion consumes 1 potion from the stack and immediately places an empty glass bottle into the player's inventory (or drops it if full).
   * **Splash & Lingering Potions**: Right-clicking hurls 1 projectile and decrements the stack count by 1. Rapid throwing from hotbar is smooth and frictionless.

4. **Inventory & Storage Management**:
   Chest and barrel slots hold full stacks. A single standard Chest (27 slots) holding stacks of 16 stores 432 potions, compared to only 27 potions in vanilla Minecraft.

---

## 3. Mathematical Formulas & Storage Density

### Storage Compression Multiplier ($C$)
The inventory compression ratio achieved relative to vanilla unstackable potions ($S_{\text{vanilla}} = 1$) is:
$$C = \frac{S_{\text{limit}}}{S_{\text{vanilla}}} = S_{\text{limit}}$$

For default settings ($S_{\text{limit}} = 16$):
$$C = 16\times \text{ more potions per inventory slot}$$

### Container Storage Capacities
$$\text{Capacity}_{\text{chest}} = 27 \times S_{\text{limit}}$$
$$\text{Capacity}_{\text{double\_chest}} = 54 \times S_{\text{limit}}$$
$$\text{Capacity}_{\text{player\_inventory}} = 36 \times S_{\text{limit}}$$

| Container Type | Slots | Vanilla Capacity ($S=1$) | Modded Default ($S=16$) | Storage Gain |
| :--- | :---: | :---: | :---: | :---: |
| **Player Hotbar** | 9 | 9 potions | 144 potions | $+135$ potions |
| **Main Inventory** | 27 | 27 potions | 432 potions | $+405$ potions |
| **Single Chest / Barrel** | 27 | 27 potions | 432 potions | $+405$ potions |
| **Large Double Chest** | 54 | 54 potions | 864 potions | $+810$ potions |
| **Shulker Box** | 27 | 27 potions | 432 potions | $+405$ potions |

### The 32-Bit Integer Safe Ceiling ($S_{\text{safe}}$)
$$S_{\text{safe}} = \left\lfloor \frac{2^{31} - 1}{54} \right\rfloor = \left\lfloor \frac{2{,}147{,}483{,}647}{54} \right\rfloor = 39{,}768{,}215$$

---

## 4. Visual ASCII Diagrams & State Machine

```
       [ Item Stack Size Query: getModifiedStackSize(item, original) ]
                                     |
                                     v
                             Is original <= 0?
                            /                 \
                          YES                  NO
                          /                     \
                    Return original        Is item instanceof PotionItem?
                                           /                            \
                                         YES                             NO
                                         /                                \
                               Return potionLimit                Is item stew/soup?
                                 (Default: 16)                   /                 \
                                                               YES                  NO
                                                               /                     \
                                                Is stew-stacker-addon loaded?     Return -1
                                                       /                 \      (Vanilla/fallback)
                                                     YES                  NO
                                                     /                     \
                                                 Return -1           Return stewLimit
                                            (Defer to sibling)         (Default: 16)
```

---

## 5. Глобальная навигация
* [[🧪 Вернуться к порталу Minecraft 26.3|ru_ru-26.3-Home]]
* [[📡 Читать: 26.3 Сетевая синхронизация и пакеты данных|ru_ru-26.3-Network-Synchronization-and-Payloads]]
* [[⚙️ Читать: 26.3 Конфигурация и игровые правила|ru_ru-26.3-Configuration-and-GameRules]]
* [[🏛️ Читать: 26.3 Архитектура и хуки аддонов|ru_ru-26.3-Architecture-and-Addon-Hooks]]
