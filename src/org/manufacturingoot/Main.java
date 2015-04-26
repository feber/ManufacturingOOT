package org.manufacturingoot;

import java.util.Date;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.manufacturingoot.model.BillOfMaterial;
import org.manufacturingoot.service.ManufacturingOrderService;
import org.manufacturingoot.model.ManufacturingOrder;
import org.manufacturingoot.model.Part;
import org.manufacturingoot.model.Product;
import org.manufacturingoot.service.BillOfMaterialService;
import org.manufacturingoot.service.PartService;
import org.manufacturingoot.service.ProductService;

public class Main {

    public static void main(String[] args) {
        ManufacturingOrder mo = new ManufacturingOrder();
        mo.setEmail("somebody@a.com");
        mo.setStatus("");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ManufacturingOOTPU");
        ManufacturingOrderService controller = new ManufacturingOrderService(emf);
        controller.create(mo);

        Part part = new Part();
        part.setName("kayu");
        part.setPrice(5000);
        part.setStock(23);
        part.setWeight(2.1);
        PartService partService = new PartService(emf);
        partService.create(part);

        BillOfMaterial bom = new BillOfMaterial();
        bom.setApproved(true);
        bom.setRequestDate(new Date());
        bom.addPart(part);
        BillOfMaterialService materialService = new BillOfMaterialService(emf);
        materialService.create(bom);

        Product product = new Product();
        product.setName("mos");
        product.setProductionCost(300);
        product.setPrice(product.getProductionCost() * (float) 1.2);
        product.setSoldable(true);
        product.setVolume("1 m^3");
        product.setWeight(1);
        product.setOrder(mo);

        ProductService ps = new ProductService(emf);
        ps.create(product);

        emf.close();
    }
}
