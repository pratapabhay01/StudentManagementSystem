import dao.StudentDAO;

public class TestConnection {

    public static void main(String[] args) {

        StudentDAO studentDAO = new StudentDAO();

        studentDAO.searchByCourse("CSE-AIML");
    }
}