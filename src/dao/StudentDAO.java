package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Student;
import util.DatabaseConnection;

public class StudentDAO {

    // =========================
    // Display all students
    // =========================
    public void getAllStudents() {

        String sql = "SELECT * FROM students";

        try {
            Connection connection = DatabaseConnection.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            ResultSet resultSet =
                    statement.executeQuery();

            boolean found = false;

            while (resultSet.next()) {

                found = true;

                Student student = new Student(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("course"),
                        resultSet.getDouble("marks")
                );

                System.out.println(student);
            }

            if (!found) {
                System.out.println("No students found!");
            }

            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // =========================
    // Add a new student
    // =========================
    public void addStudent(
            String name,
            String email,
            String course,
            double marks) {

        if (name == null || name.trim().isEmpty()) {
            System.out.println("Error: Name cannot be empty!");
            return;
        }

        if (email == null || email.trim().isEmpty()) {
            System.out.println("Error: Email cannot be empty!");
            return;
        }

        if (course == null || course.trim().isEmpty()) {
            System.out.println("Error: Course cannot be empty!");
            return;
        }

        if (marks < 0 || marks > 100) {
            System.out.println(
                    "Error: Marks must be between 0 and 100!"
            );
            return;
        }

        int deptId = getDepartmentId(course);

        if (deptId == -1) {
            System.out.println(
                    "Error: Invalid course! Use CSE-AIML, CSE or BCA."
            );
            return;
        }

        Student student = new Student(
                name,
                email,
                course,
                marks
        );

        String sql =
                "INSERT INTO students " +
                "(name, email, course, marks, dept_id) " +
                "VALUES (?, ?, ?, ?, ?)";

        try {
            Connection connection =
                    DatabaseConnection.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            statement.setString(1, student.getName());
            statement.setString(2, student.getEmail());
            statement.setString(3, student.getCourse());
            statement.setDouble(4, student.getMarks());
            statement.setInt(5, deptId);

            statement.executeUpdate();

            System.out.println(
                    "Student added successfully!"
            );

            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // =========================
    // Update student
    // =========================
    public void updateStudent(
            int id,
            String name,
            String email,
            String course,
            double marks) {

        if (id <= 0) {
            System.out.println(
                    "Error: Invalid student ID!"
            );
            return;
        }

        if (name == null || name.trim().isEmpty()) {
            System.out.println(
                    "Error: Name cannot be empty!"
            );
            return;
        }

        if (email == null || email.trim().isEmpty()) {
            System.out.println(
                    "Error: Email cannot be empty!"
            );
            return;
        }

        if (course == null || course.trim().isEmpty()) {
            System.out.println(
                    "Error: Course cannot be empty!"
            );
            return;
        }

        if (marks < 0 || marks > 100) {
            System.out.println(
                    "Error: Marks must be between 0 and 100!"
            );
            return;
        }

        int deptId = getDepartmentId(course);

        if (deptId == -1) {
            System.out.println(
                    "Error: Invalid course! Use CSE-AIML, CSE or BCA."
            );
            return;
        }

        Student student = new Student(
                id,
                name,
                email,
                course,
                marks
        );

        String sql =
                "UPDATE students " +
                "SET name = ?, email = ?, course = ?, " +
                "marks = ?, dept_id = ? " +
                "WHERE id = ?";

        try {
            Connection connection =
                    DatabaseConnection.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            statement.setString(1, student.getName());
            statement.setString(2, student.getEmail());
            statement.setString(3, student.getCourse());
            statement.setDouble(4, student.getMarks());
            statement.setInt(5, deptId);
            statement.setInt(6, student.getId());

            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println(
                        "Student updated successfully!"
                );
            } else {
                System.out.println(
                        "Student not found!"
                );
            }

            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // =========================
    // Delete student
    // =========================
    public void deleteStudent(int id) {

        if (id <= 0) {
            System.out.println(
                    "Error: Invalid student ID!"
            );
            return;
        }

        String sql =
                "DELETE FROM students WHERE id = ?";

        try {
            Connection connection =
                    DatabaseConnection.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            statement.setInt(1, id);

            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println(
                        "Student deleted successfully!"
                );
            } else {
                System.out.println(
                        "Student not found!"
                );
            }

            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // =========================
    // Search students by course
    // =========================
    public void searchByCourse(String course) {

        if (course == null || course.trim().isEmpty()) {
            System.out.println(
                    "Error: Course cannot be empty!"
            );
            return;
        }

        String sql =
                "SELECT * FROM students WHERE course = ?";

        try {
            Connection connection =
                    DatabaseConnection.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            statement.setString(1, course);

            ResultSet resultSet =
                    statement.executeQuery();

            boolean found = false;

            while (resultSet.next()) {

                found = true;

                Student student = new Student(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("course"),
                        resultSet.getDouble("marks")
                );

                System.out.println(student);
            }

            if (!found) {
                System.out.println(
                        "No students found for course: "
                                + course
                );
            }

            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // =========================
    // Display students with department
    // =========================
    public void getStudentsWithDepartment() {

        String sql =
                "SELECT s.id, s.name, s.email, " +
                "s.course, s.marks, d.dept_name " +
                "FROM students s " +
                "JOIN departments d " +
                "ON s.dept_id = d.dept_id";

        try {
            Connection connection =
                    DatabaseConnection.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            ResultSet resultSet =
                    statement.executeQuery();

            boolean found = false;

            while (resultSet.next()) {

                found = true;

                System.out.println(
                        resultSet.getInt("id") + " | " +
                        resultSet.getString("name") + " | " +
                        resultSet.getString("email") + " | " +
                        resultSet.getString("course") + " | " +
                        resultSet.getDouble("marks") + " | " +
                        resultSet.getString("dept_name")
                );
            }

            if (!found) {
                System.out.println(
                        "No students found!"
                );
            }

            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // =========================
    // Get Department ID
    // =========================
    private int getDepartmentId(String course) {

        if (course.equalsIgnoreCase("CSE-AIML")) {
            return 1;
        }

        if (course.equalsIgnoreCase("CSE")) {
            return 2;
        }

        if (course.equalsIgnoreCase("BCA")) {
            return 3;
        }

        return -1;
    }
}