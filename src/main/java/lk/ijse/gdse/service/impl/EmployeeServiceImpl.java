package lk.ijse.gdse.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.gdse.DAO.EmployeeDAO;
import lk.ijse.gdse.DAO.UserDAO;
import lk.ijse.gdse.DTO.EmployeeDTO;
import lk.ijse.gdse.Entity.Employee;
import lk.ijse.gdse.Entity.User;
import lk.ijse.gdse.conversion.Mapping;
import lk.ijse.gdse.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Amil Srinath
 */
@Service
@Transactional
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDAO employeeDAO;
    private final Mapping conversionData;
    private final UserDAO userDAO;

    @Override
    public boolean saveEmployee(EmployeeDTO employeeDTO) {
        Employee employee = conversionData.toEmployee(employeeDTO);
        User user = new User();
        user.setUserId("123");
        user.setEmail("abcdqw@gmail.com");
        user.setPassword("1234");

        userDAO.save(user);

        employee.setUser(user);
        EmployeeDTO savedEmployee = conversionData.toEmployeeDTO(employeeDAO.save(employee));
        return savedEmployee != null;
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return List.of();
    }

    @Override
    public EmployeeDTO getEmployeeById(String id) {
        return null;
    }

    @Override
    public void deleteEmployeeById(String id) {

    }

    @Override
    public void updateEmployeeById(String id, EmployeeDTO employeeDTO) {

    }
}
