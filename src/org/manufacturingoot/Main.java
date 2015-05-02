package org.manufacturingoot;

import java.util.Date;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.manufacturingoot.model.BillOfMaterial;
import org.manufacturingoot.model.DistributionOrder;
import org.manufacturingoot.service.ManufacturingOrderService;
import org.manufacturingoot.model.ManufacturingOrder;
import org.manufacturingoot.model.Part;
import org.manufacturingoot.model.Product;
import org.manufacturingoot.model.ProductionDepartment;
import org.manufacturingoot.model.SalesDepartment;
import org.manufacturingoot.model.SalesForecast;
import org.manufacturingoot.model.WarehouseDepartment;
import org.manufacturingoot.model.WorkSchedule;
import org.manufacturingoot.service.BillOfMaterialService;
import org.manufacturingoot.service.DistributionOrderService;
import org.manufacturingoot.service.PartService;
import org.manufacturingoot.service.ProductService;
import org.manufacturingoot.service.ProductionDepartmentService;
import org.manufacturingoot.service.SalesDepartmentService;
import org.manufacturingoot.service.SalesForecastService;
import org.manufacturingoot.service.WarehouseDepartmentService;
import org.manufacturingoot.service.WorkScheduleService;

public class Main {

    public static void main(String[] args) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ManufacturingOOTPU");

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

        ManufacturingOrder mo = new ManufacturingOrder();
        mo.setEmail("somebody@a.com");
        mo.setStatus("");
        mo.setMessage("kursi 3 meja 4");
        mo.setReceiveDate(new Date());
        mo.setCreatedBy(pd);
        ManufacturingOrderService mos = new ManufacturingOrderService(emf);
        mos.create(mo);

        Part part = new Part();
        part.setName("kayu");
        part.setPrice(5000D);
        part.setStock(23);
        part.setWeight(2.1);
        part.setCreatedBy(wd);
        PartService partService = new PartService(emf);
        partService.create(part);

        Product product = new Product();
        product.setName("mos");
        product.setOrder(mo);
        product.setWeight(1D);
        product.setCreatedBy(pd);
        ProductService ps = new ProductService(emf);
        ps.create(product);

        BillOfMaterial bom = new BillOfMaterial();
        bom.setRequestDate(new Date());
        bom.setCreatedBy(wd);
        bom.setPart(part);
        bom.setProduct(product);
        bom.setAmount(12);
        BillOfMaterialService materialService = new BillOfMaterialService(emf);
        materialService.create(bom);

        product.setPrice(product.getProductionCost() * 1.2);
        ps.edit(product);

        SalesForecast sf = new SalesForecast();
        sf.setDate(new Date());
        sf.getProducts().add(product);
        sf.setProductionProbability(0.7);
        sf.setCreatedBy(sd);
        SalesForecastService sfs = new SalesForecastService(emf);
        sfs.create(sf);

        DistributionOrder do1 = new DistributionOrder();
        do1.setAddress("a");
        do1.setEmail("a");
        do1.setFullName("a");
        do1.setPhoneNumber("a");
        do1.setSendDate(new Date());
        do1.setOrder(mo);
        do1.setCreatedBy(sd);
        DistributionOrderService dos = new DistributionOrderService(emf);
        dos.create(do1);

        WorkSchedule ws = new WorkSchedule();
        ws.setDueDate(new Date());
        ws.setStartDate(new Date());
        ws.setFinishDate(new Date());
        ws.setOrder(mo);
        ws.setCreatedBy(pd);
        WorkScheduleService wss = new WorkScheduleService(emf);
        wss.create(ws);

        emf.close();
    }
}
