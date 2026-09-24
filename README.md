# Student Management System

A Java-based Student Management System developed using Object-Oriented Programming, JDBC, and MySQL. The application provides student CRUD operations, role-based login, input validation, course search, and department management.

## Features

- Admin and User login
- Role-based access control
- Add student
- View all students
- Update student
- Delete student
- Search students by course
- Department management
- Student-Department JOIN using SQL
- Foreign Key relationship
- Input validation
- PreparedStatement for SQL queries
- Exception handling
- MySQL database integration
- JDBC connectivity
- Menu-driven console interface

## Technologies Used

- Java
- Object-Oriented Programming (OOP)
- JDBC
- MySQL
- MySQL Connector/J
- Visual Studio Code
- Git & GitHub

## Project Structure

```text
StudentManagementSystem
│
├── .vscode
│   └── settings.json
│
├── lib
│   └── mysql-connector-j-26.7.0.jar
│
├── screenshots
│   ├── login.png
│   ├── admin-menu.png
│   ├── students-list.png
│   └── students-department.png
│
├── src
│   ├── dao
│   │   ├── LoginDAO.java
│   │   └── StudentDAO.java
│   │
│   ├── model
│   │   ├── Department.java
│   │   └── Student.java
│   │
│   ├── util
│   │   └── DatabaseConnection.java
│   │
│   ├── Main.java
│   └── TestConnection.java
│
├── .gitignore
└── README.md