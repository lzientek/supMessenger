package com.supinfo.supMessaging.dao.jpa;

import com.supinfo.supMessaging.dao.MessageDao;

import javax.persistence.EntityManagerFactory;

/**
 * Created on the 28/11/2014.
 */
public class JpaMessageDao implements MessageDao {
    private EntityManagerFactory emf;

    public JpaMessageDao(EntityManagerFactory entityManagerFactory) {
        emf = entityManagerFactory;
    }
}
