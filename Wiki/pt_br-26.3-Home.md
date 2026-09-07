# 🧪 Minecraft 26.3 Documentation Portal

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **Isenção de responsabilidade da fonte do repositório**: A documentação nesta Wiki reflete o **estado atual do código-fonte no repositório**, que pode incluir commits recentes não lançados ou recursos em desenvolvimento à frente dos lançamentos públicos no CurseForge e Modrinth.

Bem-vindo ao portal de documentação técnica dedicada do **Instant Gratification: Potion Stacker Addon** no **Minecraft 26.3** (visando `MC 26.3-snapshot-6 / 26.3`). Todos os documentos refletem os mapeamentos de bytecode exatos, dependências Loom e especificações deste snapshot.

---

## 🧭 Matriz de Navegação do Minecraft 26.3

| Recurso / Subsistema | Descrição | Página Dedicada da Wiki |
| :--- | :--- | :--- |
| **Empilhamento de Poções e Ergonomia de Inventário** | Mecânicas de empilhamento, suporte de poções, matemática de compressão | [[26.3 Empilhamento de Poções e Ergonomia de Inventário|pt_br-26.3-Potion-Stacking-and-Inventory-Ergonomics]] |
| **Sincronização de Rede e Payloads** | Ciclo de vida do payload S2C, pacotes de handshake, atualização de menus | [[26.3 Sincronização de Rede e Payloads|pt_br-26.3-Network-Synchronization-and-Payloads]] |
| **Configuração e GameRules Dinâmicas** | Matriz de referência completa de GameRules e opções do YACL v3 | [[26.3 Configuração e GameRules Dinâmicas|pt_br-26.3-Configuration-and-GameRules]] |
| **Arquitetura e Hooks de Extensão** | Arquitetura de pacotes, zero mixins, CustomStackSizeOverride | [[26.3 Arquitetura e Hooks de Extensão|pt_br-26.3-Architecture-and-Addon-Hooks]] |
| **Ambiente de Desenvolvimento e Toolchain** | Ambiente JDK 25, comandos de compilação Gradle 9.3+, Loom | [[26.3 Ambiente de Desenvolvimento e Toolchain|pt_br-26.3-Developer-Setup-and-Building]] |

---

## 📊 Infobox de Especificações Técnicas

| Parâmetro | Especificação da Versão |
| :--- | :--- |
| **Minecraft Release Target** | `MC 26.3-snapshot-6 / 26.3` |
| **Mod SemVer Release** | `1.1.3+26.3` |
| **Fabric Loader Requirement** | `>=0.19.3` |
| **Java Platform** | OpenJDK 25 (Hotspot 64-bit) |
| **Fabric API Dependency** | `0.156.1+26.3` |
| **DasikLibrary Dependency** | `>=1.8.36` |
| **Stack Size Adjuster Dependency** | `>=1.4.18` |
| **Mixin Footprint** | 0 Mixins (Pure Callback Delegation) |
| **Primary Network Payload** | `potion-stacker:sync_limit` |

---

## 🧪 Destaques do Subsistema Principal

1. **Suporte completo para toda a família de poções**: Aplica limites configuráveis a todas as poções: bebíveis, arremessáveis, prolongadas e frascos com água.
2. **Integridade do suporte de poções**: Preserva a lógica original ao depositar exatamente 1 frasco por compartimento com Shift-clique, mantendo a pilha restante no inventário.
3. **GameRules dinâmicas**: Modificação no jogo sem reiniciar através de `potion-stacker-addon:potion_limit` e `potion-stacker-addon:stew_limit`.
4. **Coexistência inteligente**: Detecta o addon irmão `stew-stacker-addon` e cede automaticamente a lógica de ensopados sem conflitos.

---

## 🔗 Navegação Global
* [[🏠 Voltar ao Portal Principal da Wiki|pt_br-Home]]
* [[📊 Ver a Matriz de Compatibilidade de Versões|pt_br-Version-Compatibility]]
* [[🔧 Consultar o Guia de Solução de Problemas e FAQ|pt_br-Troubleshooting-and-FAQ]]
