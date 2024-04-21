package lk.ijse.gdse.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.gdse.DTO.EmployeeDTO;
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
    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        return null;
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
