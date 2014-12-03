package com.supinfo.supMessaging.dao;

import com.supinfo.supMessaging.entities.User;

import java.util.List;

/**
 * Created on the 28/11/2014.
 */
public interface UserDao {
    void addUser(User user);

    User getUserById(Long id);

    User findUserByUsername(String username);

    List<User> searchByUsername(String search);

    User getUserByIdWithContacts(Long id);

    List<User> getAllUsers();

    void removeUser(User user);

    void updateUser(User user);

    Long getNumberOfUser();
    
}
