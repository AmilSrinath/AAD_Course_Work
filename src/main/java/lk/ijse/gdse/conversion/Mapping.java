package lk.ijse.gdse.conversion;

import lk.ijse.gdse.DTO.*;
import lk.ijse.gdse.Entity.*;
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

    //--------------------------------------Customer--------------------------------------
    public CustomerDTO toCustomerDTO(Customer customer) {
        return  mapper.map(customer, CustomerDTO.class);
    }

    public Customer toCustomer(CustomerDTO customerDTO) {
        return  mapper.map(customerDTO, Customer.class);
    }

    public List<CustomerDTO> getCustomerDTOList(List<Customer> customers) {
        return mapper.map(customers, List.class);
    }

    //--------------------------------------Supplier--------------------------------------
    public SupplierDTO toSupplierDTO(Supplier supplier) {
        return  mapper.map(supplier, SupplierDTO.class);
    }

    public Supplier toSupplier(SupplierDTO supplierDTO) {
        return  mapper.map(supplierDTO, Supplier.class);
    }

    public List<SupplierDTO> getSupplierDTOList(List<Supplier> suppliers) {
        return mapper.map(suppliers, List.class);
    }

    //--------------------------------------Inventory--------------------------------------
    public InventoryDTO toInventoryDTO(Inventory inventory) {
        return  mapper.map(inventory, InventoryDTO.class);
    }

    public Inventory toInventory(InventoryDTO inventoryDTO) {
        return  mapper.map(inventoryDTO, Inventory.class);
    }

    public List<InventoryDTO> getInventoryDTOList(List<Inventory> inventorys) {
        return mapper.map(inventorys, List.class);
    }
}
