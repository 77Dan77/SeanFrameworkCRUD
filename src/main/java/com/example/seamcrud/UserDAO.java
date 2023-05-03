package com.example.seamcrud;


import org.jboss.seam.annotations.Name;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
@Name("userService")
public class UserDAO {
    @PersistenceContext(unitName = "SeamPrimeFacesGlassfishPU")
    private EntityManager entityManager;

    public User findById(Long id) {
        return entityManager.find(User.class, id);
    }

    public List<User> findAll() {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    public void save(User user) {
        entityManager.persist(user);
    }

    public User update(User user) {
        return entityManager.merge(user);
    }

    public void delete(Long id) {
        User user = findById(id);
        if (user != null) {
            entityManager.remove(user);
        }
    }
}
