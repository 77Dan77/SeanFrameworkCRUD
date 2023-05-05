package com.example.seamcrud;

import javax.ejb.Local;
import java.util.List;
import java.util.logging.Logger;

@Local
public interface UserDAOLocal {
     User findById(Long id);
     List<User> findAll();
     void save(User user);
     User update(User user);
     void delete(Long id);
}
