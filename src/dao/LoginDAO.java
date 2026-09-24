package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.DatabaseConnection;

public class LoginDAO {

    public String login(String username, String password) {

        String sql = "SELECT role FROM users WHERE username = ? AND password = ?";

        try {
            Connection connection = DatabaseConnection.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {

                String role = resultSet.getString("role");

                connection.close();

                return role;
            }

            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
