package lk.ijse.gdse.DAO;

import lk.ijse.gdse.Entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Amil Srinath
 */
public interface InventoryDAO extends JpaRepository<Inventory,String> {

}
