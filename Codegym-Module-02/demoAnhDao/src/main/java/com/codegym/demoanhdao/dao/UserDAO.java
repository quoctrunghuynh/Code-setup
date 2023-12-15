package com.codegym.demoanhdao.dao;

import com.codegym.demoanhdao.connection.JdbcConnection;
import com.codegym.demoanhdao.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class UserDAO {
    private List<User> users = null;

    public List<User> getAll() {
        users = new LinkedList<>();

        try {
            Connection connection = JdbcConnection.getConnection();
            String query = "SELECT u.id, u.username, " +
                    "u.password, u.email, u.phone " +
                    "FROM users u ;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                User user = new User();
                user.setId((int) resultSet.getLong("id"));
                user.setUserName(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setEmail(resultSet.getString("email"));
                user.setPhone(resultSet.getString("phone"));
                users.add(user);
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return users;
    }
}
