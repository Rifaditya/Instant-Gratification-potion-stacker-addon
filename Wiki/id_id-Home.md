# 🧪 Instant Gratification: Potion Stacker Addon Wiki

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **Pemberitahuan Sumber Repositori**: Dokumentasi di Wiki ini mencerminkan **status kode sumber saat ini di repositori**, yang mungkin mencakup komit terbaru yang belum dirilis atau fitur dalam pengembangan sebelum rilis publik di CurseForge dan Modrinth.

Selamat datang di dokumentasi resmi untuk **Instant Gratification: Potion Stacker Addon**. Dirancang untuk Minecraft Fabric sebagai ekstensi performa tinggi untuk **Stack Size Adjuster**, mod ini membebaskan pemain dari tumpukan botol ramuan yang tidak bisa ditumpuk dengan memperkenalkan batas tumpukan yang dapat dikonfigurasi untuk semua ramuan dan sup/semur.

---

## 🧭 Portal Dokumentasi Multi-Versi

| Minecraft Target | Mod Version | Fabric Loader | Portal Link |
| :--- | :---: | :---: | :--- |
| **Minecraft 26.2** | `1.1.3+26.2` | `>=0.19.1` | [[👉 Enter Minecraft 26.2 Documentation Portal|26.2-Home]] |
| **Minecraft 26.3** | `1.1.3+26.3` | `>=0.19.3` | [[👉 Enter Minecraft 26.3 Documentation Portal|26.3-Home]] |

---

## ⚡ Pilar Arsitektur & Filosofi Utama

1. **Kebebasan Ruang Inventaris**: Batas default 16, mendukung konfigurasi bebas hingga 2.147.483.647.
2. **Ergonomi Brewing Stand**: Slot brewing stand tetap menerima 1 botol per slot saat Shift-klik, menjaga kestabilan resep ramuan.
3. **Sinkronisasi Jaringan Real-Time**: `PotionLimitSyncPayload` dan `broadcastFullState()` mencegah barang hantu (ghost items).
4. **Koeksistensi Cerdas**: Otomatis menyerahkan penanganan semur ke `stew-stacker-addon` jika terpasang.
5. **Tanpa Beban Mixin**: Menggunakan registrasi murni ke `StackSizeManager.registerOverride`.

---

## 📊 Matriks Default GameRule

| GameRule | Type | Default | Range | Target Items |
| :--- | :---: | :---: | :---: | :--- |
| `potion-stacker-addon:potion_limit` | Integer | `16` | 1 .. 2,147,483,647 | Regular, Splash, Lingering Potions, Water Bottles |
| `potion-stacker-addon:stew_limit` | Integer | `16` | 1 .. 2,147,483,647 | Mushroom Stew, Rabbit Stew, Beetroot Soup, Suspicious Stew |

---

## 📚 Tautan Dokumentasi Penting

* [[📊 Version Compatibility Matrix|Version-Compatibility]]
* [[🔧 Troubleshooting & FAQ Guide|Troubleshooting-and-FAQ]]
* [[🛠️ Developer Setup & Build Guide|Developer-Setup-and-Building]]
* [[🏠 Return to Main Home Portal|Home]]
