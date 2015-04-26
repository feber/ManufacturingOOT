package org.manufacturingoot.service;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.manufacturingoot.service.exceptions.NonexistentEntityException;
import org.manufacturingoot.model.ManufacturingOrder;

public class ManufacturingOrderService implements Serializable {

    public ManufacturingOrderService(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ManufacturingOrder manufacturingOrder) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(manufacturingOrder);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ManufacturingOrder manufacturingOrder) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            manufacturingOrder = em.merge(manufacturingOrder);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = manufacturingOrder.getId();
                if (findManufacturingOrder(id) == null) {
                    throw new NonexistentEntityException("The manufacturingOrder with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ManufacturingOrder manufacturingOrder;
            try {
                manufacturingOrder = em.getReference(ManufacturingOrder.class, id);
                manufacturingOrder.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The manufacturingOrder with id " + id + " no longer exists.", enfe);
            }
            em.remove(manufacturingOrder);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ManufacturingOrder> findManufacturingOrderEntities() {
        return findManufacturingOrderEntities(true, -1, -1);
    }

    public List<ManufacturingOrder> findManufacturingOrderEntities(int maxResults, int firstResult) {
        return findManufacturingOrderEntities(false, maxResults, firstResult);
    }

    private List<ManufacturingOrder> findManufacturingOrderEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ManufacturingOrder.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public ManufacturingOrder findManufacturingOrder(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ManufacturingOrder.class, id);
        } finally {
            em.close();
        }
    }

    public int getManufacturingOrderCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ManufacturingOrder> rt = cq.from(ManufacturingOrder.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
