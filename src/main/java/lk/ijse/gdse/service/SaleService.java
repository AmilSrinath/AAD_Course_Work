package lk.ijse.gdse.service;

import lk.ijse.gdse.Entity.Inventory;
import lk.ijse.gdse.Entity.Sale;

import java.util.List;

/**
 * @author Amil Srinath
 */
public interface SaleService {
    List<String> getItemIds();
    Inventory getItem(String itemCode);
}
