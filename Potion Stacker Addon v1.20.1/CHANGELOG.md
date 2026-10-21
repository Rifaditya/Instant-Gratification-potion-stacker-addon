# Changelog - Potion Stacker Addon (Minecraft 1.20.1)

All notable changes to this project will be documented in this file.
The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [1.0.0+1.20.1] - 2026-10-21

### Added
- Initial release for Minecraft 1.20.1.
- Custom stack size override integration for potions and stews via Stack Size Adjuster.
- Fully dynamic `/gamerule potion-stacker-addon:potion_limit` and `potion-stacker-addon:stew_limit` GameRules.
- S2C packet synchronization via `FriendlyByteBuf` and `ServerPlayNetworking`.
- Optional client configuration GUI with Mod Menu and UniversalConfigScreen powered by DasikLibrary.
