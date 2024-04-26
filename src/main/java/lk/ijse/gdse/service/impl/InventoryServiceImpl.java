package lk.ijse.gdse.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.gdse.DAO.InventoryDAO;
import lk.ijse.gdse.DTO.InventoryDTO;
import lk.ijse.gdse.Entity.Inventory;
import lk.ijse.gdse.conversion.Mapping;
import lk.ijse.gdse.service.InventoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Amil Srinath
 */
@Service
@Transactional
@AllArgsConstructor
public class InventoryServiceImpl implements InventoryService {
    private InventoryDAO inventoryDAO;
    private final Mapping conversionData;

    @Override
    public boolean saveInventory(InventoryDTO inventoryDTO) {
        Inventory isSaved = inventoryDAO.save(conversionData.toInventory(inventoryDTO));
        return isSaved != null;
    }

    @Override
    public List<InventoryDTO> getAllInventories() {
        return List.of();
    }

    @Override
    public boolean deleteInventoryById(String id) {
        return false;
    }

    @Override
    public boolean updateInventoryById(String id, InventoryDTO inventoryDTO) {
        return false;
    }
}
