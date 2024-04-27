package lk.ijse.gdse.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Amil Srinath
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "inventory")
public class Inventory implements SuperEntity{
    @Id
    private String item_code;
    private String item_desc;
    private int item_qty;
    @Column(columnDefinition = "LONGTEXT")
    private String item_pic;
    private String category;
    private int size;
    private double unit_price_sale;
    private double unit_price_buy;
    private double expected_profit;
    private double profit_margin;
    private String status;

    @OneToMany(mappedBy = "inventory")
    private Set<SaleInventoryDetail> saleDetails = new HashSet<>();

    @OneToMany(mappedBy = "inventory")
    private Set<SupplierInventoryDetail> supplierInventoryDetails = new HashSet<>();
}
