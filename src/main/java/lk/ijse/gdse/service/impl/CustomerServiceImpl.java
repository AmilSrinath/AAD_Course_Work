package lk.ijse.gdse.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.gdse.DAO.CustomerDAO;
import lk.ijse.gdse.DTO.CustomerDTO;
import lk.ijse.gdse.Entity.Customer;
import lk.ijse.gdse.conversion.Mapping;
import lk.ijse.gdse.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Amil Srinath
 */
@Service
@Transactional
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private CustomerDAO customerDAO;
    private final Mapping conversionData;

    @Override
    public boolean saveCustomer(CustomerDTO customerDTO) {
        customerDAO.save(conversionData.toCustomer(customerDTO));
        return true;
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return List.of();
    }

    @Override
    public boolean deleteCustomerById(String id) {
        return false;
    }

    @Override
    public boolean updateCustomerById(String id, CustomerDTO CustomerDTO) {
        return false;
    }
}
