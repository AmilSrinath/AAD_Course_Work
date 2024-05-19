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
public class OrderItemDTO {
    private String item_id;
    private String item_name;
    private int item_size;
    private int quantity;
    private double unit_price;
    private double total_price;
}
