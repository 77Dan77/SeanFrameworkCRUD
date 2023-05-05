package com.example.seamcrud;

import javax.ejb.Local;
import java.util.List;

@Local
public interface UserServiceLocal {
    User createUser(User user);
    User updateUser(User user);
    void deleteUser(Long id);
    User findUserById(Long id);
    List<User> findAllUsers();
}
