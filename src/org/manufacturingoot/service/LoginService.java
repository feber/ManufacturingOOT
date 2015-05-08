package org.manufacturingoot.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.manufacturingoot.model.ProductionDepartment;
import org.manufacturingoot.model.SalesDepartment;
import org.manufacturingoot.model.User;
import org.manufacturingoot.model.WarehouseDepartment;

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

    public User unionLogin(String username, String password) {
        EntityManager em = emf.createEntityManager();
        String raw = "SELECT p FROM ProductionDepartment p WHERE p.username = :user "
                + "and p.password = :pass ";
        raw += "UNION SELECT s FROM SalesDepartment s WHERE s.username = :user "
                + "and s.password = :pass ";
        raw += "UNION SELECT w FROM WarehouseDepartment w WHERE w.username = :user "
                + "and w.password = :pass ";
        try {
            Query query = em.createQuery(raw);
            query.setParameter("user", username);
            query.setParameter("pass", password);
            return (User) query.getSingleResult();
        } finally {
            em.close();
        }
    }

    public User multiLogin(String username, String password) {
        EntityManager em = emf.createEntityManager();
        User user = null;
        Query query;

        String raw = "SELECT p FROM ProductionDepartment p WHERE p.username = :user "
                + "and p.password = :pass ";
        try {
            query = em.createQuery(raw);
            query.setParameter("user", username);
            query.setParameter("pass", password);
            user = (ProductionDepartment) query.getSingleResult();
            if (user != null) {
                return user;
            }
        } catch (NoResultException nre) {
            System.out.println("go to another table");
        }

        try {
            raw = "SELECT s FROM SalesDepartment s WHERE s.username = :user "
                    + "and s.password = :pass ";
            query = em.createQuery(raw);
            query.setParameter("user", username);
            query.setParameter("pass", password);
            user = (SalesDepartment) query.getSingleResult();
            if (user != null) {
                return user;
            }
        } catch (NoResultException nre) {
            System.out.println("go to another table");
        }

        try {
            raw = "SELECT w FROM WarehouseDepartment w WHERE w.username = :user "
                    + "and w.password = :pass ";
            query = em.createQuery(raw);
            query.setParameter("user", username);
            query.setParameter("pass", password);
            user = (WarehouseDepartment) query.getSingleResult();
            if (user != null) {
                return user;
            }
        } catch (NoResultException nre) {
            System.out.println("go to another table");
        }
        return null;

    }
}
