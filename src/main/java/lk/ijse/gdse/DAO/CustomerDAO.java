package lk.ijse.gdse.DAO;

import lk.ijse.gdse.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Amil Srinath
 */
public interface CustomerDAO extends JpaRepository<Customer, String> {
    Optional<Customer> findByEmail(String email);
}
