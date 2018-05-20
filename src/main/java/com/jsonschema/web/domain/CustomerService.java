package com.jsonschema.web.domain;

import com.jsonschema.web.dto.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    public Customer getCustomer(Integer id) {
        return Customer.builder().id(id).mobile("123").firstName("Tom").lastName("Smith").build();
    }
}
