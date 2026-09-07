# 🧪 인스턴트 그라티피케이션: 포션 스태커 애드온 Wiki

🌐 **Languages**: [[🏠 위키 홈|ko_kr-Home]] | [[🏠 위키 홈|ko_kr-Home]] | [[🏠 위키 홈|ko_kr-Home]] | [[🏠 위키 홈|ko_kr-Home]] | [[🏠 위키 홈|ko_kr-Home]] | [[🏠 위키 홈|ko_kr-Home]] | [[🏠 위키 홈|ko_kr-Home]] | [[🏠 위키 홈|ko_kr-Home]] | [[🏠 위키 홈|ko_kr-Home]] | [[🏠 위키 홈|ko_kr-Home]] | [[🏠 위키 홈|ko_kr-Home]]

> 📌 **저장소 소스 고지사항**: 이 위키의 문서는 **저장소의 현재 소스 코드 상태**를 반영하며, CurseForge 및 Modrinth의 공개 릴리스 빌드에 앞서 최근 릴리스되지 않은 커밋이나 개발 기능이 포함될 수 있습니다.

**Instant Gratification: Potion Stacker Addon**의 공식 기술 문서에 오신 것을 환영합니다. 본 모드는 마인크래프트 패브릭용 **Stack Size Adjuster**의 전용 고성능 확장 모드로, 일반 물약, 투척용 물약, 잔류형 물약, 물병 및 스튜류의 최대 보관 스택 수를 자유롭게 조절할 수 있도록 설계되었습니다.

---

## 🧭 버전별 문서 포털

| Minecraft Target | Mod Version | Fabric Loader | Portal Link |
| :--- | :---: | :---: | :--- |
| **Minecraft 26.2** | `1.1.3+26.2` | `>=0.19.1` | [[🏠 위키 홈|ko_kr-Home]] |
| **Minecraft 26.3** | `1.1.3+26.3` | `>=0.19.3` | [[🏠 위키 홈|ko_kr-Home]] |

---

## ⚡ 핵심 설계 철학 및 아키텍처

1. **인벤토리 공간 해방**: 기본 스택 한도 16개, 최대 2,147,483,647까지 완전한 설정 자유도 지원.
2. **양조기 인터랙션 호환성**: 양조기 슬롯은 1병 규격을 유지하며 Shift 클릭 시 1병씩 안전하게 분할 투입.
3. **실시간 네트워크 동기화**: `PotionLimitSyncPayload` 및 `broadcastFullState()`를 통해 고스트 아이템 완벽 차단.
4. **Stew Stacker Addon과의 지능적 공존**: 스튜 전용 애드온 감지 시 스튜 계산 권한을 자동 양보.
5. **제로 믹스인 오버헤드**: `StackSizeManager.registerOverride`를 통한 순수 이벤트/API 기반 연동.

---

## 📊 기본 GameRule 매트릭스

| GameRule | Type | Default | Range | Target Items |
| :--- | :---: | :---: | :---: | :--- |
| `potion-stacker-addon:potion_limit` | Integer | `16` | 1 .. 2,147,483,647 | Regular, Splash, Lingering Potions, Water Bottles |
| `potion-stacker-addon:stew_limit` | Integer | `16` | 1 .. 2,147,483,647 | Mushroom Stew, Rabbit Stew, Beetroot Soup, Suspicious Stew |

---

## 📚 주요 문서 바로가기

* [[📊 버전 호환성 매트릭스|ko_kr-Version-Compatibility]]
* [[🔧 문제 해결 및 FAQ|ko_kr-Troubleshooting-and-FAQ]]
* [[🛠️ 개발자 환경 설정 및 통합 빌드 가이드|ko_kr-Developer-Setup-and-Building]]
* [[🏠 위키 홈|ko_kr-Home]]
