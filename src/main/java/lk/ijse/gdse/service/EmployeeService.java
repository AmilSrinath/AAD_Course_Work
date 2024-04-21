package lk.ijse.gdse.service;

import lk.ijse.gdse.DTO.EmployeeDTO;

import java.util.List;

/**
 * @author Amil Srinath
 */
public interface EmployeeService {
    EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);
    List<EmployeeDTO> getAllEmployees();
    EmployeeDTO getEmployeeById(String id);
    void deleteEmployeeById(String id);
    void updateEmployeeById(String id, EmployeeDTO employeeDTO);
}
