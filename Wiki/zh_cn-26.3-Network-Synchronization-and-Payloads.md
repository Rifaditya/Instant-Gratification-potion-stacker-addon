# 📡 网络同步与数据负载 (Minecraft 26.3)

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **代码仓库来源免责声明**：本维基文档反映了**代码仓库中的当前源码状态**，可能包含领先于 CurseForge 和 Modrinth 平台公开发布版本的最新未发布提交或开发中功能。

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

## 5. 全局与外部导航
* [[🧪 返回 Minecraft 26.3 门户|zh_cn-26.3-Home]]
* [[🧪 阅读 26.3 药水堆叠与物品栏人体工学|zh_cn-26.3-Potion-Stacking-and-Inventory-Ergonomics]]
* [[⚙️ 阅读 26.3 配置与动态游戏规则|zh_cn-26.3-Configuration-and-GameRules]]
* [[🏛️ 阅读 26.3 架构设计与扩展钩子|zh_cn-26.3-Architecture-and-Addon-Hooks]]
