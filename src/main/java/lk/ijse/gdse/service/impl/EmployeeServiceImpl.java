package lk.ijse.gdse.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.gdse.DAO.EmployeeDAO;
import lk.ijse.gdse.DAO.UserDAO;
import lk.ijse.gdse.DTO.EmployeeDTO;
import lk.ijse.gdse.Entity.Employee;
import lk.ijse.gdse.Entity.User;
import lk.ijse.gdse.conversion.Mapping;
import lk.ijse.gdse.reqAndresp.secure.SignUp;
import lk.ijse.gdse.service.AuthenticationService;
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
    private final AuthenticationService authenticationService;

    @Override
    public boolean saveEmployee(EmployeeDTO employeeDTO, String password) {
        Employee employee = conversionData.toEmployee(employeeDTO);
        EmployeeDTO savedEmployee = conversionData.toEmployeeDTO(employeeDAO.save(employee));

        SignUp signUp = new SignUp();
        signUp.setEmail(employeeDTO.getEmail());
        signUp.setPassword(password);
        signUp.setRole(String.valueOf(employeeDTO.getRole()));

        authenticationService.signUp(signUp, employeeDTO);

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
