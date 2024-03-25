package BookRestAPI.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import BookRestAPI.Entities.Supplier;
import BookRestAPI.Service.SupplierService;

@RestController
public class SupplierController 
{
	private SupplierService supplierService;
	
	@Autowired
	SupplierController(SupplierService supplierService){
		this.supplierService = supplierService;
	}
	
	@GetMapping("/supplier")
	public List<Supplier> getAllSupplier(){
		return supplierService.findAll();
	}
	
	@GetMapping("/supplier/sid/{id}")
	public Supplier getSupplierById(@PathVariable int id)
	{
		Supplier supplier = supplierService.findById(id);
		return supplier; 
	}
	
	@PostMapping("/supplier")
	public void addSupplier(@RequestBody Supplier supplier)
	{
		supplierService.addSupplier(supplier);
	}
	
	@DeleteMapping("/supplier/{id}")
	public void deleteSupplierById(@PathVariable int id)
	{
		supplierService.deleteById(id);
	}
}
