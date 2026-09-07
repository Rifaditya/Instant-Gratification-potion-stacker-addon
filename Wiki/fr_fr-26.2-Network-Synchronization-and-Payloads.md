# 📡 Synchronisation Réseau & Données Utiles (Minecraft 26.2)

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **Avertissement sur la source du dépôt** : La documentation de ce wiki reflète **l'état actuel du code source dans le dépôt**, qui peut inclure des commits non publiés ou des fonctionnalités en cours de développement en avance sur CurseForge et Modrinth.

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

## 5. Navigation Globale
* [[🧪 Retour au Portail Minecraft 26.2|fr_fr-26.2-Home]]
* [[🧪 Lire 26.2 Empilement de Potions & Ergonomie d'Inventaire|fr_fr-26.2-Potion-Stacking-and-Inventory-Ergonomics]]
* [[⚙️ Lire 26.2 Configuration & GameRules Dynamiques|fr_fr-26.2-Configuration-and-GameRules]]
* [[🏛️ Lire 26.2 Architecture & Crochets d'Extension|fr_fr-26.2-Architecture-and-Addon-Hooks]]
