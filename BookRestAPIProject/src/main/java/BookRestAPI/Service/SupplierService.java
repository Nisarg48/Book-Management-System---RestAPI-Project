package BookRestAPI.Service;

import java.util.List;

import BookRestAPI.Entities.Supplier;

public interface SupplierService 
{
	public List<Supplier> findAll();
	
	public Supplier findById(int id);

	public void addSupplier(Supplier supplier);
	
	public void deleteById(int id);
}
