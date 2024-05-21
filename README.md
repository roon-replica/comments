# 기능 구현 목록
### 서버
- [x] 간단 category CRUD API
  - [x] post 생성/삭제에 따른 postsCount 변경
- [x] 간단 posts CRUD API
  - [x] post wordCount 계산 후 저장
  - [x] post wordCount 검증
- [x] feature 토글링
  - tag name validation에 시범 적용 (제거)
- [ ] comment 무한 뎁스 구조 API
  - [x] 단순 CRUD
  - [ ] 부모있는 1depth 댓글 CRUD
  - [ ] 무한depth 댓글
- [ ] soft delete
- [ ] view, like count
- [ ] comment vote
- [ ] comment에 이미지, 사진 첨부
- [ ] CRUD 기타
  - [ ] page based pagination
  - [ ] cursor based pagination
- [ ] 동시성 이슈
  - [ ] count 같은거 redis로?
- [ ] 트래픽, 성능 이슈
- [ ] security
  - [ ] api 보호 및 현재 유저 정보..
  - [ ] 로그인
    - [ ] 소셜 로그인
    - [ ] SSO
- [ ] mongodb 관련
  - [ ] _class 없애기?
  - [ ] 트랜잭션 사실상 못쓰는데 대처법?
  - [ ] index
  - [ ] join

### 화면...
  - [ ] 댓글 화면