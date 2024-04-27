package lk.ijse.gdse.Controller;

import lk.ijse.gdse.DTO.SupplierDTO;
import lk.ijse.gdse.Exception.NotFoundException;
import lk.ijse.gdse.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * @author Amil Srinath
 */
@RestController
@RequestMapping("/api/v1/supplier")
@RequiredArgsConstructor
public class SuppilerController {
    private final SupplierService supplierService;

    @GetMapping("/health")
    public String health(){
        return "OK";
    }

    @PostMapping("/save")
    public boolean save(@RequestBody SupplierDTO supplierDTO){
        supplierDTO.setSupplier_id(UUID.randomUUID().toString());
        return supplierService.saveSupplier(supplierDTO);
    }

    @GetMapping
    public List<SupplierDTO> getAll(){
        return supplierService.getAllSuppliers();
    }

    @PutMapping("/update")
    @PreAuthorize("hasRole('ADMIN')")
    public boolean update(@RequestBody SupplierDTO supplierDTO) throws NotFoundException {
        return supplierService.updateSupplierById(supplierDTO.getSupplier_id(),supplierDTO);
    }

    @DeleteMapping("/delete")
    public boolean delete(@RequestPart("supplier_id") String id) throws NotFoundException {
        return supplierService.deleteSupplierById(id);
    }
}
