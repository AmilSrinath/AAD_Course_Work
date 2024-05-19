package lk.ijse.gdse.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.gdse.DAO.InventoryDAO;
import lk.ijse.gdse.DAO.SaleDAO;
import lk.ijse.gdse.DAO.SaleInventoryDetailDAO;
import lk.ijse.gdse.DTO.OrderItemDTO;
import lk.ijse.gdse.DTO.PlaceOrderRequestDTO;
import lk.ijse.gdse.DTO.SaleDTO;
import lk.ijse.gdse.Entity.Inventory;
import lk.ijse.gdse.Entity.Sale;
import lk.ijse.gdse.Entity.SaleInventoryDetail;
import lk.ijse.gdse.Exception.NotFoundException;
import lk.ijse.gdse.service.SaleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author Amil Srinath
 */
@Service
@Transactional
@AllArgsConstructor
public class SaleServiceImpl implements SaleService {
    private InventoryDAO inventoryDAO;
    private SaleDAO saleRepository;
    private SaleInventoryDetailDAO saleInventoryDetailRepository;

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

    @Override
    public boolean placeOrder(PlaceOrderRequestDTO placeOrderRequestDTO) throws NotFoundException {
        Sale sale = new Sale();
        sale.setOrder_id(UUID.randomUUID().toString());
        sale.setCustomer_name(placeOrderRequestDTO.getCustomer_name());
        sale.setTotal_price(placeOrderRequestDTO.getNet_total());
        sale.setPurchase_date(new Date());
        sale.setPayment_method(placeOrderRequestDTO.getPayment_type());

        Sale savedSale = saleRepository.save(sale);

        List<SaleInventoryDetail> saleInventoryDetails = new ArrayList<>();
        for (OrderItemDTO item : placeOrderRequestDTO.getItems()) {
            Inventory inventory = inventoryDAO.findById(item.getItem_id()).orElseThrow(() -> new NotFoundException("Item not found"));

            SaleInventoryDetail saleInventoryDetail = new SaleInventoryDetail();
            saleInventoryDetail.setOrderDetailID(UUID.randomUUID().toString());
            saleInventoryDetail.setInventory(inventory);
            saleInventoryDetail.setSale(savedSale);
            saleInventoryDetail.setItemName(item.getItem_name());
            saleInventoryDetail.setQuantity(item.getQuantity());
            saleInventoryDetail.setSize(item.getItem_size());
            saleInventoryDetail.setUnitPrice(item.getUnit_price());
            saleInventoryDetail.setSubTotal(item.getTotal_price());

            saleInventoryDetails.add(saleInventoryDetail);
        }
        saleInventoryDetailRepository.saveAll(saleInventoryDetails);

        SaleDTO saleDTO = new SaleDTO();
        saleDTO.setOrder_id(savedSale.getOrder_id());
        saleDTO.setCustomer_name(savedSale.getCustomer_name());
        saleDTO.setTotal_price(savedSale.getTotal_price());
        saleDTO.setPurchase_date(savedSale.getPurchase_date());
        saleDTO.setPayment_method(savedSale.getPayment_method());
        saleDTO.setAdded_points(0);
        saleDTO.setCashier_name("Default Cashier");

        if (saleDTO != null) {
            return true;
        }
        return false;
    }
}
