package lk.ijse.gdse.DTO;

/**
 * @author Amil Srinath
 */
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PlaceOrderRequestDTO {
    private String customer_id;
    private String customer_name;
    private double net_total;
    private Date purchase_date;
    private String payment_type;
    private List<OrderItemDTO> items;
}
