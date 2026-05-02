# 📅 API de Agendamento de Reuniões

![Java](https://img.shields.io/badge/Java-17+-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen)
![Status](https://img.shields.io/badge/status-ativo-success)
![Licença](https://img.shields.io/badge/license-MIT-blue)

API REST para gerenciamento de agendamentos de reuniões e mensagens.  
Desenvolvida com Spring Boot, seguindo boas práticas como arquitetura em camadas, uso de DTOs, tratamento global de exceções e validações.

---

## 🧠 Arquitetura do Projeto

O projeto segue uma arquitetura em camadas:


### 📦 Camadas

- **Controller** → endpoints HTTP
- **Service** → regras de negócio
- **Repository** → acesso ao banco de dados
- **Entity** → modelo JPA
- **DTOs** → entrada e saída da API
- **Mapper** → conversão entre Entity e DTO
- **Exception Handler** → tratamento global de erros

---

## 🚀 Funcionalidades

- Criar agendamento
- Buscar agendamento por ID
- Atualizar agendamento
- Cancelar agendamento (soft delete)
- Controle de status:
  - `SCHEDULED`
  - `SENT`
  - `CANCELED`
- Validação de dados com Bean Validation
- Tratamento global de exceções
- Respostas de erro padronizadas
- Documentação com Swagger/OpenAPI

---

## 🛠️ Tecnologias utilizadas

- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- MySql
- Bean Validation (Jakarta Validation)
- Lombok
- Swagger / OpenAPI 3
- Maven

---

## 📌 Diagrama simplificado da entidade
Scheduling:
id
receiver_email
receiver_telephone
message
meeting_date
status
created_at
modified_at


---

## 📡 Endpoints da API

➕ Criar agendamento
```http
POST /api/v1/schedulings

🔍 Buscar por ID
GET /api/v1/schedulings/{id}

✏️ Atualizar agendamento
PUT /api/v1/schedulings/{id}

❌ Cancelar agendamento
DELETE /api/v1/schedulings/{id}

📥 Exemplo de requisição
{
  "id": 1,
  "receiverEmail": "usuario@email.com",
  "receiverTelephone": "11999999999",
  "message": "Confirmação de reunião",
  "meetingDate": "25/12/2026 14:00",
  "status": "SCHEDULED",
  "createdAt": "25/12/2026 10:00",
  "modifiedAt": null
}

⚠️ Tratamento de erros
Resposta padrão de erro:
{
  "path": "/api/v1/schedulings/1",
  "method": "GET",
  "status": 404,
  "statusText": "Não encontrado",
  "message": "Agendamento não encontrado. ID = 1",
  "errors": null
}
Erros de validação:
{
  "message": "Um ou mais campos são inválidos",
  "errors": {
    "receiverEmail": "Informe um e-mail válido"
  }
}

📚 Swagger
http://localhost:8080/swagger-ui.html

▶️ Como executar o projeto
1. Clonar o repositório
git clone https://github.com/acsanfrancisco/meeting-scheduler-api
2. Compilar o projeto
mvn clean install
3. Executar a aplicação
mvn spring-boot:run

👨‍💻 Autor
Desenvolvido por João Francisco
