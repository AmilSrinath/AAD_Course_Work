package lk.ijse.gdse.Controller;

import lk.ijse.gdse.DTO.InventoryDTO;
import lk.ijse.gdse.service.InventoryService;
import lk.ijse.gdse.util.UtilMatters;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @author Amil Srinath
 */
@RestController
@RequestMapping("/api/v1/inventory")
@RequiredArgsConstructor
public class InventoryController {
    private final InventoryService inventoryService;

    @GetMapping("/health")
    public String health(){
        return "OK";
    }

    @PostMapping("/save")
    public boolean save(
            @RequestPart("item_desc") String item_desc,
            @RequestPart("item_qty") String item_qty,
            @RequestPart("item_pic") String item_pic,
            @RequestPart("category") String category,
            @RequestPart("size") String size,
            @RequestPart("unit_price_sale") String unit_price_sale,
            @RequestPart("unit_price_buy") String unit_price_buy,
            @RequestPart("expected_profit") String expected_profit,
            @RequestPart("profit_margin") String profit_margin,
            @RequestPart("status") String status
    ){

        InventoryDTO inventoryDTO = new InventoryDTO();
        inventoryDTO.setItem_code(UUID.randomUUID().toString());
        inventoryDTO.setItem_desc(item_desc);
        inventoryDTO.setItem_pic(UtilMatters.convertBase64(item_pic));
        inventoryDTO.setCategory(category);
        inventoryDTO.setItem_qty(Integer.parseInt(item_qty));
        inventoryDTO.setSize(Integer.parseInt(size));
        inventoryDTO.setUnit_price_sale(Double.parseDouble(unit_price_sale));
        inventoryDTO.setUnit_price_buy(Double.parseDouble(unit_price_buy));
        inventoryDTO.setExpected_profit(Double.parseDouble(expected_profit));
        inventoryDTO.setProfit_margin(Double.parseDouble(profit_margin));
        inventoryDTO.setStatus(status);

        return inventoryService.saveInventory(inventoryDTO);
    }
}
