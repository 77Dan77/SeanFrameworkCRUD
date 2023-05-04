package com.example.seamcrud;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@Name("userBean")
@Scope(ScopeType.PAGE)
public class UserBean {
//    @In
    private UserService userService;

    private User user = new User();
    private List<User> users;
    private List<User> testUsers =
            new ArrayList<>(Arrays.asList(new User(1L, "Dan", "Zh", "87074965643", "dan01.01kz@gmail.com"),
                                          new User(2L, "Ali", "Iz", "88005553535", "al01kz@gmail.com")));
    private static final Logger LOGGER = Logger.getLogger(UserBean.class.getName());


    public List<User> getTestUsers() {
        return testUsers;
    }

    public void loadUsers() {
        users = userService.getAllUsers();
    }

    public void saveUser() {
        testUsers.add(user);
        LOGGER.log(Level.INFO, user.toString());
        LOGGER.log(Level.INFO, String.valueOf(testUsers.size()));
        LOGGER.log(Level.INFO, testUsers.get(testUsers.size()-1).toString());
//        userService.addUser(user);
        user = new User();
//        loadUsers();
    }

    public void updateUser(User updatedUser) {
        for (int i = 0; i < testUsers.size(); i++) {
            if (Objects.equals(testUsers.get(i).getId(), updatedUser.getId())) {
                testUsers.set(i, updatedUser);
                LOGGER.log(Level.INFO, updatedUser.toString() + " ---------------- ----");
                LOGGER.log(Level.INFO, testUsers.get(i).toString() + "-----------------------------");
                break;
            }
        }
//        userService.updateUser(user);
//        loadUsers();
    }

    public void deleteUser(Long id) {
//        Iterator<User> iterator = testUsers.iterator();
//        while (iterator.hasNext()) {
//            User u = iterator.next();
//            if (Objects.equals(u.getId(), id)) {
//                iterator.remove();
//            }
//        }

//        userService.deleteUser(id);
//        loadUsers();
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
