import java.util.Scanner;

import dao.StudentDAO;
import dao.LoginDAO;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        LoginDAO loginDAO = new LoginDAO();

        // =========================
        // LOGIN
        // =========================

        System.out.println();
        System.out.println("========================================");
        System.out.println("        STUDENT MANAGEMENT SYSTEM");
        System.out.println("                 LOGIN");
        System.out.println("========================================");

        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        String role = loginDAO.login(username, password);

        if (role == null) {
            System.out.println();
            System.out.println("Invalid username or password!");
            scanner.close();
            return;
        }

        System.out.println();
        System.out.println("Login successful!");
        System.out.println("Role: " + role);

        StudentDAO studentDAO = new StudentDAO();

        int choice;

        // =========================
        // MAIN MENU
        // =========================

        do {

            System.out.println();
            System.out.println("========================================");
            System.out.println("       STUDENT MANAGEMENT SYSTEM");
            System.out.println("========================================");

            // =========================
            // ADMIN MENU
            // =========================

            if (role.equals("ADMIN")) {

                System.out.println("1. Add Student");
                System.out.println("2. View All Students");
                System.out.println("3. Update Student");
                System.out.println("4. Delete Student");
                System.out.println("5. Search by Course");
                System.out.println("6. View Students with Department");
                System.out.println("7. Logout");

            }

            // =========================
            // USER MENU
            // =========================

            else {

                System.out.println("1. View All Students");
                System.out.println("2. Search by Course");
                System.out.println("3. View Students with Department");
                System.out.println("4. Logout");

            }

            System.out.println("========================================");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();


            // =====================================================
            // ADMIN OPERATIONS
            // =====================================================

            if (role.equals("ADMIN")) {

                switch (choice) {

                    // =========================
                    // ADD STUDENT
                    // =========================

                    case 1:

                        System.out.println();
                        System.out.println("--- Add Student ---");

                        System.out.print("Enter name: ");
                        String name = scanner.nextLine();

                        System.out.print("Enter email: ");
                        String email = scanner.nextLine();

                        System.out.print("Enter course: ");
                        String course = scanner.nextLine();

                        System.out.print("Enter marks: ");
                        double marks = scanner.nextDouble();
                        scanner.nextLine();

                        studentDAO.addStudent(
                                name,
                                email,
                                course,
                                marks
                        );

                        break;


                    // =========================
                    // VIEW ALL STUDENTS
                    // =========================

                    case 2:

                        System.out.println();
                        System.out.println("--- All Students ---");

                        studentDAO.getAllStudents();

                        break;


                    // =========================
                    // UPDATE STUDENT
                    // =========================

                    case 3:

                        System.out.println();
                        System.out.println("--- Update Student ---");

                        System.out.print("Enter student ID: ");
                        int updateId = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Enter new name: ");
                        String newName = scanner.nextLine();

                        System.out.print("Enter new email: ");
                        String newEmail = scanner.nextLine();

                        System.out.print("Enter new course: ");
                        String newCourse = scanner.nextLine();

                        System.out.print("Enter new marks: ");
                        double newMarks = scanner.nextDouble();
                        scanner.nextLine();

                        studentDAO.updateStudent(
                                updateId,
                                newName,
                                newEmail,
                                newCourse,
                                newMarks
                        );

                        break;


                    // =========================
                    // DELETE STUDENT
                    // =========================

                    case 4:

                        System.out.println();
                        System.out.println("--- Delete Student ---");

                        System.out.print("Enter student ID: ");
                        int deleteId = scanner.nextInt();
                        scanner.nextLine();

                        studentDAO.deleteStudent(deleteId);

                        break;


                    // =========================
                    // SEARCH BY COURSE
                    // =========================

                    case 5:

                        System.out.println();
                        System.out.println("--- Search by Course ---");

                        System.out.print("Enter course: ");
                        String searchCourse = scanner.nextLine();

                        studentDAO.searchByCourse(searchCourse);

                        break;


                    // =========================
                    // STUDENTS WITH DEPARTMENT
                    // =========================

                    case 6:

                        System.out.println();
                        System.out.println(
                                "--- Students with Department ---"
                        );

                        studentDAO.getStudentsWithDepartment();

                        break;


                    // =========================
                    // LOGOUT
                    // =========================

                    case 7:

                        System.out.println();
                        System.out.println(
                                "Logged out successfully!"
                        );

                        break;


                    default:

                        System.out.println(
                                "Invalid choice! Please try again."
                        );
                }
            }


            // =====================================================
            // USER OPERATIONS
            // =====================================================

            else {

                switch (choice) {

                    // =========================
                    // VIEW ALL STUDENTS
                    // =========================

                    case 1:

                        System.out.println();
                        System.out.println("--- All Students ---");

                        studentDAO.getAllStudents();

                        break;


                    // =========================
                    // SEARCH BY COURSE
                    // =========================

                    case 2:

                        System.out.println();
                        System.out.println("--- Search by Course ---");

                        System.out.print("Enter course: ");
                        String searchCourse = scanner.nextLine();

                        studentDAO.searchByCourse(searchCourse);

                        break;


                    // =========================
                    // STUDENTS WITH DEPARTMENT
                    // =========================

                    case 3:

                        System.out.println();
                        System.out.println(
                                "--- Students with Department ---"
                        );

                        studentDAO.getStudentsWithDepartment();

                        break;


                    // =========================
                    // LOGOUT
                    // =========================

                    case 4:

                        System.out.println();
                        System.out.println(
                                "Logged out successfully!"
                        );

                        break;


                    default:

                        System.out.println(
                                "Invalid choice! Please try again."
                        );
                }
            }

        } while (
                (role.equals("ADMIN") && choice != 7)
                ||
                (role.equals("USER") && choice != 4)
        );

        scanner.close();
    }
}