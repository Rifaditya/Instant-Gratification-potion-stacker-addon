# Potion Stacker Addon

An addon for **Stack Size Adjuster** that allows customizing stack limits for potions dynamically using GameRules or configuration screens.

Part of the **Instant Gratification Collection** — mods that respect the player's time.

---

## ✨ Features

- **Dynamic Potion Stacking**: Allows regular potions, splash potions, lingering potions, and water bottles to stack up to custom limits (default: `16`).
- **Stew & Soup Stacking**: Independent stacking limits for mushroom stew, rabbit stew, beetroot soup, and suspicious stews (default: `16`).
- **Smart Addon Deferral**: Automatically defers stew handling to `Stew Stacker Addon` when co-installed to prevent priority conflicts.
- **Dynamic GameRules**:
  - `potion-stacker-addon:potion_limit` (Default: 16, Range: 1 to 2,147,483,647)
  - `potion-stacker-addon:stew_limit` (Default: 16, Range: 1 to 2,147,483,647)
- **GUI Configuration**: Full integration with ModMenu and YetAnotherConfigLib (YACL) for dynamic client-side settings.
- **Instant Synchronization**: Synchronizes server-side configurations to client on join and world reload.
