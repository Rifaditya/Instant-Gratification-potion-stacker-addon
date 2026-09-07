# 🔧 疑難排解與常見問題

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **程式碼倉庫來源免責聲明**：本維基文件反映了**程式碼倉庫中的當前原始碼狀態**，可能包含領先於 CurseForge 與 Modrinth 平臺公開發布版本的最新未發布提交或開發中功能。

## 1. Brewing Stand Interactions & Slot Splitting
Vanilla Minecraft's `BrewingStandBlockEntity` hardcodes slot capacity to `1` for the three potion input slots (`SLOT_BOTTLE_1`, `SLOT_BOTTLE_2`, `SLOT_BOTTLE_3`).
* Potion Stacker Addon respects brewing stand slot constraints: when shift-clicking, exactly 1 potion is smoothly deposited into each empty brewing stand slot, while the remaining 15 potions remain safely stacked in your inventory.

---

## 2. Hopper Transfer Mechanics
Hoppers transfer stacked potions according to container slot limits:
1. **Hopper -> Chest / Barrel / Shulker Box**: Hoppers push full stacks into containers up to `potionLimit` (default: 16) at vanilla hopper transfer speed (1 item every 8 game ticks).
2. **Hopper -> Brewing Stand**: A hopper pointed into a brewing stand can only deposit 1 bottle per brewing slot.
3. **Hopper -> Hopper**: Hoppers pass stacked potions seamlessly between each other without splitting or ejecting items.

---

## 3. Ghost Items & Desynchronization Prevention
In vanilla Minecraft, changing stack sizes dynamically without refreshing container state can cause "ghost items". Potion Stacker Addon completely eliminates this issue:
1. **Network Sync Packet**: Whenever `potion_limit` or `stew_limit` changes, the server broadcasts a `PotionLimitSyncPayload` to all connected clients.
2. **Dynamic Menu Refresh**: The server immediately invokes `broadcastFullState()` on both the player's active `containerMenu` and `inventoryMenu`.

```java
if (player.containerMenu != null) {
    player.containerMenu.broadcastFullState();
}
if (player.inventoryMenu != null && player.containerMenu != player.inventoryMenu) {
    player.inventoryMenu.broadcastFullState();
}
```

---

## 4. Multi-Addon Priority & Coexistence with Stew Stacker Addon
Potion Stacker Addon includes an intelligent fallback delegation check in `PotionStackerManager.java`:
```java
if (isStewOrSoup(item)) {
    if (FabricLoader.getInstance().isModLoaded("stew-stacker-addon")) {
        return -1;
    }
    return stewLimit;
}
```
* If `stew-stacker-addon` is **NOT installed**: Potion Stacker Addon provides convenient fallback stacking for Mushroom Stew, Rabbit Stew, Beetroot Soup, and Suspicious Stew up to `stewLimit` (default: 16).
* If `stew-stacker-addon` is **INSTALLED**: Potion Stacker Addon detects the mod and returns `-1`, completely yielding all soup and stew stacking calculations to Stew Stacker Addon.

---

## 5. Maximum Stack Limits & Integer Safety
Under the **Player Agency & Anti-Nanny Invariant**, players and server owners are given total freedom to set stack limits up to `Integer.MAX_VALUE` (2,147,483,647).
* A standard Large Chest has 54 inventory slots.
* If every slot contains 39,768,215 items:
  $$\text{Total Items} = 54 \times 39{,}768{,}215 = 2{,}147{,}483{,}610 \le 2{,}147{,}483{,}647$$
* Setting values greater than 39,768,215 can cause vanilla integer overflow in 32-bit container math. Values below 39,768,215 are 100% safe across all containers.

---

## 6. ASCII Diagnostic Decision Tree

```
[ Player Encounters Item Stacking Issue ]
                     |
                     v
             Is item a Potion?
            /                 \
          YES                  NO
          /                     \
   Check GameRule:         Is item a Stew or Soup?
potion-stacker:potion_limit      /                 \
  (Default: 16)                YES                  NO
                               /                     \
              Is stew-stacker-addon loaded?      Handled by Vanilla
                     /               \          or other overrides
                   YES                NO
                   /                   \
        Managed by Stew Stacker   Check GameRule:
              Addon          potion-stacker:stew_limit
```

---

## 7. 全域性與外部導航
* [[🏠 返回維基總首頁|zh_tw-Home]]
* [[📊 查閱全域性版本相容性矩陣|zh_tw-Version-Compatibility]]
* [[⚙️ 閱讀 26.2 配置與動態遊戲規則|zh_tw-26.2-Configuration-and-GameRules]]
* [[⚙️ 閱讀 26.3 配置與動態遊戲規則|zh_tw-26.3-Configuration-and-GameRules]]
