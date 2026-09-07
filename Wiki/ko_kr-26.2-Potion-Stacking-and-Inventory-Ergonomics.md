# 🧪 포션 스태킹 및 인벤토리 인체공학 (Minecraft 26.2)

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **저장소 소스 면책 조항**: 본 위키의 문서는 CurseForge 및 Modrinth의 공개 릴리스 빌드보다 앞선 최신 미출시 커밋이나 개발 기능을 포함할 수 있는 **저장소의 현재 소스 코드 상태**를 반영합니다.

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

## 5. 전역 및 외부 내비게이션
* [[🧪 Minecraft 26.2 포털로 돌아가기|ko_kr-26.2-Home]]
* [[📡 26.2 네트워크 동기화 및 페이로드 읽기|ko_kr-26.2-Network-Synchronization-and-Payloads]]
* [[⚙️ 26.2 구성 및 동적 게임 규칙 읽기|ko_kr-26.2-Configuration-and-GameRules]]
* [[🏛️ 26.2 아키텍처 및 애드온 확장 훅 읽기|ko_kr-26.2-Architecture-and-Addon-Hooks]]
