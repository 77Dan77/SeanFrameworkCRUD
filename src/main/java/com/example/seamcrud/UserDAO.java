package com.example.seamcrud;


import org.hibernate.Session;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.persistence.ManagedHibernateSession;

import javax.annotation.PostConstruct;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Local(UserDAOLocal.class)
@Name("userDAO")
public class UserDAO implements UserDAOLocal {
//    @PersistenceContext(unitName = "SeamPrimeFacesGlassfishPU")
    @In
    private ManagedHibernateSession entityManager;

    private static final Logger LOGGER = Logger.getLogger(UserDAO.class.getName());

    @PostConstruct
    public void init() {
        if (entityManager == null) {
            LOGGER.severe("################################################EntityManager is null");
        } else {
            LOGGER.info("#######################################################EntityManager is properly injected");
        }
    }

    @Override
    public User findById(Long id) {
//        return entityManager.find(User.class, id);
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
//        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Override
    public void save(User user) {
        LOGGER.log(Level.WARNING, "-------------------------------------This is userDAO.save()-------------------------------------");
        User user1 = new User(5L, "USERDAO", "USERDAO", "USERDAO", "USERDAO");
     //   entityManager.persist(user1);
        Session session = null;
        try {
            session = entityManager.getSession();
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.saveOrUpdate(user);
    }

    @Override
    public User update(User user) {
        return null;
        //return entityManager.merge(user);
    }

    @Override
    public void delete(Long id) {
//        User user = findById(id);
//        if (user != null) {
//            entityManager.remove(user);
//        }
    }
}