# 🔧 Troubleshooting & Frequently Asked Questions

> 📌 **Repository Source Disclaimer**: The documentation in this Wiki reflects the **current source code state in the repository**, which may include recent unreleased commits or developmental features ahead of public release builds on CurseForge and Modrinth.

## 1. Brewing Stand Interactions & Slot Splitting

### Q: Why does only 1 potion enter the brewing stand slot when I shift-click a stack of 16?
**A:** This is intentional, ergonomic design! Vanilla Minecraft's `BrewingStandBlockEntity` hardcodes slot capacity to `1` for the three potion input slots (`SLOT_BOTTLE_1`, `SLOT_BOTTLE_2`, `SLOT_BOTTLE_3`). 
* If a mod forces a stack of 16 potions into a brewing stand slot, brewing recipes fail or consume entire stacks for a single ingredient brew tick, resulting in catastrophic loss of potion items.
* Potion Stacker Addon respects brewing stand slot constraints: when shift-clicking, exactly 1 potion is smoothly deposited into each empty brewing stand slot, while the remaining 15 potions remain safely stacked in your inventory.

---

## 2. Hopper Transfer Mechanics

### Q: How do hoppers interact with stacked potions?
**A:** Hoppers transfer stacked potions according to container slot limits:
1. **Hopper -> Chest / Barrel / Shulker Box**: Hoppers push full stacks into containers up to `potionLimit` (default: 16) at vanilla hopper transfer speed (1 item every 8 game ticks).
2. **Hopper -> Brewing Stand**: A hopper pointed into a brewing stand can only deposit 1 bottle per brewing slot. Once all 3 brewing slots contain 1 bottle each, the hopper pauses transfer until a brewed potion is extracted.
3. **Hopper -> Hopper**: Hoppers pass stacked potions seamlessly between each other without splitting or ejecting items.

---

## 3. Ghost Items & Desynchronization Prevention

### Q: What prevents ghost items when GameRules change on a dedicated server?
**A:** In vanilla Minecraft, changing stack sizes dynamically without refreshing container state can cause "ghost items" (client thinks an item is stacked, but the server rejects clicks, causing rubber-banding). Potion Stacker Addon completely eliminates this issue via two guarantees in `PotionStackerManager.java`:
1. **Network Sync Packet**: Whenever `potion_limit` or `stew_limit` changes, the server broadcasts a `PotionLimitSyncPayload` to all connected clients.
2. **Dynamic Menu Refresh**: The server immediately invokes `broadcastFullState()` on both the player's active `containerMenu` and `inventoryMenu`:
```java
if (player.containerMenu != null) {
    player.containerMenu.broadcastFullState();
}
if (player.inventoryMenu != null && player.containerMenu != player.inventoryMenu) {
    player.inventoryMenu.broadcastFullState();
}
```
This synchronizes all client slot caches with zero player interaction required.

---

## 4. Multi-Addon Priority & Coexistence with Stew Stacker Addon

### Q: Both Potion Stacker Addon and Stew Stacker Addon support stews. How is a conflict avoided?
**A:** Potion Stacker Addon includes an intelligent fallback delegation check in `PotionStackerManager.java`:
```java
if (isStewOrSoup(item)) {
    // Defer stew handling to stew-stacker-addon if loaded to prevent conflicts
    if (FabricLoader.getInstance().isModLoaded("stew-stacker-addon")) {
        return -1;
    }
    return stewLimit;
}
```
* If `stew-stacker-addon` is **NOT installed**: Potion Stacker Addon provides convenient fallback stacking for Mushroom Stew, Rabbit Stew, Beetroot Soup, and Suspicious Stew up to `stewLimit` (default: 16).
* If `stew-stacker-addon` is **INSTALLED**: Potion Stacker Addon detects the mod and returns `-1`, completely yielding all soup and stew stacking calculations to Stew Stacker Addon. There is zero conflict, zero race condition, and zero configuration overwrite.

---

## 5. Maximum Stack Limits & Integer Safety

### Q: Why does the configuration GUI show a warning at 39,768,215?
**A:** Under the **Player Agency & Anti-Nanny Invariant**, players and server owners are given total freedom to set stack limits up to `Integer.MAX_VALUE` (2,147,483,647).
* However, a standard Large Chest has 54 inventory slots.
* If every slot contains 39,768,215 items:
  $$\text{Total Items} = 54 \times 39{,}768{,}215 = 2{,}147{,}483{,}610 \le 2{,}147{,}483{,}647$$
* Setting values greater than 39,768,215 means a completely full Large Chest can exceed the signed 32-bit integer ceiling ($2^{31}-1$), which can cause vanilla integer overflow, inventory desync, or item deletion in poorly coded container mods. Values below 39,768,215 are 100% mathematically safe across all vanilla containers.

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

## 7. Related Documentation Links
* Return to the [[Main Wiki Portal|Home]].
* Inspect the [[Version Compatibility Matrix|Version-Compatibility]].
* Review [[26.2 Configuration & GameRules|26.2-Configuration-and-GameRules]].
* Review [[26.3 Configuration & GameRules|26.3-Configuration-and-GameRules]].
