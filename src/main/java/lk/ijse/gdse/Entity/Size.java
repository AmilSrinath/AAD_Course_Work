package lk.ijse.gdse.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Amil Srinath
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "size")
@Entity
public class Size {
    @Id
    private String size_id;
    private int size;
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "item_code")
    private Inventory inventory;
}
