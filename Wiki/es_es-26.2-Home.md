# 🧪 Minecraft 26.2 Documentation Portal

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **Descargo de responsabilidad de la fuente del repositorio**: La documentación de esta Wiki refleja el **estado actual del código fuente en el repositorio**, que puede incluir confirmaciones recientes no publicadas o características en desarrollo antes de las compilaciones públicas en CurseForge y Modrinth.

Bienvenido al portal de documentación técnica dedicada de **Instant Gratification: Potion Stacker Addon** en **Minecraft 26.2** (objetivo `MC 26.1.2 / 26.2`). Toda la documentación en este árbol refleja los mapeos de bytecode exactos, dependencias de Loom y especificaciones de esta versión.

---

## 🧭 Matriz de Navegación de Minecraft 26.2

| Característica / Subsistema | Descripción | Página Dedicada de la Wiki |
| :--- | :--- | :--- |
| **Apilado de Pociones y Ergonomía del Inventario** | Mecánicas de apilado, soporte para soporte de pociones, matemáticas de compresión | [[26.2 Apilado de Pociones y Ergonomía del Inventario|es_es-26.2-Potion-Stacking-and-Inventory-Ergonomics]] |
| **Sincronización de Red y Cargas Útiles** | Ciclo de vida de carga útil S2C, paquetes de enlace, refresco de menús | [[26.2 Sincronización de Red y Cargas Útiles|es_es-26.2-Network-Synchronization-and-Payloads]] |
| **Configuración y GameRules Dinámicas** | Matriz de referencia completa de GameRules y opciones de YACL v3 | [[26.2 Configuración y GameRules Dinámicas|es_es-26.2-Configuration-and-GameRules]] |
| **Arquitectura y Ganchos de Expansión** | Arquitectura de paquetes, cero mixins, CustomStackSizeOverride | [[26.2 Arquitectura y Ganchos de Expansión|es_es-26.2-Architecture-and-Addon-Hooks]] |
| **Entorno de Desarrollo y Herramientas** | Entorno JDK 25, comandos de compilación Gradle 9.3+, configuración de Loom | [[26.2 Entorno de Desarrollo y Herramientas|es_es-26.2-Developer-Setup-and-Building]] |

---

## 📊 Ficha de Especificaciones Técnicas

| Parámetro | Especificación de Versión |
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

## 🧪 Aspectos Destacados del Subsistema

1. **Soporte completo para toda la familia de pociones**: Aplica tamaños de pila configurables a todas las categorías: pociones normales, arrojadizas, persistentes y botellas de agua.
2. **Integridad de ranura de soporte de pociones**: Preserva la lógica de destilación de Minecraft original colocando exactamente 1 botella por ranura al hacer Shift-clic, evitando romper recetas.
3. **Plomería de GameRules dinámicas**: Modificación completa en el juego sin reiniciar mediante `potion-stacker-addon:potion_limit` y `potion-stacker-addon:stew_limit`.
4. **Coexistencia inteligente con Stew Stacker Addon**: Detecta el addon hermano y cede automáticamente la lógica de guisos para eliminar conflictos.

---

## 🔗 Enlaces Globales y Externos
* [[🏠 Volver al Portal Principal de la Wiki|es_es-Home]]
* [[📊 Revisar la Matriz de Compatibilidad de Versiones|es_es-Version-Compatibility]]
* [[🔧 Consultar la Guía de Solución de Problemas y FAQ|es_es-Troubleshooting-and-FAQ]]
