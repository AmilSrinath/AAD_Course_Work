package lk.ijse.gdse.service;

import lk.ijse.gdse.DTO.PlaceOrderRequestDTO;
import lk.ijse.gdse.Entity.Inventory;
import lk.ijse.gdse.Entity.Sale;
import lk.ijse.gdse.Exception.NotFoundException;

import java.util.List;

/**
 * @author Amil Srinath
 */
public interface SaleService {
    List<String> getItemIds();
    Inventory getItem(String itemCode);

    boolean placeOrder(PlaceOrderRequestDTO placeOrderRequestDTO) throws NotFoundException;
}
