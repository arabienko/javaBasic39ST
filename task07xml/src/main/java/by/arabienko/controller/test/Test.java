package by.arabienko.controller.test;

import by.arabienko.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/db_school_online", "admin", "root");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<User> list = new ArrayList<>();
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(
                    "SELECT id, login, password, role  FROM users where role = 2");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        while (true) {
            try {
                if (!resultSet.next()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            //int id = resultSet.getInt(1);
            String name = null;
            try {
                Integer id = resultSet.getInt(1);
                String login = resultSet.getString(2);
                String pw = resultSet.getString("password");
                Integer role = resultSet.getInt("role");
                list.add(new User(id, login, pw, role));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        for (User user : list) {
            System.out.println(user);
        }
        try {
            statement.close();

            resultSet.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
