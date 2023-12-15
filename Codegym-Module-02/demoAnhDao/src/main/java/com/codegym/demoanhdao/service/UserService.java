package com.codegym.demoanhdao.service;
import com.codegym.demoanhdao.dao.UserDAO;
import com.codegym.demoanhdao.model.User;
import java.util.List;

public class UserService {
    private UserDAO userDAO = null;

    public UserService() {
        userDAO = new UserDAO();
    }

    public List<User> findAll() {
        return userDAO.getAll();
    }

}
