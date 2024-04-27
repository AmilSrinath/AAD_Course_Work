package lk.ijse.gdse.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Amil Srinath
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class InventoryDTO {
    private String item_code;
    private String item_desc;
    private int item_qty;
    private String item_pic;
    private String category;
    private int size;
    private double unit_price_sale;
    private double unit_price_buy;
    private double expected_profit;
    private double profit_margin;
    private String status;
}