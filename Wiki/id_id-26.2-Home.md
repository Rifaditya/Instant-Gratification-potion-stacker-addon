# 🧪 Minecraft 26.2 Documentation Portal

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **Pernyataan Sumber Repositori**: Dokumentasi dalam Wiki ini mencerminkan **status kode sumber saat ini di repositori**, yang mungkin mencakup komit terbaru yang belum dirilis atau fitur dalam tahap pengembangan mendahului build rilis publik di CurseForge dan Modrinth.

Selamat datang di portal dokumentasi teknis **Instant Gratification: Potion Stacker Addon** untuk **Minecraft 26.2** (menargetkan `MC 26.1.2 / 26.2`). Seluruh dokumentasi mencerminkan pemetaan bytecode, dependensi Loom, dan spesifikasi fitur yang tepat untuk rilis ini.

---

## 🧭 Matriks Navigasi Minecraft 26.2

| Fitur / Subsistem | Deskripsi | Halaman Wiki Khusus |
| :--- | :--- | :--- |
| **Penumpukan Ramuan & Ergonomi Inventaris** | Mekanika penumpukan, penanganan stan pembuatan ramuan, kompresi kontainer | [[26.2 Penumpukan Ramuan & Ergonomi Inventaris|id_id-26.2-Potion-Stacking-and-Inventory-Ergonomics]] |
| **Sinkronisasi Jaringan & Muatan Data** | Siklus hidup payload S2C, paket jabat tangan, pembaruan menu dinamis | [[26.2 Sinkronisasi Jaringan & Muatan Data|id_id-26.2-Network-Synchronization-and-Payloads]] |
| **Konfigurasi & GameRules Dinamis** | Matriks referensi lengkap semua GameRule dan opsi YACL v3 | [[26.2 Konfigurasi & GameRules Dinamis|id_id-26.2-Configuration-and-GameRules]] |
| **Arsitektur & Kait Ekstensi Addon** | Arsitektur paket, nol mixin, callback CustomStackSizeOverride | [[26.2 Arsitektur & Kait Ekstensi Addon|id_id-26.2-Architecture-and-Addon-Hooks]] |
| **Pengaturan Pengembang & Toolchain** | Lingkungan JDK 25, perintah build Gradle 9.3+, konfigurasi Loom | [[26.2 Pengaturan Pengembang & Toolchain|id_id-26.2-Developer-Setup-and-Building]] |

---

## 📊 Kotak Info Spesifikasi Teknis

| Parameter | Spesifikasi Versi |
| :--- | :--- |
| **Minecraft Release Target** | `MC 26.1.2 / 26.2` |
| **Mod SemVer Release** | `1.1.3+26.2` |
| **Fabric Loader Requirement** | `>=0.19.1` |
| **Java Platform** | OpenJDK 25 (Hotspot 64-bit) |
| **Fabric API Dependency** | `0.150.1+26.2` |
| **DasikLibrary Dependency** | `>=1.8.3` |
| **Stack Size Adjuster Dependency** | `>=1.4.10+26.2` |
| **Mixin Footprint** | 0 Mixins (Pure Callback Delegation) |
| **Primary Network Payload** | `potion-stacker:sync_limit` |

---

## 🧪 Sorotan Subsistem Utama

1. **Dukungan Penuh Keluarga Ramuan**: Menerapkan batas tumpukan untuk semua kategori: ramuan minum biasa, ramuan lempar, ramuan bertahan, dan botol air biasa.
2. **Integritas Slot Stan Pembuatan Ramuan**: Menjaga logika pembuatan ramuan vanilla dengan menempatkan tepat 1 botol per slot saat Shift-klik, menjaga sisa tumpukan di inventaris.
3. **GameRules Dinamis**: Modifikasi dalam game tanpa restart melalui `potion-stacker-addon:potion_limit` dan `potion-stacker-addon:stew_limit`.
4. **Koeksistensi Cerdas**: Mendeteksi addon `stew-stacker-addon` dan menyerahkan logika penumpukan rebusan/sup tanpa konflik.

---

## 🔗 Tautan Global & Eksternal
* [[🏠 Kembali ke Beranda Utama Wiki|id_id-Home]]
* [[📊 Tinjau Matriks Kompatibilitas Versi|id_id-Version-Compatibility]]
* [[🔧 Konsultasikan Panduan Pemecahan Masalah & FAQ|id_id-Troubleshooting-and-FAQ]]
