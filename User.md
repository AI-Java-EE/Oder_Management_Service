# Demo Testing (curl)

### 1) Create user (valid)

```bash
curl -X POST http://localhost:8080/api/users \
  -H "Content-Type: application/json" \
  -d '{"name":"Jon","email":"jon@mail.com"}'
```

### 2) Create user (invalid → validation 400)

```bash
curl -X POST http://localhost:8080/api/users \
  -H "Content-Type: application/json" \
  -d '{"name":"","email":"not-email"}'
```

### 3) Get user (not found → 404)

```bash
curl http://localhost:8080/api/users/unknown-id
```

### 4) Duplicate email (conflict → 409)

Create same email twice.
