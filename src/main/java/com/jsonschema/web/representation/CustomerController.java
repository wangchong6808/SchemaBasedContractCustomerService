package com.jsonschema.web.representation;

import com.jsonschema.annotation.JsonSchema;
import com.jsonschema.web.domain.CustomerService;
import com.jsonschema.web.dto.Customer;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/customers")
    @JsonSchema(inputSchema = "1001", outputSchema = "1002")
    public Customer createCustomer(@RequestParam("firstName") String firstName, @RequestBody Customer customer) {
        customer.setMobile(String.valueOf(Math.random()));
        customer.setFirstName(firstName);
        return customer;
    }

    @GetMapping("/customers/{id}")
    @JsonSchema(outputSchema = "1002")
    public Customer getCustomer(@PathVariable("id") int id) {
        return customerService.getCustomer(id);
    }
}
