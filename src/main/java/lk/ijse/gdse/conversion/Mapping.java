package lk.ijse.gdse.conversion;

import lk.ijse.gdse.DTO.EmployeeDTO;
import lk.ijse.gdse.DTO.UserDTO;
import lk.ijse.gdse.Entity.Employee;
import lk.ijse.gdse.Entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Amil Srinath
 */
@Component
public class Mapping {
    final private ModelMapper mapper;

    public Mapping(ModelMapper mapper) {
        this.mapper = mapper;
    }

    //--------------------------------------User--------------------------------------
    public UserDTO toUserDTO(User user) {
        return  mapper.map(user, UserDTO.class);
    }
    public User toUser(UserDTO userDTO) {
        return  mapper.map(userDTO, User.class);
    }

    //--------------------------------------Employee--------------------------------------
    public EmployeeDTO toEmployeeDTO(Employee employee) {
        return  mapper.map(employee, EmployeeDTO.class);
    }

    public Employee toEmployee(EmployeeDTO employeeDTO) {
        return  mapper.map(employeeDTO, Employee.class);
    }

    public List<EmployeeDTO> getEmployeeDTOList(List<Employee> employees) {
        return mapper.map(employees, List.class);
    }
}
