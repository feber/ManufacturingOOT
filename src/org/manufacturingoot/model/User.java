package org.manufacturingoot.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public abstract class User implements Serializable {

    @Id
    @Column(length = 40)
    protected String username;

    @Column(length = 40)
    protected String password;

    @Column(length = 100)
    protected String fullName;

    @Column(length = 40)
    protected String email;

    @Column(length = 15)
    protected String phoneNumber;

    @Temporal(TemporalType.TIMESTAMP)
    protected Date lastLoggedIn;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getLastLoggedIn() {
        return lastLoggedIn;
    }

    public void setLastLoggedIn(Date lastLoggedIn) {
        this.lastLoggedIn = lastLoggedIn;
    }

    public User login(String username, String password, String table) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ManufacturingOOTPU");
        EntityManager em = emf.createEntityManager();
        String raw = String.format("SELECT m FROM %s m WHERE m.username = :user and m.password = :pass",
                table);
        try {
            Query query = em.createQuery(raw);
            query.setParameter("user", username);
            query.setParameter("pass", password);
            return (User) query.getSingleResult();
        } finally {
            em.close();
        }
    }
}
