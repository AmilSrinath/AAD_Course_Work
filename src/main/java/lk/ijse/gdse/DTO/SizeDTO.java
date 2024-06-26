package lk.ijse.gdse.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Amil Srinath
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class SizeDTO {
    private int size;
    private String item_code;
    private int quantity;
    private double unit_price_sale;
    private double unit_price_buy;
    private double expected_profit;
    private String status;
    private double profit_margin;
}
