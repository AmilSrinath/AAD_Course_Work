package lk.ijse.gdse.service;

import lk.ijse.gdse.DTO.CustomerDTO;
import lk.ijse.gdse.DTO.InventoryDTO;

import java.util.List;

/**
 * @author Amil Srinath
 */
public interface InventoryService {
    boolean saveInventory(InventoryDTO inventoryDTO);
    List<InventoryDTO> getAllInventories();
    boolean deleteInventoryById(String id);
    boolean updateInventoryById(String id, InventoryDTO inventoryDTO);
}
