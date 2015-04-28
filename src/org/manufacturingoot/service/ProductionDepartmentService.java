package org.manufacturingoot.service;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.manufacturingoot.model.ProductionDepartment;
import org.manufacturingoot.service.exceptions.NonexistentEntityException;
import org.manufacturingoot.service.exceptions.PreexistingEntityException;

public class ProductionDepartmentService implements Serializable {

    public ProductionDepartmentService(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ProductionDepartment productionDepartment) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(productionDepartment);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findProductionDepartment(productionDepartment.getUsername()) != null) {
                throw new PreexistingEntityException("ProductionDepartment " + productionDepartment + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ProductionDepartment productionDepartment) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            productionDepartment = em.merge(productionDepartment);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = productionDepartment.getUsername();
                if (findProductionDepartment(id) == null) {
                    throw new NonexistentEntityException("The productionDepartment with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ProductionDepartment productionDepartment;
            try {
                productionDepartment = em.getReference(ProductionDepartment.class, id);
                productionDepartment.getUsername();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The productionDepartment with id " + id + " no longer exists.", enfe);
            }
            em.remove(productionDepartment);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ProductionDepartment> findProductionDepartmentEntities() {
        return findProductionDepartmentEntities(true, -1, -1);
    }

    public List<ProductionDepartment> findProductionDepartmentEntities(int maxResults, int firstResult) {
        return findProductionDepartmentEntities(false, maxResults, firstResult);
    }

    private List<ProductionDepartment> findProductionDepartmentEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ProductionDepartment.class));
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

    public ProductionDepartment findProductionDepartment(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ProductionDepartment.class, id);
        } finally {
            em.close();
        }
    }

    public int getProductionDepartmentCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ProductionDepartment> rt = cq.from(ProductionDepartment.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
