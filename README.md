# jpa
## DB 실행

```bash
cd db
cp .env.example .env   # DB_PASS 값 수정
docker compose up -d
```

애플리케이션 DB 비밀번호는 `DB_PASSWORD` 환경 변수로 지정합니다 (기본값 `changeme`).
