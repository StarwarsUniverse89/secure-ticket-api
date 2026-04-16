# Secure Ticket API

A Spring Boot REST API with JWT authentication and role-based authorization for managing tickets.

- User registration and login
- JWT-based authentication
- Role-based authorization (USER, ADMIN)
- Protected ticket endpoints
- PostgreSQL persistence
- Password hashing with BCrypt

## Tech Stack
- Java 17
- Spring Boot
- Spring Data JPA
- H2 Database

## Endpoints
POST /auth/register
POST /auth/login

GET /tickets (authenticated)
POST /tickets (authenticated)
DELETE /tickets/{id} (ADMIN only)

### Get all tickets
GET /tickets

### Get ticket by ID
GET /tickets/{id}

### Create ticket
POST /tickets

### Update ticket
PUT /tickets/{id}

### Delete ticket
DELETE /tickets/{id}

## Example Request

```json
{
  "id": 1,
  "title": "Login issue",
  "status": "OPEN"
}
```  



### Run the container
docker run -p 8080:8080 \
-e SPRING_DATASOURCE_URL=jdbc:postgresql://host.docker.internal:5432/ticketdb \
-e SPRING_DATASOURCE_USERNAME="YOUR-USERNAME" \
ticket-api
