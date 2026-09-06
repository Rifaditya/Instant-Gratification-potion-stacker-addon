# 🧪 Instant Gratification: Potion Stacker Addon Wiki

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **Отказ от ответственности за источник репозитория**: Документация в этой Wiki отражает **текущее состояние исходного кода в репозитории**, которое может включать недавние невыпущенные коммиты или функции разработки, опережающие общедоступные сборки на CurseForge и Modrinth.

Добро пожаловать в официальную документацию **Instant Gratification: Potion Stacker Addon**. Это дополнение для **Stack Size Adjuster** на Fabric, позволяющее динамически настраивать лимиты стака для обычных зелий, взрывных зелий, оседающих зелий, колб с водой, а также супов и рагу.

---

## 🧭 Порталы документации по версиям

| Minecraft Target | Mod Version | Fabric Loader | Portal Link |
| :--- | :---: | :---: | :--- |
| **Minecraft 26.2** | `1.1.3+26.2` | `>=0.19.1` | [[👉 Enter Minecraft 26.2 Documentation Portal|26.2-Home]] |
| **Minecraft 26.3** | `1.1.3+26.3` | `>=0.19.3` | [[👉 Enter Minecraft 26.3 Documentation Portal|26.3-Home]] |

---

## ⚡ Основные принципы и архитектура

1. **Освобождение инвентаря**: Лимит по умолчанию 16, с полной свободой настройки до 2,147,483,647.
2. **Эргономика варочной стойки**: Стойка принимает строго по 1 зелью на слот при Shift-клике, предотвращая сбои рецептов.
3. **Сетевая синхронизация**: Мгновенное обновление через `PotionLimitSyncPayload` и `broadcastFullState()` устраняет фантомные предметы.
4. **Совместимость со Stew Stacker Addon**: Автоматически уступает управление супами при совместной установке.
5. **Нулевой оверхед Mixin**: Чистая регистрация через `StackSizeManager.registerOverride`.

---

## 📊 Таблица стандартных правил GameRule

| GameRule | Type | Default | Range | Target Items |
| :--- | :---: | :---: | :---: | :--- |
| `potion-stacker-addon:potion_limit` | Integer | `16` | 1 .. 2,147,483,647 | Regular, Splash, Lingering Potions, Water Bottles |
| `potion-stacker-addon:stew_limit` | Integer | `16` | 1 .. 2,147,483,647 | Mushroom Stew, Rabbit Stew, Beetroot Soup, Suspicious Stew |

---

## 📚 Основные разделы документации

* [[📊 Version Compatibility Matrix|Version-Compatibility]]
* [[🔧 Troubleshooting & FAQ Guide|Troubleshooting-and-FAQ]]
* [[🛠️ Developer Setup & Build Guide|Developer-Setup-and-Building]]
* [[🏠 Return to Main Home Portal|Home]]
