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
import java.util.Optional;

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
        return conversionData.getInventoryDTOList(inventoryDAO.findAll());
    }

    @Override
    public boolean deleteInventoryById(String id) {
        Optional<Inventory> inventory = inventoryDAO.findById(id);
        if (inventory.isPresent()) {
            inventoryDAO.delete(inventory.get());
            return true;
        }
        return false;
    }

    @Override
    public boolean updateInventoryById(String id, InventoryDTO inventoryDTO) {
        Optional<Inventory> inventory = inventoryDAO.findById(id);
        if (inventory.isPresent()) {
            inventory.get().setItem_desc(inventoryDTO.getItem_desc());
            inventory.get().setItem_qty(inventoryDTO.getItem_qty());
            inventory.get().setItem_pic(inventoryDTO.getItem_pic());
            inventory.get().setCategory(inventoryDTO.getCategory());
            inventory.get().setSize(inventoryDTO.getSize());
            inventory.get().setUnit_price_sale(inventoryDTO.getUnit_price_sale());
            inventory.get().setUnit_price_buy(inventoryDTO.getUnit_price_buy());
            inventory.get().setExpected_profit(inventoryDTO.getExpected_profit());
            inventory.get().setProfit_margin(inventoryDTO.getProfit_margin());
            inventory.get().setStatus(inventoryDTO.getStatus());
            return true;
        }
        return false;
    }
}
