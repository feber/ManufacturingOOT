package org.manufacturingoot.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import org.manufacturingoot.model.User;

public class LoginService {

    private EntityManagerFactory emf;

    public LoginService(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public User login(String table, String username, String password) {
        EntityManager em = emf.createEntityManager();
        String raw = String.format("SELECT m FROM %s m WHERE m.username = :username "
                + "and m.password = :password", table);
        try {
            Query query = em.createQuery(raw);
            query.setParameter("username", username);
            query.setParameter("password", password);
            return (User) query.getSingleResult();
        } finally {
            em.close();
        }
    }
}
