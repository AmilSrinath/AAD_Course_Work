package lk.ijse.gdse.DAO;

import lk.ijse.gdse.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Amil Srinath
 */
public interface CustomerDAO extends JpaRepository<Customer, String> {

}
