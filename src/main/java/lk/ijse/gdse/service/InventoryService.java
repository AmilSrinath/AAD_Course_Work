package lk.ijse.gdse.service;

import lk.ijse.gdse.DTO.CustomerDTO;
import lk.ijse.gdse.DTO.InventoryDTO;
import lk.ijse.gdse.Entity.Inventory;
import lk.ijse.gdse.Exception.NotFoundException;

import java.util.List;

/**
 * @author Amil Srinath
 */
public interface InventoryService {
    boolean saveInventory(InventoryDTO inventoryDTO, String supplier_id) throws NotFoundException;
    List<InventoryDTO> getAllInventories();
    boolean deleteInventoryById(String id) throws NotFoundException;
    boolean updateInventoryById(String id, InventoryDTO inventoryDTO) throws NotFoundException;
    String generateNextId(String occupation, String gender);
    InventoryDTO selectInventoryById(String id) throws NotFoundException;
}
