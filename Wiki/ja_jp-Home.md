# 🧪 インスタント・グラティフィケーション：ポーションスタッカー追加パック Wiki

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **リポジトリソース免責事項**: このWikiのドキュメントは**リポジトリ内の現在のソースコード状態**を反映しており、CurseForgeおよびModrinthでの公開リリース前の開発中機能や最新コミットが含まれる場合があります。

**Instant Gratification: Potion Stacker Addon** の公式技術Wikiへようこそ。本MODはMinecraft Fabric向けに開発された **Stack Size Adjuster** の専用拡張アドオンであり、ポーション、スプラッシュポーション、残留ポーション、水入り瓶、各種シチューやスープのスタック上限を柔軟に拡張します。

---

## 🧭 バージョン別ドキュメントポータル

| Minecraft Target | Mod Version | Fabric Loader | Portal Link |
| :--- | :---: | :---: | :--- |
| **Minecraft 26.2** | `1.1.3+26.2` | `>=0.19.1` | [[👉 Enter Minecraft 26.2 Documentation Portal|26.2-Home]] |
| **Minecraft 26.3** | `1.1.3+26.3` | `>=0.19.3` | [[👉 Enter Minecraft 26.3 Documentation Portal|26.3-Home]] |

---

## ⚡ 設計方針とコアアーキテクチャ

1. **インベントリの解放**: デフォルトで16個までスタック可能、最大2,147,483,647まで無制限に設定可能。
2. **醸造台の親和性**: シフトクリック時に醸造スロットへ1本ずつ正しく装填され、醸造レシピを壊しません。
3. **リアルタイムネットワーク同期**: `PotionLimitSyncPayload` と `broadcastFullState()` によりゴーストアイテムを完全防止。
4. **Stew Stacker Addonとの共存**: シチューアドオンが導入されている場合は自動的に処理を委譲。
5. **ゼロMixinオーバーヘッド**: `StackSizeManager.registerOverride` による純粋なAPIコールバック設計。

---

## 📊 デフォルトゲームルール一覧

| GameRule | Type | Default | Range | Target Items |
| :--- | :---: | :---: | :---: | :--- |
| `potion-stacker-addon:potion_limit` | Integer | `16` | 1 .. 2,147,483,647 | Regular, Splash, Lingering Potions, Water Bottles |
| `potion-stacker-addon:stew_limit` | Integer | `16` | 1 .. 2,147,483,647 | Mushroom Stew, Rabbit Stew, Beetroot Soup, Suspicious Stew |

---

## 📚 主要ドキュメントリンク

* [[📊 Version Compatibility Matrix|Version-Compatibility]]
* [[🔧 Troubleshooting & FAQ Guide|Troubleshooting-and-FAQ]]
* [[🛠️ Developer Setup & Build Guide|Developer-Setup-and-Building]]
* [[🏠 Return to Main Home Portal|Home]]
