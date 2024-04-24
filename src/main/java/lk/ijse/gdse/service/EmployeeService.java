package lk.ijse.gdse.service;

import lk.ijse.gdse.DTO.EmployeeDTO;

import java.util.List;

/**
 * @author Amil Srinath
 */
public interface EmployeeService {
    boolean saveEmployee(EmployeeDTO employeeDTO, String password);
    List<EmployeeDTO> getAllEmployees();
    EmployeeDTO getEmployeeById(String id);
    boolean deleteEmployeeById(String email);
    boolean updateEmployeeById(String id, EmployeeDTO employeeDTO, String password);
}
