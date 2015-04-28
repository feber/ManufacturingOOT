package org.manufacturingoot.service;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.manufacturingoot.model.WarehouseDepartment;
import org.manufacturingoot.service.exceptions.NonexistentEntityException;
import org.manufacturingoot.service.exceptions.PreexistingEntityException;

public class WarehouseDepartmentService implements Serializable {

    public WarehouseDepartmentService(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(WarehouseDepartment warehouseDepartment) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(warehouseDepartment);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findWarehouseDepartment(warehouseDepartment.getUsername()) != null) {
                throw new PreexistingEntityException("WarehouseDepartment " + warehouseDepartment + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(WarehouseDepartment warehouseDepartment) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            warehouseDepartment = em.merge(warehouseDepartment);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = warehouseDepartment.getUsername();
                if (findWarehouseDepartment(id) == null) {
                    throw new NonexistentEntityException("The warehouseDepartment with id " + id + " no longer exists.");
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
            WarehouseDepartment warehouseDepartment;
            try {
                warehouseDepartment = em.getReference(WarehouseDepartment.class, id);
                warehouseDepartment.getUsername();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The warehouseDepartment with id " + id + " no longer exists.", enfe);
            }
            em.remove(warehouseDepartment);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<WarehouseDepartment> findWarehouseDepartmentEntities() {
        return findWarehouseDepartmentEntities(true, -1, -1);
    }

    public List<WarehouseDepartment> findWarehouseDepartmentEntities(int maxResults, int firstResult) {
        return findWarehouseDepartmentEntities(false, maxResults, firstResult);
    }

    private List<WarehouseDepartment> findWarehouseDepartmentEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(WarehouseDepartment.class));
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

    public WarehouseDepartment findWarehouseDepartment(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(WarehouseDepartment.class, id);
        } finally {
            em.close();
        }
    }

    public int getWarehouseDepartmentCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<WarehouseDepartment> rt = cq.from(WarehouseDepartment.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
