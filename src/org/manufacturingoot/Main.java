package org.manufacturingoot;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.manufacturingoot.service.ManufacturingOrderService;
import org.manufacturingoot.model.ManufacturingOrder;
import org.manufacturingoot.model.Product;
import org.manufacturingoot.service.ProductService;

public class Main {

    public static void main(String[] args) {
        ManufacturingOrder mo = new ManufacturingOrder();
        mo.setEmail("somebody@a.com");
        mo.setStatus("");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ManufacturingOOTPU");
        ManufacturingOrderService controller = new ManufacturingOrderService(emf);
        controller.create(mo);

        Product p = new Product();
        p.setName("mos");
        p.setProductionCost(300);
        p.setPrice(p.getProductionCost() * (float) 1.2);
        p.setSoldable(true);
        p.setVolume("1 m^3");
        p.setWeight(1);
        p.setOrder(mo);
        
        ProductService ps=new ProductService(emf);
        ps.create(p);

        emf.close();
    }
}
