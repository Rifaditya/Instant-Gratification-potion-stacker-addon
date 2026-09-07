# 🧪 即時滿足：藥水堆疊擴展 Wiki

🌐 **Languages**: [[🏠 維基首頁|zh_tw-Home]] | [[🏠 維基首頁|zh_tw-Home]] | [[🏠 維基首頁|zh_tw-Home]] | [[🏠 維基首頁|zh_tw-Home]] | [[🏠 維基首頁|zh_tw-Home]] | [[🏠 維基首頁|zh_tw-Home]] | [[🏠 維基首頁|zh_tw-Home]] | [[🏠 維基首頁|zh_tw-Home]] | [[🏠 維基首頁|zh_tw-Home]] | [[🏠 維基首頁|zh_tw-Home]] | [[🏠 維基首頁|zh_tw-Home]]

> 📌 **代碼倉庫來源聲明**：本 Wiki 中的技術文檔反映了**代碼倉庫中當前的源代碼狀態**，可能包含領先於 CurseForge 與 Modrinth 正式發布版本的未發布提交或開發中特性。

歡迎查閱 **Instant Gratification: Potion Stacker Addon（即時滿足：藥水堆疊擴展）** 官方技術文檔。本項目是為 Minecraft Fabric 平台設計的 **Stack Size Adjuster** 專用高性能擴展模組，徹底解決自 Beta 1.9 以來藥水佔用背包槽位過多的痛點。支援對常規藥水、漂濺藥水、滯留藥水、水瓶以及燉菜進行無縫動態堆疊配置。

---

## 🧭 多版本文檔傳送門

| Minecraft Target | Mod Version | Fabric Loader | Portal Link |
| :--- | :---: | :---: | :--- |
| **Minecraft 26.2** | `1.1.3+26.2` | `>=0.19.1` | [[🏠 維基首頁|zh_tw-Home]] |
| **Minecraft 26.3** | `1.1.3+26.3` | `>=0.19.3` | [[🏠 維基首頁|zh_tw-Home]] |

---

## ⚡ 核心設計理念與技術支柱

1. **釋放背包空間**：預設將藥水最大堆疊數提升至 16，並支援在 1 到 2,147,483,647 之間自由配置。
2. **符合直覺的釀造台互動**：釀造台藥水槽保持單瓶容量，Shift 快速放入時智慧拆分 1 瓶進入槽位，避免破壞原版釀造機制。
3. **客戶端/伺服端網絡動態同步**：透過 `PotionLimitSyncPayload` 與 `broadcastFullState()` 即時同步遊戲規則，消除幽靈物品。
4. **智慧共存機制**：與 `stew-stacker-addon` 共同安裝時，自動檢測並讓渡燉菜處理邏輯，零衝突。
5. **零 Mixin 效能開銷**：純 API 驅動架構，直接向 `StackSizeManager` 註冊 `CustomStackSizeOverride` 回呼。

---

## 📊 預設 GameRule 快速參考表

| GameRule | Type | Default | Range | Target Items |
| :--- | :---: | :---: | :---: | :--- |
| `potion-stacker-addon:potion_limit` | Integer | `16` | 1 .. 2,147,483,647 | Regular, Splash, Lingering Potions, Water Bottles |
| `potion-stacker-addon:stew_limit` | Integer | `16` | 1 .. 2,147,483,647 | Mushroom Stew, Rabbit Stew, Beetroot Soup, Suspicious Stew |

---

## 📚 重要文檔連結

* [[📊 版本相容性矩陣|zh_tw-Version-Compatibility]]
* [[🔧 疑難排解與常見問題|zh_tw-Troubleshooting-and-FAQ]]
* [[🛠️ 開發者環境配置與構建指南|zh_tw-Developer-Setup-and-Building]]
* [[🏠 維基首頁|zh_tw-Home]]
