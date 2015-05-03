package org.manufacturingoot.service;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.manufacturingoot.model.BillOfMaterial;
import org.manufacturingoot.model.Product;
import org.manufacturingoot.model.Part;
import org.manufacturingoot.service.exceptions.NonexistentEntityException;

public class BillOfMaterialService implements Serializable {

    public BillOfMaterialService(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(BillOfMaterial billOfMaterial) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Product product = billOfMaterial.getProduct();
            if (product != null) {
                product = em.getReference(product.getClass(), product.getId());
                billOfMaterial.setProduct(product);
            }
            Part part = billOfMaterial.getPart();
            if (part != null) {
                part = em.getReference(part.getClass(), part.getId());
                billOfMaterial.setPart(part);
            }
            em.persist(billOfMaterial);
            if (product != null) {
                product.getBillOfMaterials().add(billOfMaterial);
                product = em.merge(product);
            }
            if (part != null) {
                part.getBillOfMaterials().add(billOfMaterial);
                part = em.merge(part);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(BillOfMaterial billOfMaterial) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            BillOfMaterial persistentBillOfMaterial = em.find(BillOfMaterial.class, billOfMaterial.getId());
            Product productOld = persistentBillOfMaterial.getProduct();
            Product productNew = billOfMaterial.getProduct();
            Part partOld = persistentBillOfMaterial.getPart();
            Part partNew = billOfMaterial.getPart();
            if (productNew != null) {
                productNew = em.getReference(productNew.getClass(), productNew.getId());
                billOfMaterial.setProduct(productNew);
            }
            if (partNew != null) {
                partNew = em.getReference(partNew.getClass(), partNew.getId());
                billOfMaterial.setPart(partNew);
            }
            billOfMaterial = em.merge(billOfMaterial);
            if (productOld != null && !productOld.equals(productNew)) {
                productOld.getBillOfMaterials().remove(billOfMaterial);
                productOld = em.merge(productOld);
            }
            if (productNew != null && !productNew.equals(productOld)) {
                productNew.getBillOfMaterials().add(billOfMaterial);
                productNew = em.merge(productNew);
            }
            if (partOld != null && !partOld.equals(partNew)) {
                partOld.getBillOfMaterials().remove(billOfMaterial);
                partOld = em.merge(partOld);
            }
            if (partNew != null && !partNew.equals(partOld)) {
                partNew.getBillOfMaterials().add(billOfMaterial);
                partNew = em.merge(partNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = billOfMaterial.getId();
                if (findBillOfMaterial(id) == null) {
                    throw new NonexistentEntityException("The billOfMaterial with id " + id + " no longer exists.");
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
            BillOfMaterial billOfMaterial;
            try {
                billOfMaterial = em.getReference(BillOfMaterial.class, id);
                billOfMaterial.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The billOfMaterial with id " + id + " no longer exists.", enfe);
            }
            Product product = billOfMaterial.getProduct();
            if (product != null) {
                product.getBillOfMaterials().remove(billOfMaterial);
                product = em.merge(product);
            }
            Part part = billOfMaterial.getPart();
            if (part != null) {
                part.getBillOfMaterials().remove(billOfMaterial);
                part = em.merge(part);
            }
            em.remove(billOfMaterial);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<BillOfMaterial> findBillOfMaterialEntities() {
        return findBillOfMaterialEntities(true, -1, -1);
    }

    public List<BillOfMaterial> findBillOfMaterialEntities(int maxResults, int firstResult) {
        return findBillOfMaterialEntities(false, maxResults, firstResult);
    }

    private List<BillOfMaterial> findBillOfMaterialEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(BillOfMaterial.class));
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

    public BillOfMaterial findBillOfMaterial(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(BillOfMaterial.class, id);
        } finally {
            em.close();
        }
    }

    public BillOfMaterial findBillOfMaterialByFK(Part part, Product product) {
        EntityManager em = getEntityManager();
        String raw = "SELECT m FROM BillOfMaterial m WHERE m.part = :x and m.product = :y";
        try {
            Query query = em.createQuery(raw);
            query.setParameter("x", part);
            query.setParameter("y", product);
            return (BillOfMaterial) query.getSingleResult();
        } finally {
            em.close();
        }
    }

    public int getBillOfMaterialCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<BillOfMaterial> rt = cq.from(BillOfMaterial.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}
