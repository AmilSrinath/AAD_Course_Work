package lk.ijse.gdse.DAO;

import lk.ijse.gdse.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Amil Srinath
 */
public interface EmployeeDAO extends JpaRepository<Employee, String> {
    Optional<Employee> findByEmail(String email);
}
