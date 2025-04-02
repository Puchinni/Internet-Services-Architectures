# Internet Services Architectures
 
This project consists of two microservices, Teacher Service and Class Service, built with Spring Boot. These services communicate through an API Gateway. The system models a school environment where teachers are associated with multiple subjects, and classes are managed accordingly.

# Technologies Used
Spring Boot (REST API)

Spring Cloud Gateway (API Gateway for request routing)

Spring Data JPA (Database interactions)

Hibernate (ORM for database management)

MySQL (Relational database)

Docker 

# Architecture
The system consists of:

**Teacher Service**

Manages teacher entities.
Each teacher can have multiple subjects.
Exposes RESTful endpoints for teacher-related operations.

**Class Service**

Manages class entities.
Links classes to teachers based on subjects.
Provides endpoints to retrieve class details and assigned teachers.

**API Gateway**

Routes requests between services.
Manages security, load balancing, and request handling.

# How It Works

A client sends a request to the API Gateway.
The gateway forwards the request to either the Teacher Service or Class Service based on the endpoint.
Each service processes the request using its Controller-Service-Repository architecture.
The services interact with the database to store and retrieve information.
The response is returned through the API Gateway.
