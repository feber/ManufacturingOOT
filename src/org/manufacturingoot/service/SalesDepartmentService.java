package org.manufacturingoot.service;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.manufacturingoot.model.SalesDepartment;
import org.manufacturingoot.service.exceptions.NonexistentEntityException;
import org.manufacturingoot.service.exceptions.PreexistingEntityException;

public class SalesDepartmentService implements Serializable {

    public SalesDepartmentService(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(SalesDepartment salesDepartment) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(salesDepartment);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findSalesDepartment(salesDepartment.getUsername()) != null) {
                throw new PreexistingEntityException("SalesDepartment " + salesDepartment + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(SalesDepartment salesDepartment) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            salesDepartment = em.merge(salesDepartment);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = salesDepartment.getUsername();
                if (findSalesDepartment(id) == null) {
                    throw new NonexistentEntityException("The salesDepartment with id " + id + " no longer exists.");
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
            SalesDepartment salesDepartment;
            try {
                salesDepartment = em.getReference(SalesDepartment.class, id);
                salesDepartment.getUsername();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The salesDepartment with id " + id + " no longer exists.", enfe);
            }
            em.remove(salesDepartment);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<SalesDepartment> findSalesDepartmentEntities() {
        return findSalesDepartmentEntities(true, -1, -1);
    }

    public List<SalesDepartment> findSalesDepartmentEntities(int maxResults, int firstResult) {
        return findSalesDepartmentEntities(false, maxResults, firstResult);
    }

    private List<SalesDepartment> findSalesDepartmentEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(SalesDepartment.class));
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

    public SalesDepartment findSalesDepartment(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(SalesDepartment.class, id);
        } finally {
            em.close();
        }
    }

    public int getSalesDepartmentCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<SalesDepartment> rt = cq.from(SalesDepartment.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
