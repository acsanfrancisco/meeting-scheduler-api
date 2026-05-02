# 📅 API de Agendamento de Reuniões

API REST para gerenciamento de agendamentos de reuniões e mensagens, desenvolvida com Spring Boot.

---

## 📡 Endpoints da API

➕ Criar agendamento  
POST /api/v1/schedulings  

🔍 Buscar por ID  
GET /api/v1/schedulings/{id}  

✏️ Atualizar agendamento  
PUT /api/v1/schedulings/{id}  

❌ Cancelar agendamento  
DELETE /api/v1/schedulings/{id}  

---

## 📥 Exemplo de requisição (CREATE / UPDATE)

```json
{
  "receiverEmail": "usuario@email.com",
  "receiverTelephone": "11999999999",
  "message": "Confirmação de reunião",
  "meetingDate": "25/12/2026 14:00"
}
📤 Exemplo de resposta
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
❌ Erro padrão
{
  "path": "/api/v1/schedulings/1",
  "method": "GET",
  "status": 404,
  "statusText": "Não encontrado",
  "message": "Agendamento não encontrado. ID = 1",
  "errors": null
}
❌ Erros de validação
{
  "message": "Um ou mais campos são inválidos",
  "errors": {
    "receiverEmail": "Informe um e-mail válido"
  }
}

📚 Swagger
http://localhost:8080/swagger-ui.html

▶️ Como executar o projeto
- git clone https://github.com/acsanfrancisco/meeting-scheduler-api
- mvn clean install
- mvn spring-boot:run

👨‍💻 Autor
Desenvolvido por João Francisco
