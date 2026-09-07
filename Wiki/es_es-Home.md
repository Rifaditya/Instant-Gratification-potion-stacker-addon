# 🧪 Instant Gratification: Potion Stacker Addon Wiki

🌐 **Languages**: [[🏠 Inicio de la Wiki|es_es-Home]] | [[🏠 Inicio de la Wiki|es_es-Home]] | [[🏠 Inicio de la Wiki|es_es-Home]] | [[🏠 Inicio de la Wiki|es_es-Home]] | [[🏠 Inicio de la Wiki|es_es-Home]] | [[🏠 Inicio de la Wiki|es_es-Home]] | [[🏠 Inicio de la Wiki|es_es-Home]] | [[🏠 Inicio de la Wiki|es_es-Home]] | [[🏠 Inicio de la Wiki|es_es-Home]] | [[🏠 Inicio de la Wiki|es_es-Home]] | [[🏠 Inicio de la Wiki|es_es-Home]]

> 📌 **Aviso sobre la fuente del repositorio**: La documentación de esta Wiki refleja el **estado actual del código fuente en el repositorio**, que puede incluir confirmaciones recientes no publicadas o características en desarrollo antes de los lanzamientos públicos en CurseForge y Modrinth.

Bienvenido a la documentación oficial de **Instant Gratification: Potion Stacker Addon**. Un complemento para Fabric y **Stack Size Adjuster** que permite apilar pociones regulares, arrojadizas, persistentes, botellas de agua y estofados de manera totalmente configurable.

---

## 🧭 Portales de documentación por versión

| Minecraft Target | Mod Version | Fabric Loader | Portal Link |
| :--- | :---: | :---: | :--- |
| **Minecraft 26.2** | `1.1.3+26.2` | `>=0.19.1` | [[🏠 Inicio de la Wiki|es_es-Home]] |
| **Minecraft 26.3** | `1.1.3+26.3` | `>=0.19.3` | [[🏠 Inicio de la Wiki|es_es-Home]] |

---

## ⚡ Pilares de diseño y arquitectura

1. **Espacio en inventario liberado**: Límite predeterminado de 16, configurable hasta 2,147,483,647.
2. **Ergonomía en el soporte de pociones**: Los soportes reciben 1 botella por ranura, protegiendo las recetas originales de elaboración.
3. **Sincronización en tiempo real**: `PotionLimitSyncPayload` y `broadcastFullState()` eliminan objetos fantasma.
4. **Coexistencia con Stew Stacker Addon**: Cede automáticamente el control de estofados cuando ambos están instalados.
5. **Sin sobrecarga de Mixins**: Registro limpio vía `StackSizeManager.registerOverride`.

---

## 📊 Matriz de reglas GameRule predeterminadas

| GameRule | Type | Default | Range | Target Items |
| :--- | :---: | :---: | :---: | :--- |
| `potion-stacker-addon:potion_limit` | Integer | `16` | 1 .. 2,147,483,647 | Regular, Splash, Lingering Potions, Water Bottles |
| `potion-stacker-addon:stew_limit` | Integer | `16` | 1 .. 2,147,483,647 | Mushroom Stew, Rabbit Stew, Beetroot Soup, Suspicious Stew |

---

## 📚 Enlaces de documentación esenciales

* [[📊 Matriz de Compatibilidad de Versiones|es_es-Version-Compatibility]]
* [[🔧 Solución de Problemas y FAQ|es_es-Troubleshooting-and-FAQ]]
* [[🛠️ Configuración de Desarrollador y Compilación|es_es-Developer-Setup-and-Building]]
* [[🏠 Inicio de la Wiki|es_es-Home]]
