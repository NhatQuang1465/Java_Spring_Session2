# Task Management API Design

## Base URL

```
/api
```

---

# User API

## Lấy danh sách người dùng

- Method: GET
- Endpoint:

```
/api/users
```

---

## Tạo người dùng

- Method: POST
- Endpoint:

```
/api/users
```

Request Body

```json
{
  "fullName": "Nguyen Van A",
  "email": "a@gmail.com",
  "role": "USER"
}
```

---

## Cập nhật vai trò người dùng

- Method: PATCH
- Endpoint:

```
/api/users/{id}/role
```

Request Body

```json
{
  "role": "ADMIN"
}
```

---

## Xóa người dùng

- Method: DELETE
- Endpoint:

```
/api/users/{id}
```

---

## Liệt kê toàn bộ công việc của một người dùng

- Method: GET
- Endpoint:

```
/api/users/{id}/tasks
```

---

# Task API

## Lấy danh sách công việc

- Method: GET
- Endpoint:

```
/api/tasks
```

---

## Tạo công việc

- Method: POST
- Endpoint:

```
/api/tasks
```

Request Body

```json
{
  "title": "Learn Spring",
  "description": "Study Spring Boot",
  "priority": "HIGH",
  "status": "TODO",
  "assignedTo": 1
}
```

---

## Cập nhật trạng thái công việc

- Method: PATCH
- Endpoint:

```
/api/tasks/{id}/status
```

Request Body

```json
{
  "status": "DONE"
}
```

---

## Xóa công việc

- Method: DELETE
- Endpoint:

```
/api/tasks/{id}
```

---

## Tìm công việc có mức độ ưu tiên HIGH

- Method: GET
- Endpoint:

```
/api/tasks?priority=HIGH
```

---

## Tìm công việc có mức độ ưu tiên HIGH và được giao cho người dùng id = 1

- Method: GET
- Endpoint:

```
/api/tasks?priority=HIGH&assignedTo=1
```

---

## Gắn công việc cho người dùng

- Method: PATCH
- Endpoint:

```
/api/tasks/{taskId}/assign
```

Request Body

```json
{
  "userId": 1
}
```

---

# Validation

## User

- fullName không được để trống.
- email không được để trống.
- role chỉ nhận `ADMIN` hoặc `USER`.

## Task

- title không được để trống.
- priority chỉ nhận `LOW`, `MEDIUM`, `HIGH`.
- status chỉ nhận `TODO`, `IN_PROGRESS`, `DONE`.
- assignedTo phải là ID của User đã tồn tại.

---

# HTTP Status Code

| Status | Ý nghĩa |
|--------|---------|
| 200 | OK |
| 201 | Created |
| 204 | No Content |
| 400 | Bad Request |
| 404 | Not Found |