package lk.ijse.gdse.service;

import lk.ijse.gdse.DTO.CustomerDTO;
import lk.ijse.gdse.Exception.NotFoundException;

import java.util.List;

/**
 * @author Amil Srinath
 */
public interface CustomerService {
    boolean saveCustomer(CustomerDTO customerDTO);
    List<CustomerDTO> getAllCustomers();
    boolean deleteCustomerByEmail(String id) throws NotFoundException;
    boolean updateCustomerById(String id, CustomerDTO CustomerDTO) throws NotFoundException;
    CustomerDTO getSelectCustomer(String email) throws NotFoundException;
}
