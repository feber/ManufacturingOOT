package org.manufacturingoot.service;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.manufacturingoot.model.DistributionOrder;
import org.manufacturingoot.service.exceptions.NonexistentEntityException;

public class DistributionOrderService implements Serializable {

    public DistributionOrderService(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(DistributionOrder distributionOrder) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(distributionOrder);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(DistributionOrder distributionOrder) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            distributionOrder = em.merge(distributionOrder);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = distributionOrder.getId();
                if (findDistributionOrder(id) == null) {
                    throw new NonexistentEntityException("The distributionOrder with id " + id + " no longer exists.");
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
            DistributionOrder distributionOrder;
            try {
                distributionOrder = em.getReference(DistributionOrder.class, id);
                distributionOrder.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The distributionOrder with id " + id + " no longer exists.", enfe);
            }
            em.remove(distributionOrder);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<DistributionOrder> findDistributionOrderEntities() {
        return findDistributionOrderEntities(true, -1, -1);
    }

    public List<DistributionOrder> findDistributionOrderEntities(int maxResults, int firstResult) {
        return findDistributionOrderEntities(false, maxResults, firstResult);
    }

    private List<DistributionOrder> findDistributionOrderEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(DistributionOrder.class));
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

    public DistributionOrder findDistributionOrder(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(DistributionOrder.class, id);
        } finally {
            em.close();
        }
    }

    public int getDistributionOrderCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<DistributionOrder> rt = cq.from(DistributionOrder.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
