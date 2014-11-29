package com.supinfo.supMessaging.dao;

import com.supinfo.supMessaging.dao.jpa.JpaContactsDao;
import com.supinfo.supMessaging.dao.jpa.JpaMessageDao;
import com.supinfo.supMessaging.dao.jpa.JpaUserDao;
import com.supinfo.supMessaging.helpers.PersistenceManager;

/**
 * Created on the 28/11/2014.
 */
public class DaoFactory {
    private static JpaContactsDao contactService;
    private static JpaMessageDao messageService;
    private static JpaUserDao userService;

    public static ContactsDao getContactsDao() {
        if (contactService == null) {
            contactService = new JpaContactsDao(PersistenceManager.getEntityManagerFactory());
        }
        return contactService;
    }

    public static MessageDao getMessageDao() {
        if (messageService == null) {
            messageService = new JpaMessageDao(PersistenceManager.getEntityManagerFactory());
        }
        return messageService;
    }

    public static UserDao getUserDao() {
        if (userService == null) {
            userService = new JpaUserDao(PersistenceManager.getEntityManagerFactory());
        }
        return userService;
    }
}
