package com.supinfo.supMessaging.dao.jpa;

import com.supinfo.supMessaging.dao.MessageDao;
import com.supinfo.supMessaging.entities.Message;
import com.supinfo.supMessaging.entities.User;
import com.supinfo.supMessaging.helpers.PersistHelper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created on the 28/11/2014.
 */
public class JpaMessageDao implements MessageDao {
    private EntityManagerFactory emf;

    public JpaMessageDao(EntityManagerFactory entityManagerFactory) {
        emf = entityManagerFactory;
    }

    @Override
    public void sendMessage(Message message) {
        if (message.getSendDate() == null) {
            message.setSendDate(new Date());
        }
        PersistHelper.persist(emf, message);
    }

    @Override
    public Message getMessageById(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em
                    .createQuery("SELECT m FROM  Message m LEFT JOIN FETCH m.recipient,m.transmitter WHERE m.id = :id");
            query.setParameter("id", id);
            return (Message) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Message> getMessagesByUsers(User actualUser, User contact) {
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createQuery("SELECT m FROM Message m " +
                    "JOIN m.transmitter " +
                    "JOIN m.recipient " +
                    "WHERE m.transmitter = :u1 AND m.recipient = :u2 " +
                    "OR m.transmitter = :u2 AND m.recipient = :u1 " +
                    "ORDER BY m.sendDate ");
            query.setParameter("u1", actualUser);
            query.setParameter("u2", contact);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public List<Message> getAdminMessage() {
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createQuery("SELECT m FROM Message m " +
                    "WHERE m.transmitter = null AND m.recipient = null ");

            return query.getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public void removeMessage(Message message) {
        PersistHelper.remove(emf, message);
    }

    @Override
    public void updateMessage(Message message) {
        PersistHelper.update(emf, message);
    }

    @Override
    public Long getNumberOfMessage() {

        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createQuery("SELECT COUNT(*) FROM Message");
            return (Long) query.getSingleResult();
        } finally {
            em.close();
        }

    }

    @Override
    public List<Message> getMessageAccueil(User actualUser) {
        List<Message> resultlist = new ArrayList<Message>();
        for (int i = 0; i < actualUser.getContactsBinding().size(); i++) {
            Message msg = getMessageByUsers(actualUser, actualUser.getContactsBinding().get(i).getContact());
            if (msg != null) {
                resultlist.add(msg);
            }
        }
        return resultlist;
    }

    private Message getMessageByUsers(User actualUser, User contact) {
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createQuery("SELECT m FROM Message m " +
                    "JOIN m.transmitter " +
                    "JOIN m.recipient " +
                    "WHERE m.transmitter = :u1 AND m.recipient = :u2 " +
                    "OR m.transmitter = :u2 AND m.recipient = :u1 " +
                    "ORDER BY m.sendDate desc");
            query.setParameter("u1", actualUser);
            query.setParameter("u2", contact);
            query.setMaxResults(1);
            return (Message) query.getResultList().get(0);
        } catch (Exception ex) {
            return null;
        } finally {
            em.close();
        }
    }

    public List<Object[]> getStatInfo() {

        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createQuery("SELECT m.sendDate,count(m) FROM Message m " +
                    "GROUP BY  DAY(m.sendDate),MONTH(m.sendDate),YEAR(m.sendDate) ");
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        } finally {
            em.close();
        }

    }
}
