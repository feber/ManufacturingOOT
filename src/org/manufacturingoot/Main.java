package org.manufacturingoot;

import java.util.Date;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.manufacturingoot.model.BillOfMaterial;
import org.manufacturingoot.service.ManufacturingOrderService;
import org.manufacturingoot.model.ManufacturingOrder;
import org.manufacturingoot.model.Part;
import org.manufacturingoot.model.Product;
import org.manufacturingoot.model.ProductionDepartment;
import org.manufacturingoot.model.SalesDepartment;
import org.manufacturingoot.model.SalesForecast;
import org.manufacturingoot.model.WarehouseDepartment;
import org.manufacturingoot.service.BillOfMaterialService;
import org.manufacturingoot.service.PartService;
import org.manufacturingoot.service.ProductService;
import org.manufacturingoot.service.ProductionDepartmentService;
import org.manufacturingoot.service.SalesDepartmentService;
import org.manufacturingoot.service.SalesForecastService;
import org.manufacturingoot.service.WarehouseDepartmentService;

public class Main {

    public static void main(String[] args) throws Exception {
        ManufacturingOrder mo = new ManufacturingOrder();
        mo.setEmail("somebody@a.com");
        mo.setStatus("");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ManufacturingOOTPU");
        ManufacturingOrderService controller = new ManufacturingOrderService(emf);
        controller.create(mo);

        BillOfMaterial bom = new BillOfMaterial();
        bom.setApproved(true);
        bom.setRequestDate(new Date());
        BillOfMaterialService materialService = new BillOfMaterialService(emf);
        materialService.create(bom);

        Part part = new Part();
        part.setName("kayu");
        part.setPrice(5000);
        part.setStock(23);
        part.setWeight(2.1);
        part.setBillOfMaterial(bom);
        PartService partService = new PartService(emf);
        partService.create(part);

        Product product = new Product();
        product.setName("mos");
        product.setProductionCost(300);
        product.setPrice(product.getProductionCost() * 1.2);
        product.setSoldable(true);
        product.setVolume("1 m^3");
        product.setWeight(1);
        product.setOrder(mo);
        ProductService ps = new ProductService(emf);
        ps.create(product);

        ProductionDepartment pd = new ProductionDepartment();
        pd.setUsername("desri");
        pd.setEmail("dimas@a.a");
        pd.setFullName("Dimas IF");
        pd.setLastLoggedIn(new Date());
        pd.setPhoneNumber("0987");
        ProductionDepartmentService pds = new ProductionDepartmentService(emf);
        pds.create(pd);

        SalesDepartment sd = new SalesDepartment();
        sd.setUsername("hagi");
        sd.setEmail("hagi@a.a");
        sd.setFullName("Hagiansyah Saleh");
        sd.setLastLoggedIn(new Date());
        sd.setPhoneNumber("0986");
        SalesDepartmentService sds = new SalesDepartmentService(emf);
        sds.create(sd);

        WarehouseDepartment wd = new WarehouseDepartment();
        wd.setUsername("desri");
        wd.setEmail("desri@a.a");
        wd.setFullName("Desri Murdianto");
        wd.setLastLoggedIn(new Date());
        wd.setPhoneNumber("0988");
        WarehouseDepartmentService wds = new WarehouseDepartmentService(emf);
        wds.create(wd);

        SalesForecast sf = new SalesForecast();
        sf.setDate(new Date());
        sf.getProducts().add(product);
        SalesForecastService sfs = new SalesForecastService(emf);
        sfs.create(sf);

        emf.close();
    }
}
