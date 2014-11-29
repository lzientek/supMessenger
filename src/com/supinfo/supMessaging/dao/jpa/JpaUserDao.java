package com.supinfo.supMessaging.dao.jpa;

import com.supinfo.supMessaging.dao.UserDao;

import javax.persistence.EntityManagerFactory;

/**
 * Created on the 28/11/2014.
 */
public class JpaUserDao implements UserDao {
    private EntityManagerFactory emf;

    public JpaUserDao(EntityManagerFactory entityManagerFactory) {
        emf = entityManagerFactory;
    }
}
