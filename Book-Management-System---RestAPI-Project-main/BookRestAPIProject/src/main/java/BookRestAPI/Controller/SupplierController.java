package BookRestAPI.Controller;

import BookRestAPI.Entities.Supplier;
import BookRestAPI.Service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasRole('ADMIN')")
    public List<Supplier> getAllSupplier() {
        return supplierService.findAll();
    }

    @GetMapping("/supplier/sid/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Supplier getSupplierById(@PathVariable int id) {
        Supplier supplier = supplierService.findById(id);
        return supplier;
    }

    @PostMapping("/supplier")
    @PreAuthorize("hasRole('ADMIN')")
    public void addSupplier(@RequestBody Supplier supplier) {
        supplierService.addSupplier(supplier);
    }

    @DeleteMapping("/supplier/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteSupplierById(@PathVariable int id) {
        supplierService.deleteById(id);
    }
}
