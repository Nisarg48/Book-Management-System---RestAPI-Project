package BookRestAPI.Service;

import BookRestAPI.Dao.SupplierDao;
import BookRestAPI.Entities.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {
    private SupplierDao supplierDao;

    @Autowired
    public SupplierServiceImpl(@Qualifier("supplierDaoImpl") SupplierDao supplierDao) {
        this.supplierDao = supplierDao;
    }

    @Override
    @Transactional
    public List<Supplier> findAll() {
        return supplierDao.findAll();
    }

    @Override
    @Transactional
    public Supplier findById(int id) {
        return supplierDao.findById(id);
    }

    @Override
    @Transactional
    public void addSupplier(Supplier supplier) {
        supplierDao.addSupplier(supplier);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        supplierDao.deleteById(id);
    }
}
