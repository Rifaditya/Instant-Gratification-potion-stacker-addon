# Changelog

## [1.1.3+26.2] - 2026-08-10

### Fixed
- **CustomStackSizeOverride Alignment**: Updated `PotionStackerFabric` to register directly with `CustomStackSizeOverride`, preventing unhandled item fallback issues in `StackSizeManager`.

## [1.1.2+26.2] - 2026-08-10

### Fixed
- **Multi-Addon Interoperability**: Updated `PotionStackerManager` to check if `stew-stacker-addon` is loaded. When `stew-stacker-addon` is installed, `Potion Stacker Addon` automatically defers stew handling to `Stew Stacker Addon`, preventing priority conflicts when all 3 mods are installed together.

## [1.1.1+26.2] - 2026-07-22

### Changed
- Compressed mod icon asset from 1024x1024 to 128x128 (600KB → 13KB), reducing total JAR size significantly.
- Aligned `dasik-library` dependency to open-ended lower bound (`>=1.8.3`) instead of wildcard.

## [1.1.0+26.2] - 2026-07-15

### Added
- Independent custom stew and soup stacking limits (default: 16) for Mushroom Stew, Rabbit Stew, Beetroot Soup, and Suspicious Stew.
- Added `stew_limit` YACL config screen option and dynamic game rule sync capability.

## [1.0.1+26.2] - 2026-07-11

### Removed
- Removed live GameRule sync on config save. Changing config values now only defines default settings for new worlds, allowing each world to maintain independent GameRule settings.

## [1.0.0+26.2] - 2026-07-11

### Added
- Initial release of **Potion Stacker Addon** mod.
- Independent custom potion stacking limits (default: 16) for potions, splash potions, lingering potions, and water bottles.
- Synchronized server-side configurations to client on join.
- Full integration with YetAnotherConfigLib (YACL) and ModMenu for dynamic client-side settings.
