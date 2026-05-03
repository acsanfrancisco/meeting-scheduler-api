# 📅 Meeting Scheduler API

API REST para agendamento de **mensagens ou reuniões**, desenvolvida com **Java + Spring Boot**, aplicando boas práticas como DTOs, camada de serviço, validações e documentação com Swagger.

---

## 🚀 Funcionalidades

### 📌 Agendamentos (Schedulings)

* ✅ Criar um novo agendamento
* ✅ Buscar agendamento por ID
* ✅ Atualizar um agendamento
* ✅ Cancelar agendamento (Soft Delete)
* ✅ Controle de status (`SCHEDULED`, `SENT`, `CANCELED`)
* ✅ Validação de dados de entrada
* ✅ Tratamento global de exceções

---

## 🛠️ Tecnologias utilizadas

* Java 17+
* Spring Boot
* Spring Web
* Spring Data JPA
* Bean Validation (Jakarta Validation)
* Lombok
* Swagger / OpenAPI
* MySql DataBase
* Maven

---

## 📌 Endpoints

### Base URL

```
/api/v1/schedulings
```

---

### 🔹 Criar agendamento

**POST /**

```json
{
  "receiverEmail": "teste@email.com",
  "receiverTelephone": "(11) 99999-9999",
  "message": "Mensagem de teste",
  "meetingDate": "25/12/2026 14:00"
}
```

---

### 🔹 Buscar por ID

**GET /{id}**

```json
{
  "id": 1,
  "receiverEmail": "teste@email.com",
  "receiverTelephone": "(11) 99999-9999",
  "message": "Mensagem de teste",
  "meetingDate": "25/12/2026 14:00",
  "status": "SCHEDULED",
  "createdAt": "01/05/2026 10:00",
  "modifiedAt": null
}
```

---

### 🔹 Atualizar agendamento

**PUT /{id}**

```json
{
  "receiverEmail": "novo@email.com",
  "receiverTelephone": "(11) 98888-8888",
  "message": "Mensagem atualizada",
  "meetingDate": "30/12/2026 16:00"
}
```

---

### 🔹 Cancelar agendamento

**DELETE /{id}**

```
204 No Content
```

👉 O cancelamento é lógico (Soft Delete), alterando o status para `CANCELED`.

---

## ❗ Validações

* `receiverEmail` → obrigatório e formato válido
* `receiverTelephone` → obrigatório e formato brasileiro válido
* `message` → obrigatório
* `meetingDate` → obrigatório e deve ser uma data futura

---

## ⚠️ Tratamento de Exceções

O projeto utiliza `@RestControllerAdvice` para tratamento global.

### Principais erros tratados:

* `SchedulingNotFoundException` → agendamento não encontrado (404)
* `SchedulingAlreadyCanceledException` → já cancelado (400)
* `MethodArgumentNotValidException` → erro de validação (400)
* `HttpMessageNotReadableException` → JSON inválido (400)
* `Exception` → erro inesperado (500)

---

### 📌 Exemplo de erro

```json
{
  "path": "/api/v1/schedulings/10",
  "method": "GET",
  "status": 404,
  "statusText": "Not Found",
  "message": "Scheduling not found. ID = 10"
}
```

---

## 📖 Documentação da API (Swagger)

```
http://localhost:8080/swagger-ui/index.html
```

---

## ⚙️ Como rodar o projeto

```bash
git clone https://github.com/acsanfrancisco/meeting-scheduler-api.git
cd meeting-scheduler-api
./mvnw spring-boot:run
```

---

## 🧪 Banco de dados

MySQL

```
```

---

## 🧱 Arquitetura

* **Controller** → endpoints REST
* **Service** → regras de negócio
* **Repository** → acesso ao banco
* **DTOs** → transporte de dados
* **Mapper** → conversão Entity ↔ DTO
* **Exception Handler** → tratamento global

---
---
