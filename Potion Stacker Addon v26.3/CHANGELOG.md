# Changelog

## [1.1.4+26.3] - 2026-10-18

### Changed
- **Centralized Universal Configuration Screen**: Migrated ModMenu config screen to `UniversalConfigScreen` (`net.dasik.social.api.client.gui.UniversalConfigScreen`).
- **ConfigOption Annotations**: Replaced custom `YaclScreenHelper` with `@ConfigOption` annotations on `potionLimit` and `stewLimit`, eliminating ~154 lines of boilerplate and ensuring Knot ClassLoader side-safety.
- **Automated Creator Support Touchpoints**: Injected automated Ko-fi and Discord buttons directly into the config GUI.

## [1.1.3+26.3] - 2026-09-14

### Added
- **Minecraft 26.3 Port**: Initial release supporting Minecraft 26.3 snapshot-6.
- **Dependency Upgrades**: Compiled against Fabric Loader 0.19.3, Fabric API 0.156.1+26.3, DasikLibrary 1.8.39, and Stack Size Adjuster 1.4.18+26.3.
- **Java 25 Baseline**: Upgraded toolchain and execution target to Java 25.
