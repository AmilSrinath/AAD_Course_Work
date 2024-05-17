package lk.ijse.gdse.Controller;

import lk.ijse.gdse.Entity.Inventory;
import lk.ijse.gdse.Entity.Sale;
import lk.ijse.gdse.Entity.Size;
import lk.ijse.gdse.service.InventoryService;
import lk.ijse.gdse.service.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sale")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class SaleController {
    private final SaleService saleService;
    private final InventoryService inventoryService;

    @GetMapping("/health")
    public String health(){
        return "OK";
    }

    @GetMapping("/getItemIds")
    public List<String> getItemIds(){
        return saleService.getItemIds();
    }

    @GetMapping("getItem/{itemCode}")
    public Inventory getItem(@PathVariable String itemCode){
        return saleService.getItem(itemCode);
    }

    @GetMapping("getItemSize/{itemCode}")
    public List<String> getSize(@PathVariable String itemCode){
        return inventoryService.getSize(itemCode);
    }
}
