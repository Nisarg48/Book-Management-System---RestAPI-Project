package BookRestAPI.Dao;

import BookRestAPI.Entities.Supplier;

import java.util.List;

public interface SupplierDao {
    public List<Supplier> findAll();

    public Supplier findById(int id);

    public void addSupplier(Supplier supplier);

    public void deleteById(int id);
}
