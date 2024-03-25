package BookRestAPI.Dao;

import java.util.List;

import BookRestAPI.Entities.Supplier;

public interface SupplierDao 
{
	public List<Supplier> findAll();
	
	public Supplier findById(int id);

	public void addSupplier(Supplier supplier);
	
	public void deleteById(int id);
}
