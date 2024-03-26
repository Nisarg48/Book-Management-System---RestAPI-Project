package BookRestAPI.Dao;

import BookRestAPI.Entities.Supplier;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SupplierDaoImpl implements SupplierDao {
    private EntityManager entityManager;

    @Autowired
    public SupplierDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Supplier> findAll() {
        String s = "From Supplier";
        TypedQuery<Supplier> sql = entityManager.createQuery(s, Supplier.class);
        List<Supplier> supplier = sql.getResultList();
        return supplier;
    }

    @Override
    public Supplier findById(int id) {
        Supplier supplier = entityManager.find(Supplier.class, id);
        try {
            return supplier;
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void addSupplier(Supplier supplier) {
        entityManager.persist(supplier);
    }

    @Override
    public void deleteById(int id) {
        Supplier supplier = entityManager.find(Supplier.class, id);
        entityManager.remove(supplier);
    }

}
