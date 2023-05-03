package com.example.seamcrud;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;

import java.util.List;

@Name("userService")
public class UserService {
//    @In
    private UserDAO userDAO;

    public List<User> getAllUsers() {
        return userDAO.findAll();
    }

    public void addUser(User user) {
        userDAO.save(user);
    }

    public User updateUser(User user) {
        return userDAO.update(user);
    }

    public void deleteUser(Long id) {
        userDAO.delete(id);
    }
}
