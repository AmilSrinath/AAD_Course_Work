package lk.ijse.gdse.Controller;

import lk.ijse.gdse.DTO.CustomerDTO;
import lk.ijse.gdse.Exception.NotFoundException;
import lk.ijse.gdse.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * @author Amil Srinath
 */
@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("/health")
    public String healthCheck() {
        return "OK";
    }

    @PostMapping("/save")
    public boolean save(@RequestBody CustomerDTO customerDTO) {
        customerDTO.setCustomer_id(UUID.randomUUID().toString());
        return customerService.saveCustomer(customerDTO);
    }

    @GetMapping(produces = "application/json")
    public List<CustomerDTO> findAll() {
        return customerService.getAllCustomers();
    }

    @PutMapping("/update")
    public boolean update(@RequestBody CustomerDTO customerDTO) throws NotFoundException {
        return customerService.updateCustomerById(customerDTO.getCustomer_id(), customerDTO);
    }

    @DeleteMapping("/delete")
    public boolean delete(@RequestPart("customer_id") String id) throws NotFoundException {
        return customerService.deleteCustomerById(id);
    }
}
