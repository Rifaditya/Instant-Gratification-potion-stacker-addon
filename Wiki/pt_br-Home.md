# 🧪 Instant Gratification: Potion Stacker Addon Wiki

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **Aviso da Fonte do Repositório**: A documentação nesta Wiki reflete o **estado atual do código-fonte no repositório**, que pode incluir commits recentes não lançados ou recursos em desenvolvimento antes dos lançamentos públicos no CurseForge e Modrinth.

Bem-vindo à documentação oficial do **Instant Gratification: Potion Stacker Addon**. Um complemento para Fabric e **Stack Size Adjuster** que permite empilhar poções, poções arremessáveis, poções prolongadas, frascos de água, sopas e ensopados de forma dinâmica.

---

## 🧭 Portais de documentação por versão

| Minecraft Target | Mod Version | Fabric Loader | Portal Link |
| :--- | :---: | :---: | :--- |
| **Minecraft 26.2** | `1.1.3+26.2` | `>=0.19.1` | [[👉 Enter Minecraft 26.2 Documentation Portal|26.2-Home]] |
| **Minecraft 26.3** | `1.1.3+26.3` | `>=0.19.3` | [[👉 Enter Minecraft 26.3 Documentation Portal|26.3-Home]] |

---

## ⚡ Filosofia central e arquitetura

1. **Liberação de inventário**: Limite padrão de 16 itens por pilha, expansível até 2.147.483.647.
2. **Ergonomia do suporte de poções**: O suporte recebe apenas 1 frasco por slot ao usar Shift-clique, preservando receitas.
3. **Sincronização em tempo real**: `PotionLimitSyncPayload` e `broadcastFullState()` evitam itens fantasmas.
4. **Compatibilidade inteligente**: Deferimento automático para o `stew-stacker-addon` quando presente.
5. **Zero overhead de Mixins**: Integração direta via `StackSizeManager.registerOverride`.

---

## 📊 Tabela de GameRules padrão

| GameRule | Type | Default | Range | Target Items |
| :--- | :---: | :---: | :---: | :--- |
| `potion-stacker-addon:potion_limit` | Integer | `16` | 1 .. 2,147,483,647 | Regular, Splash, Lingering Potions, Water Bottles |
| `potion-stacker-addon:stew_limit` | Integer | `16` | 1 .. 2,147,483,647 | Mushroom Stew, Rabbit Stew, Beetroot Soup, Suspicious Stew |

---

## 📚 Links essenciais

* [[📊 Version Compatibility Matrix|Version-Compatibility]]
* [[🔧 Troubleshooting & FAQ Guide|Troubleshooting-and-FAQ]]
* [[🛠️ Developer Setup & Build Guide|Developer-Setup-and-Building]]
* [[🏠 Return to Main Home Portal|Home]]
