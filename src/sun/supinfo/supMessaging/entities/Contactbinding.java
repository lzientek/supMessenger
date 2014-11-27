package sun.supinfo.supMessaging.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by lucas on 27/11/2014.
 */
@Entity
@Table(name = "ContactBindings")
public class ContactBinding implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_fk")
    private User user;

    @ManyToOne
    @JoinColumn(name = "contact_fk")
    private User contact;

    @OneToMany(mappedBy = "contactBinding")
    private List<Message> messages;

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

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
