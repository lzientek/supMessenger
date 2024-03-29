package com.supinfo.supMessaging.dao.jpa;

import com.supinfo.supMessaging.dao.UserDao;
import com.supinfo.supMessaging.entities.User;
import com.supinfo.supMessaging.helpers.PersistHelper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

/**
 * Created on the 28/11/2014.
 */
public class JpaUserDao implements UserDao {
    private EntityManagerFactory emf;

    public JpaUserDao(EntityManagerFactory entityManagerFactory) {
        emf = entityManagerFactory;
    }

    @Override
    public void addUser(User user) {
        PersistHelper.persist(emf, user);
    }

    @Override
    public User getUserById(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em
                    .createQuery("SELECT u FROM  User u WHERE u.id = :id");
            query.setParameter("id", id);
            return (User) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public User getUserByIdWithContacts(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em
                    .createQuery("SELECT u FROM  User u LEFT JOIN FETCH u.contacts WHERE u.id = :id");
            query.setParameter("id", id);
            return (User) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public User findUserByUsername(String username) {
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em
                    .createQuery("SELECT u FROM  User u WHERE u.userName = :username");
            query.setParameter("username", username);
            return (User) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public List<User> searchByUsername(String search) {
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createQuery("SELECT u FROM User AS u WHERE u.userName LIKE :s");
            query.setParameter("s", "%" + search + "%");
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public List<User> getAllUsers() {
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createQuery("SELECT u FROM User AS u");
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public void removeUser(User user) {
        PersistHelper.remove(emf, user);
    }

    @Override
    public void updateUser(User user) {
        PersistHelper.update(emf, user);
    }

    @Override
    public Long getNumberOfUser() {

        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createQuery("SELECT COUNT(*) FROM User");
            return (Long) query.getSingleResult();
        } finally {
            em.close();
        }
    }

    public List<Object[]> getStatPerMonth() {

        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createQuery("SELECT u.inscriptionDate,count(u) FROM User u " +
                    "group by MONTH(u.inscriptionDate),YEAR(u.inscriptionDate) ");
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        } finally {
            em.close();
        }

    }
}
