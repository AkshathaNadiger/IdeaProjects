# Student Management System using Spring Boot and MySQL

This project is a simple CRUD application built with Spring Boot and MySQL. It provides RESTful APIs to manage student records.

## Project Structure

### 1. Model Layer
- **Student.java**: Represents the student entity.

### 2. Controller Layer
- **StudentController.java**: Handles web requests and delegates tasks to the service layer.

### 3. Service Layer
- **ServiceI.java**: Defines the service layer interface.
- **ServiceIMPL.java**: Implements the service layer interface.

### 4. Repository Layer
- **StudentRepository.java**: Extends `JpaRepository` and `CrudRepository` to provide CRUD operations on the student entity.

## Spring MVC Components

### Controller (StudentController)
- Handles the following endpoints:

  #### Add a new student
  - **POST /save**
    - **Postman Command**: 
      ```curl
      POST "http://localhost:9077/save" -H "Content-Type: application/json" -d '{"name": "John Doe", "age": 20, "email": "johndoe@example.com"}'
      ```

  #### Add multiple students
  - **POST /saveAll**
    - **Postman Command**:
      ```curl
      POST "http://localhost:9077/saveAll" -H "Content-Type: application/json" -d '[{"name": "John Doe", "age": 20, "email": "johndoe@example.com"}, {"name": "Jane Doe", "age": 22, "email": "janedoe@example.com"}]'
      ```

  #### Retrieve a student by ID
  - **GET /getbyid/{id}**
    - **Postman Command**:
      ```curl
      GET "http://localhost:9077/getbyid/1"
      ```

  #### Retrieve all students
  - **GET /getall**
    - **Postman Command**:
      ```curl
      GET "http://localhost:9077/getall"
      ```

  #### Retrieve students by a list of IDs
  - **GET /listByIds/{ids}**
    - **Postman Command**:
      ```curl
      GET "http://localhost:9077/listByIds/1,2,3"
      ```

  #### Update a student's information
  - **PUT /update/{id}**
    - **Postman Command**:
      ```curl
      PUT "http://localhost:9077/update/1" -H "Content-Type: application/json" -d '{"name": "John Doe Updated", "age": 21, "email": "johnupdated@example.com"}'
      ```

  #### Delete a student by ID
  - **DELETE /deletebyid/{id}**
    - **Postman Command**:
      ```curl
      DELETE "http://localhost:9077/deletebyid/1"
      ```

  #### Delete all students
  - **DELETE /deleteall**
    - **Postman Command**:
      ```curl
      DELETE "http://localhost:9077/deleteall"
      ```

  #### Delete multiple students by a list of IDs
  - **DELETE /bulkdelete/{ids}**
    - **Postman Command**:
      ```curl
      DELETE "http://localhost:9077/bulkdelete" -H "Content-Type: application/json" -d '[1, 2, 3]'
      ```

  #### Get the total count of students
  - **GET /count**
    - **Postman Command**:
      ```curl
      GET "http://localhost:9077/count"
      ```

  #### Check if a student exists by ID
  - **GET /exists/{id}**
    - **Postman Command**:
      ```curl
      GET "http://localhost:9077/exists/1"
      ```

### Service (ServiceIMPL)
- Implements `ServiceI` providing methods to interact with the repository layer.

### Repository (StudentRepository)
- Extends `JpaRepository` and `CrudRepository` to perform database operations on the `Student` entity.

## Configuration

### Database Configuration
- **application.properties**:
  - `spring.datasource.url`: JDBC URL for the MySQL database.
  - `spring.datasource.username`: Username for the MySQL database.
  - `spring.datasource.password`: Password for the MySQL database.
  - `spring.jpa.properties.hibernate.dialect`: Hibernate dialect for MySQL.
  - `spring.jpa.show-sql`: Show SQL queries in the console.
  - `spring.jpa.hibernate.ddl-auto`: DDL mode for the database (e.g., `update`).

## Getting Started

### Prerequisites
- Java Development Kit (JDK) 8 or newer
- Maven
- MySQL Server

### Steps to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/your-repository.git
   cd your-repository
