package com.example.seamcrud;

import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;

import javax.ejb.*;
import javax.inject.Inject;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

//@Stateless
@Local(UserServiceLocal.class)
@Name("userService")
@AutoCreate
public class UserService implements UserServiceLocal{
    @In
    private UserDAOLocal userDAO;

    private static final Logger LOGGER = Logger.getLogger(UserBean.class.getName());

    @Override
    public User createUser(User user) {
        LOGGER.log(Level.WARNING, "----------------------------This is userService.createUser()----------------------");
        User user1 = new User(5L, "USER", "USER", "USER", "USER");
        userDAO.save(user1);
        return user;
    }
    @Override
    public User updateUser(User user) {
        return userDAO.update(user);
    }
    @Override
    public void deleteUser(Long id) {
        userDAO.delete(id);
    }
    @Override
    public User findUserById(Long id) {
        return userDAO.findById(id);
    }
    @Override
    public List<User> findAllUsers() {
        return userDAO.findAll();
    }

}
