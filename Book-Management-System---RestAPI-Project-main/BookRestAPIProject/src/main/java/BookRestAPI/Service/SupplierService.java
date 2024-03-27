package BookRestAPI.Service;

import BookRestAPI.Entities.Supplier;

import java.util.List;

public interface SupplierService {
    public List<Supplier> findAll();

    public Supplier findById(int id);

    public void addSupplier(Supplier supplier);

    public void deleteById(int id);
}
