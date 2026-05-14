# Calories Counter API

Calories Counter API is a REST API built with **Spring Boot** for managing calorie tracking data.

The project is integrated with **Oracle XE Database** and follows a layered backend architecture based on:

```text
Model → Repository → Service → Controller → DTO
```

It also includes JWT-based authentication, password hashing, and role-based access control with two access levels.

## Tech Stack

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- Oracle XE Database
- Flyway
- JWT Authentication
- Auth0 Java JWT
- Maven

## Project Goals

The main goal of this project is to practice building a complete backend REST API using Java and Spring Boot.

The project focuses on:

- Creating a structured REST API
- Connecting a Spring Boot application to Oracle XE
- Using JPA and Hibernate for persistence
- Applying a layered architecture
- Working with DTOs to control request and response data
- Implementing JWT authentication
- Protecting routes based on user access levels
- Hashing passwords securely
- Managing database migrations with Flyway

## Architecture

The project follows a common Spring Boot layered architecture:

```text
src/main/java
└── ...
    ├── controller
    ├── dto
    ├── model
    ├── repository
    ├── service
    └── security
```

### Model

Contains the domain entities mapped to the database tables.

### Repository

Responsible for database communication using Spring Data JPA.

### Service

Contains the business logic of the application.

### Controller

Exposes the REST endpoints consumed by clients.

### DTO

Used to transfer data between the API and the client without exposing the internal entity structure directly.

## Authentication and Authorization

The API uses **JWT authentication** to protect private routes.

Authentication includes:

- User registration
- User login
- JWT token generation
- JWT token validation
- Password hashing
- Protected endpoints
- Two access levels

The project uses **Auth0 Java JWT** for token generation and validation.

## Database

The project is integrated with **Oracle XE Database**.

Database migrations are managed with **Flyway**, making it easier to version and reproduce the database structure.

## Features

- User registration
- User authentication
- JWT-based login flow
- Password hashing
- Role-based access control
- Calorie tracking resources
- Oracle XE database integration
- Database migrations with Flyway
- RESTful endpoint structure
- DTO-based request and response flow

## Requirements

Before running the project, make sure you have installed:

- Java 17 or higher
- Maven
- Oracle XE Database
- Git

## How to Run

Clone the repository:

```bash
git clone https://github.com/guidonunes/caloriescounter.git
```

Enter the project folder:

```bash
cd caloriescounter
```

Configure your database connection in your local environment or application configuration.

Example configuration:

```properties
spring.datasource.url=jdbc:oracle:thin:@localhost:1521/XEPDB1
spring.datasource.username=YOUR_DATABASE_USER
spring.datasource.password=YOUR_DATABASE_PASSWORD
spring.datasource.driver-class-name=oracle.jdbc.OracleDriver
```

Run the application:

```bash
mvn spring-boot:run
```

The API should start locally on:

```text
http://localhost:8080
```

## Security Notes

Sensitive information such as database credentials, JWT secrets, and passwords should not be committed to the repository.

Use environment variables or local configuration files ignored by Git.

Example:

```properties
spring.datasource.username=${DB_USER}
spring.datasource.password=${DB_PASSWORD}
api.security.token.secret=${JWT_SECRET}
```

## Learning Focus

This project was built to strengthen backend development skills with Java and Spring Boot.

The main learning points are:

- REST API development
- Spring Boot project structure
- Oracle database integration
- JPA and Hibernate persistence
- DTO usage
- Authentication and authorization
- JWT security flow
- Password hashing
- Clean separation between layers
- Database migration with Flyway

## Author

Developed by Guilherme Nunes.
