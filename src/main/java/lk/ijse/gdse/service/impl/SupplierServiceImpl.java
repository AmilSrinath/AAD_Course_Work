package lk.ijse.gdse.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.gdse.DAO.SupplierDAO;
import lk.ijse.gdse.DTO.SupplierDTO;
import lk.ijse.gdse.Entity.Supplier;
import lk.ijse.gdse.Exception.NotFoundException;
import lk.ijse.gdse.conversion.Mapping;
import lk.ijse.gdse.service.SupplierService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public boolean deleteSupplierById(String id) throws NotFoundException {
        Optional<Supplier> supplier = supplierDAO.findById(id);
        if (supplier.isPresent()) {
            supplierDAO.delete(supplier.get());
            return true;
        }else{
            throw new NotFoundException(id+" not found (:");
        }
    }

    @Override
    public boolean updateSupplierById(String id, SupplierDTO supplierDTO) throws NotFoundException {
        Optional<Supplier> supplier = supplierDAO.findById(id);
        if (supplier.isPresent()) {
            supplier.get().setSupplier_name(supplierDTO.getSupplier_name());
            supplier.get().setCategory(supplierDTO.getCategory());
            supplier.get().setAddress_line_01(supplierDTO.getAddress_line_01());
            supplier.get().setAddress_line_02(supplierDTO.getAddress_line_02());
            supplier.get().setAddress_line_03(supplierDTO.getAddress_line_03());
            supplier.get().setAddress_line_04(supplierDTO.getAddress_line_04());
            supplier.get().setAddress_line_05(supplierDTO.getAddress_line_05());
            supplier.get().setAddress_line_06(supplierDTO.getAddress_line_06());
            supplier.get().setContact_no_1(supplierDTO.getContact_no_1());
            supplier.get().setContact_no_2(supplierDTO.getContact_no_2());
            supplier.get().setEmail(supplierDTO.getEmail());
            return true;
        }else{
            throw new NotFoundException(id+" not found (:");
        }
    }
}
