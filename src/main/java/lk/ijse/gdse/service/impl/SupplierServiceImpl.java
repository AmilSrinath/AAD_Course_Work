package lk.ijse.gdse.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.gdse.DAO.SupplierDAO;
import lk.ijse.gdse.DTO.SupplierDTO;
import lk.ijse.gdse.Entity.Supplier;
import lk.ijse.gdse.conversion.Mapping;
import lk.ijse.gdse.service.SupplierService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Amil Srinath
 */
@Service
@Transactional
@AllArgsConstructor
public class SupplierServiceImpl implements SupplierService {
    private SupplierDAO supplierDAO;
    private final Mapping conversionData;

    @Override
    public boolean saveSupplier(SupplierDTO supplierDTO) {
        Supplier isSaved = supplierDAO.save(conversionData.toSupplier(supplierDTO));
        return isSaved != null;
    }

    @Override
    public List<SupplierDTO> getAllSuppliers() {
        return conversionData.getSupplierDTOList(supplierDAO.findAll());
    }

    @Override
    public boolean deleteSupplierById(String id) {
        return false;
    }

    @Override
    public boolean updateSupplierById(String id, SupplierDTO supplierDTO) {
        return false;
    }
}
