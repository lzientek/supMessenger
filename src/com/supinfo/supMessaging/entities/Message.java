package com.supinfo.supMessaging.entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Created on the 27/11/2014.
 */
@Entity
@Table(name = "Messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "transmitter_fk")
    private User transmitter;

    @ManyToOne
    @JoinColumn(name = "recipient_fk")
    private User recipient;

    private String message;

    private Date sendDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getTransmitter() {
        return transmitter;
    }

    public void setTransmitter(User transmitter) {
        this.transmitter = transmitter;
    }

    public User getRecipient() {
        return recipient;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }
}
