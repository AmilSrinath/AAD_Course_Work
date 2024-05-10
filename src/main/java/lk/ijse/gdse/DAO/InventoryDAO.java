package lk.ijse.gdse.DAO;

import lk.ijse.gdse.Entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Amil Srinath
 */
public interface InventoryDAO extends JpaRepository<Inventory,String> {
    @Query(value = "SELECT item_code FROM inventory WHERE item_code LIKE CONCAT(:occ, '%') ORDER BY item_code DESC LIMIT 1", nativeQuery = true)
    String findLastId(@Param("occ") String occ);

    @Query(value = "SELECT item_code FROM inventory", nativeQuery = true)
    List<String> getItemIds();
}
