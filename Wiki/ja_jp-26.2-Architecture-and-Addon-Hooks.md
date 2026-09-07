# 🏛️ アーキテクチャ設計と拡張フック (Minecraft 26.2)

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **リポジトリソース免責事項**：本 Wiki ドキュメントは**リポジトリ内の現在のソースコード状態**を反映しており、CurseForge および Modrinth での公開ビルドに先駆けた最新の未リリースコミットや開発中の機能を含む場合があります。

## 1. Official Infobox
| Parameter | Technical Details |
| :--- | :--- |
| **Subsystem Name** | Architecture & Addon Extension Hooks |
| **Root Package** | `net.instantgratification.potionstacker` |
| **Core Entrypoint** | `PotionStackerFabric.java` (`ModInitializer`) |
| **Client Entrypoint** | `PotionStackerFabricClient.java` (`ClientModInitializer`) |
| **ModMenu Entrypoint** | `ModMenuIntegration.java` (`ModMenuApi`) |
| **Core Manager** | `PotionStackerManager.java` |
| **Network Payload** | `PotionLimitSyncPayload.java` |
| **Configuration** | `PotionStackerConfig.java`, `YaclScreenHelper.java` |
| **Mixin Count** | **0 Mixins** (100% Pure Addon Delegation) |
| **Upstream Framework** | Stack Size Adjuster (`StackSizeManager`) |

---

## 2. Step-by-Step Subsystem Lifecycle

1. **`onInitialize()` Lifecycle Execution**:
   * **Step A**: Load configuration baseline via `PotionStackerConfig.load(...)`.
   * **Step B**: Register functional override callback into `StackSizeManager.registerOverride(...)`.
   * **Step C**: Register `POTION_LIMIT` and `STEW_LIMIT` GameRules under namespaced category.
   * **Step D**: Register S2C payload type and codec via `PayloadTypeRegistry.clientboundPlay()`.
   * **Step E**: Attach `ServerPlayConnectionEvents.JOIN` listener for client sync.
   * **Step F**: Attach `ServerLifecycleEvents.SERVER_STARTED` listener for world initialization checks.

2. **Client Initialization (`onInitializeClient`)**:
   * Register global receiver for `PotionLimitSyncPayload.TYPE` on `ClientPlayNetworking`.

3. **Stack Query Resolution**:
   * When Minecraft queries item stack limit, Stack Size Adjuster iterates registered overrides.
   * Potion Stacker Addon inspects item class; returns `potionLimit` if potion, `stewLimit` if soup (and stew mod absent), or `-1` to continue chain.

---

## 3. Algorithmic Complexity & Zero-Allocation Path
* **Time Complexity**: $O(1)$ constant time lookup.
* **Space Complexity**: $O(1)$ zero heap allocation on the hot path.

---

## 4. Visual ASCII Architecture Diagram

```
+-------------------------------------------------------------------------+
|                            Minecraft Engine                             |
+------------------------------------+------------------------------------+
                                     |
                                     v
+-------------------------------------------------------------------------+
|                       Stack Size Adjuster (Core)                        |
|                     StackSizeManager.getStackSize()                     |
+------------------------------------+------------------------------------+
                                     |
              +----------------------+----------------------+
              | CustomStackSizeOverride                     |
              v                                             v
+-----------------------------+             +-----------------------------+
|    Potion Stacker Addon     |             |     Stew Stacker Addon      |
|  PotionStackerManager.java  |             |      (Sibling Addon)        |
+--------------+--------------+             +-----------------------------+
               |                                            ^
               |-- isModLoaded("stew-stacker-addon")? ------|
               |   If TRUE: returns -1 (defers stew logic)
               |
               v
+-------------------------------------------------------------------------+
|                           DasikLibrary (API)                            |
|       DynamicGameRuleManager  |  ConfigHelper  |  GuiHelper             |
+-------------------------------------------------------------------------+
```

---

## 5. Addon Hook Registration Schema

```java
@FunctionalInterface
public interface CustomStackSizeOverride {
    int getModifiedStackSize(Item item, int originalSize);
}
```

---

## 6. グローバルリンク
* [[🧪 Minecraft 26.2 ポータルへ戻る|ja_jp-26.2-Home]]
* [[🧪 26.2 ポーションスタックとインベントリ人間工学を読む|ja_jp-26.2-Potion-Stacking-and-Inventory-Ergonomics]]
* [[📡 26.2 ネットワーク同期とペイロードを読む|ja_jp-26.2-Network-Synchronization-and-Payloads]]
* [[⚙️ 26.2 設定と動的ゲームルールを読む|ja_jp-26.2-Configuration-and-GameRules]]
