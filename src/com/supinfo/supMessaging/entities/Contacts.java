package com.supinfo.supMessaging.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created on the 27/11/2014.
 */
@Entity
@Table(name = "Contacts")
public class Contacts implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_fk")
    private User user;

    @ManyToOne
    @JoinColumn(name = "contact_fk")
    private User contact;

    public Contacts() {
    }

    public Contacts(User user, User contact) {
        this.user = user;
        this.contact = contact;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getContact() {
        return contact;
    }

    public void setContact(User contact) {
        this.contact = contact;
    }

}
