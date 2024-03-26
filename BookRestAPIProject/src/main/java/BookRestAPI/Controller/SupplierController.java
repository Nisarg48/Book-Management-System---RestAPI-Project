package BookRestAPI.Controller;

import BookRestAPI.Entities.Supplier;
import BookRestAPI.Service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SupplierController {
    private SupplierService supplierService;

    @Autowired
    SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping("/supplier")
    public List<Supplier> getAllSupplier() {
        return supplierService.findAll();
    }

    @GetMapping("/supplier/sid/{id}")
    public Supplier getSupplierById(@PathVariable int id) {
        Supplier supplier = supplierService.findById(id);
        return supplier;
    }

    @PostMapping("/supplier")
    public void addSupplier(@RequestBody Supplier supplier) {
        supplierService.addSupplier(supplier);
    }

    @DeleteMapping("/supplier/{id}")
    public void deleteSupplierById(@PathVariable int id) {
        supplierService.deleteById(id);
    }
}
