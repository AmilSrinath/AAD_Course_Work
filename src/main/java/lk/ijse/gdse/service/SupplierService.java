package lk.ijse.gdse.service;

import lk.ijse.gdse.DTO.SupplierDTO;
import lk.ijse.gdse.Exception.NotFoundException;

import java.util.List;

/**
 * @author Amil Srinath
 */
public interface SupplierService {
    boolean saveSupplier(SupplierDTO supplierDTO);
    List<SupplierDTO> getAllSuppliers();
    boolean deleteSupplierById(String id) throws NotFoundException;
    boolean updateSupplierById(String id, SupplierDTO supplierDTO) throws NotFoundException;
}
