package lk.ijse.gdse.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.gdse.DAO.InventoryDAO;
import lk.ijse.gdse.Entity.Inventory;
import lk.ijse.gdse.Entity.Sale;
import lk.ijse.gdse.service.SaleService;
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
public class SaleServiceImpl implements SaleService {
    private InventoryDAO inventoryDAO;

    @Override
    public List<String> getItemIds() {
        return inventoryDAO.getItemIds();
    }

    @Override
    public Inventory getItem(String itemCode) {
        Optional<Inventory> item = inventoryDAO.findById(itemCode);
        if (item.isPresent()) {
            return item.get();
        }
        return null;
    }
}
