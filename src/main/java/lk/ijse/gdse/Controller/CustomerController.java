package lk.ijse.gdse.Controller;

import lk.ijse.gdse.DTO.CustomerDTO;
import lk.ijse.gdse.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
}
