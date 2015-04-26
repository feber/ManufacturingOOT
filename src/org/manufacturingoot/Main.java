package org.manufacturingoot;

import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.manufacturingoot.service.ManufacturingOrderService;
import org.manufacturingoot.model.ManufacturingOrder;

public class Main {

    public static void main(String[] args) {
        ManufacturingOrder mo = new ManufacturingOrder();
        mo.setEmail("somebody@a.com");
        mo.setStatus("");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ManufacturingOOTPU");
        ManufacturingOrderService controller = new ManufacturingOrderService(emf);
        controller.create(mo);

        List<ManufacturingOrder> jambu = controller.findManufacturingOrderEntities();
        System.out.println(jambu.get(0).getEmail());

        emf.close();
    }
}
