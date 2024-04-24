package lk.ijse.gdse.service;

import lk.ijse.gdse.DTO.CustomerDTO;

import java.util.List;

/**
 * @author Amil Srinath
 */
public interface CustomerService {
    boolean saveCustomer(CustomerDTO customerDTO);
    List<CustomerDTO> getAllCustomers();
    boolean deleteCustomerById(String id);
    boolean updateCustomerById(String id, CustomerDTO CustomerDTO);
}
