package org.manufacturingoot.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 40)
    private String name;

    @Column(nullable = false)
    private Double productionCost = .0;

    @Column(nullable = false)
    private Double price = .0;

    @Column(nullable = false)
    private Double weight = .0;

    @ManyToOne(optional = false)
    private ManufacturingOrder order;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "product")
    @JoinColumn
    private List<BillOfMaterial> billOfMaterials = new ArrayList<>();

    @ManyToOne
    private ProductionDepartment createdBy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getProductionCost() {
        return productionCost;
    }

    public void setProductionCost(Double productionCost) {
        this.productionCost = productionCost;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public ManufacturingOrder getOrder() {
        return order;
    }

    public void setOrder(ManufacturingOrder order) {
        this.order = order;
    }

    public ProductionDepartment getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(ProductionDepartment createdBy) {
        this.createdBy = createdBy;
    }

    public List<BillOfMaterial> getBillOfMaterials() {
        return billOfMaterials;
    }

    public void calculateCost() {
        productionCost = 0.0;
        for (BillOfMaterial bom : billOfMaterials) {
            productionCost += bom.getPart().getPrice() * bom.getAmount();
        }
        price *= 1.2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.manufacturingoot.model.Product[ id=" + id + " ]";
    }
}
