package com.supinfo.supMessaging.dao.jpa;

import com.supinfo.supMessaging.dao.ContactsDao;
import com.supinfo.supMessaging.entities.Contacts;
import com.supinfo.supMessaging.entities.User;
import com.supinfo.supMessaging.helpers.PersistHelper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

/**
 * Created on the 28/11/2014.
 */
public class JpaContactsDao implements ContactsDao {

    private EntityManagerFactory emf;

    public JpaContactsDao(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public void addContacts(Contacts contacts) {
        PersistHelper.persist(emf, contacts);
    }

    @Override
    public void addContacts(User actualUser, User contact) {
        Contacts cts1 = new Contacts(actualUser, contact);
        Contacts cts2 = new Contacts(contact, actualUser);
        addContacts(cts1);
        addContacts(cts2);
    }

    @Override
    public List<Contacts> getAllContacts() {
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createQuery("SELECT c FROM Contacts AS c");
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public List<Contacts> getAllContactsFromUser(User user) {
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em
                    .createQuery("SELECT c FROM Contacts c LEFT JOIN FETCH c.contact WHERE c.id = :id");
            query.setParameter("id", user.getId());
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public void removeContacts(Contacts contacts) {
        PersistHelper.remove(emf, contacts);
    }
}
