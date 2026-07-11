# Potion Stacker Addon Concept & Specifications

## Overview
**Potion Stacker Addon** is a standalone Fabric addon mod for Stack Size Adjuster. It provides independent stacking configurations specifically for potions, keeping beds and weapons completely unstackable.

## Mechanics
- Overrides maximum stack size of all items extending `PotionItem` (regular, splash, lingering, and water bottles).
- Configurable limit via `/gamerule potion-stacker-addon:potion_limit` (default: 16).
- Supports dynamic syncing from server to client.
