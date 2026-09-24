# Student Management System

A console-based Student Management System developed using **Java, OOP, JDBC, and MySQL**. The project provides student CRUD operations, authentication, role-based access, course search, validation, and department integration.

## Project Overview

The Student Management System is designed to manage student records efficiently through a Java-based console application connected to a MySQL database using JDBC.

The project demonstrates practical implementation of:

- Object-Oriented Programming
- Java Exception Handling
- JDBC Database Connectivity
- SQL CRUD Operations
- Primary Key and Foreign Key relationships
- JOIN operations
- Input Validation
- User Authentication
- Role-Based Access Control

## Features

- User Login Authentication
- Admin and User roles
- Add Student
- View All Students
- Update Student
- Delete Student
- Search Students by Course
- View Students with Department
- Input Validation
- Marks validation from 0 to 100
- Email uniqueness through database constraint
- Department integration using Foreign Key
- JDBC connectivity with MySQL
- PreparedStatement for SQL queries
- Console-based user interface

## Technologies Used

| Technology | Purpose |
|---|---|
| Java | Application development |
| OOP | Object-oriented design |
| JDBC | Java-MySQL connectivity |
| MySQL | Database management |
| SQL | Database operations |
| VS Code | Development environment |
| Git | Version control |
| GitHub | Project hosting |

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
├── README.md
└── .gitignore