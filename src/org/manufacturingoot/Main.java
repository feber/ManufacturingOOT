package org.manufacturingoot;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.manufacturingoot.controller.ManufacturingOrderJpaController;
import org.manufacturingoot.model.ManufacturingOrder;

public class Main {
    
    public static void main(String[] args) {
        ManufacturingOrder mo = new ManufacturingOrder();
        mo.setEmail("somebody@a.com");
        mo.setStatus("");
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ManufacturingOOTPU");
        ManufacturingOrderJpaController controller = new ManufacturingOrderJpaController(emf);
        controller.create(mo);
    }
}
