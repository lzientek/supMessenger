package com.supinfo.supMessaging.dao;

import com.supinfo.supMessaging.entities.Message;
import com.supinfo.supMessaging.entities.User;

import java.util.List;

/**
 * Created on the 28/11/2014.
 */
public interface MessageDao {
    void sendMessage(Message message);

    Message getMessageById(Long id);

    List<Message> getMessagesByUsers(User actualUser, User contact);

    List<Message> getAdminMessage();

    void removeMessage(Message message);

    void updateMessage(Message message);

    Long getNumberOfMessage();
}
