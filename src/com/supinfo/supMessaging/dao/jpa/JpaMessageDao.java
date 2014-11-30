package com.supinfo.supMessaging.dao.jpa;

import com.supinfo.supMessaging.dao.MessageDao;
import com.supinfo.supMessaging.entities.Message;
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
public class JpaMessageDao implements MessageDao {
    private EntityManagerFactory emf;

    public JpaMessageDao(EntityManagerFactory entityManagerFactory) {
        emf = entityManagerFactory;
    }

    @Override
    public void sendMessage(Message message) {
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
            //todo : faire des tests de performance
            Query query = em.createQuery("SELECT m FROM Message m " +
                    "LEFT JOIN FETCH m.transmitter,m.recipient " +
                    "WHERE m.transmitter = :u1 AND m.recipient = :u2 " +
                    "OR m.transmitter = :u2 AND m.recipient = :u1");
            query.setParameter("u1", actualUser);
            query.setParameter("u2", contact);
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
	public int getNumberOfMessage() {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createQuery("SELECT COUNT(*) FROM Message");
            return (int) query.getSingleResult();
        } finally {
            em.close();
        }
		
	}
}
