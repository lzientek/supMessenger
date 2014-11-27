package sun.supinfo.supMessaging.entities;

import sun.supinfo.supMessaging.helpers.Crypto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Entity User
 */
@Entity
@Table(name = "Users")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Boolean isAdmin;

    private String userName;

    private String passWord;

    private Date inscriptionDate;

    @OneToMany(mappedBy = "user")
    private List<Contacts> contacts;

    public Date getInscriptionDate() {
        return inscriptionDate;
    }

    public void setInscriptionDate(Date inscriptionDate) {
        this.inscriptionDate = inscriptionDate;
    }

    public List<Contacts> getContactsBinding() {
        return contacts;
    }

    public void setContactsBinding(List<Contacts> contacts) {
        this.contacts = contacts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    /**
     * check if the encrypted database password is equal to the parameter
     *
     * @param pass password to check
     * @return true if equal
     */
    public Boolean checkPassword(String pass) {
        return passWord.equals(Crypto.encryptPassword(pass));
    }

    /**
     * encrypt and set the password
     *
     * @param passWord
     */
    public void setUnEncryptPassWord(String passWord) {
        this.passWord = Crypto.encryptPassword(passWord);
    }
}
