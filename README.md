# Account Management System

## Overview

This project is an Account Management System built with Spring Boot, designed to handle user accounts, transactions, and beneficiaries. It provides REST APIs to perform operations such as retrieving account balances, managing transactions, and loading data from CSV files. Swagger is integrated for easy API documentation and testing.
## Technologies Used

- **Spring Boot:** A Java-based framework used for building standalone and production-ready Spring applications.
- **PostgreSQL:** An open-source relational database system.
- **Flyway:** Database Migration
- **Docker:** A platform for developing, shipping, and running applications in containers.
    - **Docker Compose:** A tool for defining and running multi-container Docker applications.
    - **Dockerfile:** A script containing instructions on how to build a Docker image.
- **Lombok:**  Simplifies Java code by removing boilerplate code.
- **Swagger/OpenAPi:** API documentation.
- **Hibernate:** ORM for managing database interactions

## Prerequisites

Before you begin, ensure you have met the following requirements:

- Java 17+
- Gradle
- Docker and Docker Compose

## Installation

### Step 1: Clone the repository

```sh
git clone https://github.com/apokiou/AccountManagSystem.git
```

#

### Step 3: Build the application

Use Gradle to build the application:

```sh
./gradlew build
```



Just run the **startDocker.sh** script to build and run the Docker containers:

```sh
./startDocker.sh
```

## Development

### Swagger
You can access Swagger to test the endpoints
```sh
http://localhost:8080/swagger-ui/index.html
```
