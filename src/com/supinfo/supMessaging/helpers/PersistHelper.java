package com.supinfo.supMessaging.helpers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * Created on the 29/11/2014.
 */
public class PersistHelper {

    /**
     * Persist a data
     *
     * @param emf entity manager factory
     * @param obj object to persist
     * @return true if success
     */
    public static boolean persist(EntityManagerFactory emf, Object obj) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(obj);
            em.getTransaction().commit();
        } finally {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
                em.close();
                return false;
            }
            em.close();
        }
        return true;
    }

    /**
     * remove an object from the data base
     *
     * @param emf entity manager factory
     * @param obj object to remove
     * @return true if success
     */
    public static boolean remove(EntityManagerFactory emf, Object obj) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.remove(em.merge(obj));
            em.getTransaction().commit();
        } finally {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
                em.close();
                return false;
            }
            em.close();
            return true;
        }
    }

    /**
     * update an object from the data base
     *
     * @param emf entity manager factory
     * @param obj object to update
     * @return true if success
     */
    public static boolean update(EntityManagerFactory emf, Object obj) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.merge(obj);
            em.getTransaction().commit();

        } finally {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
                em.close();
                return false;
            }
            em.close();
            return true;
        }
    }
}
