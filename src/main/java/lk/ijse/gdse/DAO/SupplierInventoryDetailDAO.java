package lk.ijse.gdse.DAO;

import lk.ijse.gdse.Entity.SaleInventoryDetail;
import lk.ijse.gdse.Entity.SupplierInventoryDetail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Amil Srinath
 */
public interface SupplierInventoryDetailDAO extends JpaRepository<SupplierInventoryDetail, String> {

}
