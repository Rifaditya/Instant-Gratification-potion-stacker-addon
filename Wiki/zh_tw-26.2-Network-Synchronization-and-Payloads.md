# 📡 網路同步與資料負載 (Minecraft 26.2)

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **程式碼倉庫來源免責聲明**：本維基文件反映了**程式碼倉庫中的當前原始碼狀態**，可能包含領先於 CurseForge 與 Modrinth 平臺公開發布版本的最新未發布提交或開發中功能。

## 1. Official Infobox
| Parameter | Technical Details |
| :--- | :--- |
| **Subsystem Name** | Network Synchronization Protocol |
| **Payload Class** | `PotionLimitSyncPayload.java` |
| **Payload Identifier** | `potion-stacker:sync_limit` |
| **Protocol Phase** | `Play` (clientbound S2C) |
| **Codec Implementation** | `StreamCodec<RegistryFriendlyByteBuf, PotionLimitSyncPayload>` |
| **Client Receiver** | `PotionStackerFabricClient.java` |
| **Server Dispatch Events** | `ServerPlayConnectionEvents.JOIN`, `DynamicGameRuleManager` listener |
| **Menu Synchronization** | `broadcastFullState()` on `containerMenu` and `inventoryMenu` |

---

## 2. Step-by-Step Player Workflow & Synchronization Lifecycle

1. **Initial Player Connection (Handshake)**:
   When a player connects to the dedicated server, `ServerPlayConnectionEvents.JOIN` triggers. The server queries current active limits from `PotionStackerManager` and sends a `PotionLimitSyncPayload` to the connecting client.

2. **Client-Side State Storage**:
   Upon packet receipt on the client, `PotionStackerFabricClient` queues a task on the Minecraft client render thread (`context.client().execute(...)`) to update `PotionStackerManager.setClientLimit(potionLimit, stewLimit)`.

3. **In-Game Administrator Mutation**:
   An administrator executes `/gamerule potion-stacker-addon:potion_limit 32`. `DynamicGameRuleManager` detects the value change and invokes `PotionStackerManager.setLimits(...)`.

4. **Full Multi-Client Broadcast & Menu Refresh**:
   The server loops through all online players (`server.getPlayerList().getPlayers()`), dispatches `PotionLimitSyncPayload`, and invokes `broadcastFullState()` on every player's open container and inventory menus.

---

## 3. Mathematical Formulas & Network Bandwidth

$$B = \text{VarIntBytes}(P_{\text{limit}}) + \text{VarIntBytes}(S_{\text{limit}})$$

For default settings ($P = 16, S = 16$):
$$B = 1 + 1 = 2\text{ bytes}$$

Even at the maximum safe limit ($39{,}768{,}215$):
$$B = 4 + 4 = 8\text{ bytes}$$

---

## 4. Visual ASCII Diagrams & Packet Lifecycle

```
   [ Client ]                                               [ Dedicated Server ]
       |                                                             |
       |----------------- C2S Login / Handshake -------------------->|
       |                                                             |
       |                                              ServerPlayConnectionEvents.JOIN
       |                                                             |
       |                                              Query PotionStackerManager
       |                                                pLimit=16, sLimit=16
       |                                                             |
       |<--- S2C PotionLimitSyncPayload(16, 16) ---------------------|
       |
   Receive Packet
   context.client().execute()
   PotionStackerManager.setClientLimit(16, 16)
       |
   Client GUI & Tooltips Synchronized
```

---

## 5. 全域性與外部導航
* [[🧪 返回 Minecraft 26.2 門戶|zh_tw-26.2-Home]]
* [[🧪 閱讀 26.2 藥水堆疊與物品欄人體工學|zh_tw-26.2-Potion-Stacking-and-Inventory-Ergonomics]]
* [[⚙️ 閱讀 26.2 配置與動態遊戲規則|zh_tw-26.2-Configuration-and-GameRules]]
* [[🏛️ 閱讀 26.2 架構設計與擴充鉤子|zh_tw-26.2-Architecture-and-Addon-Hooks]]
