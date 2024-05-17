package lk.ijse.gdse.DAO;

import lk.ijse.gdse.Entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Amil Srinath
 */
public interface SaleDAO extends JpaRepository<Sale, String> {
    @Query(value = "SELECT item_code FROM inventory", nativeQuery = true)
    List<String> getItemIds();
}
