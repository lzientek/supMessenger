package sun.supinfo.supMessaging.entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by lucas on 27/11/2014.
 */
@Entity
@Table(name = "Messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "contactBinding_FK")
    private ContactBinding contactBinding;

    private String message;

    private Date sendDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ContactBinding getContactBinding() {
        return contactBinding;
    }

    public void setContactBinding(ContactBinding contactbinding) {
        this.contactBinding = contactbinding;
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
