# 🧪 Minecraft 26.3 Documentation Portal

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **저장소 소스 면책 조항**: 본 위키의 문서는 CurseForge 및 Modrinth의 공개 릴리스 빌드보다 앞선 최신 미출시 커밋이나 개발 기능을 포함할 수 있는 **저장소의 현재 소스 코드 상태**를 반영합니다.

**Minecraft 26.3**(`MC 26.3-snapshot-6 / 26.3` 타깃)용 **Instant Gratification: Potion Stacker Addon** 공식 기술 문서 포털에 오신 것을 환영합니다. 이 버전 트리의 모든 문서는 해당 스냅샷의 바이트코드 매핑, Loom 종속성 및 기능 사양을 반영합니다.

---

## 🧭 Minecraft 26.3 내비게이션 매트릭스

| 기능 / 하위 시스템 | 설명 | 전용 위키 페이지 |
| :--- | :--- | :--- |
| **포션 스태킹 및 인벤토리 인체공학** | 스태킹 메커니즘, 양조기 슬롯 제어, 보관함 압축 계산 | [[26.3 포션 스태킹 및 인벤토리 인체공학|ko_kr-26.3-Potion-Stacking-and-Inventory-Ergonomics]] |
| **네트워크 동기화 및 페이로드** | S2C 페이로드 수명 주기, 핸드셰이크 패킷, 메뉴 동적 갱신 | [[26.3 네트워크 동기화 및 페이로드|ko_kr-26.3-Network-Synchronization-and-Payloads]] |
| **구성 및 동적 게임 규칙** | 모든 GameRule 및 YACL v3 옵션의 전체 참조 매트릭스 | [[26.3 구성 및 동적 게임 규칙|ko_kr-26.3-Configuration-and-GameRules]] |
| **아키텍처 및 애드온 확장 훅** | 패키지 아키텍처, 제로 Mixin 설계, CustomStackSizeOverride | [[26.3 아키텍처 및 애드온 확장 훅|ko_kr-26.3-Architecture-and-Addon-Hooks]] |
| **개발자 설정 및 툴체인** | JDK 25 환경, Gradle 9.3+ 빌드 명령, Loom 설정 | [[26.3 개발자 설정 및 툴체인|ko_kr-26.3-Developer-Setup-and-Building]] |

---

## 📊 기술 사양 정보 상자

| 매개변수 | 버전 사양 |
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

## 🧪 핵심 하위 시스템 주요 기능

1. **모든 포션 제품군 완벽 지원**: 일반 음용 포션, 투척용 포션, 잔류형 포션, 물병 등 모든 카테고리에 사용자 지정 스택 크기 적용.
2. **양조기 슬롯 무결성 보장**: Shift-클릭 시 빈 양조기 슬롯마다 정확히 1병씩 투입하여 레시피 파괴를 방지하고 인벤토리의 나머지 스택을 온전히 유지.
3. **동적 게임 규칙 제어**: `potion-stacker-addon:potion_limit` 및 `potion-stacker-addon:stew_limit`을 통해 재시작 없이 게임 내 즉각 변경 가능.
4. **지능적인 애드온 공존**: `stew-stacker-addon`을 감지하여 스튜/수프 스태킹 로직을 자동으로 위임하고 충돌을 완벽 방지.

---

## 🔗 전역 및 외부 내비게이션
* [[🏠 위키 메인 포털로 돌아가기|ko_kr-Home]]
* [[📊 전역 버전 호환성 매트릭스 확인|ko_kr-Version-Compatibility]]
* [[🔧 문제 해결 및 FAQ 가이드 확인|ko_kr-Troubleshooting-and-FAQ]]
