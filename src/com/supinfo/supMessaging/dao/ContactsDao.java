package com.supinfo.supMessaging.dao;

import com.supinfo.supMessaging.entities.Contacts;
import com.supinfo.supMessaging.entities.User;

import java.util.List;


/**
 * Created on the 28/11/2014.
 */
public interface ContactsDao {
    void addContacts(Contacts contacts);

    void addContacts(User actualUser, User contacts);

    List<Contacts> getAllContacts();

    List<Contacts> getAllContactsFromUser(User user);

    void removeContacts(Contacts contacts);
}
