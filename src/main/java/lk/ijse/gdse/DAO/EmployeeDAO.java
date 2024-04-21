package lk.ijse.gdse.DAO;

import lk.ijse.gdse.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Amil Srinath
 */
public interface EmployeeDAO extends JpaRepository<Employee, String> {

}
