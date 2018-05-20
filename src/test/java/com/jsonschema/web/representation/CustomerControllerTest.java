package com.jsonschema.web.representation;

import com.jsonschema.CustomerApplication;
import com.jsonschema.web.domain.CustomerService;
import com.jsonschema.web.dto.Customer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@EnableAspectJAutoProxy
@ComponentScan(basePackageClasses={CustomerApplication.class})
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    CustomerService customerService;

    @Test
    void should_return_400() throws Exception {
        Mockito.when(customerService.getCustomer(10)).thenReturn(Customer.builder().id(10).build());
        this.mockMvc.perform(get("/customers/10"))
                .andExpect(status().is(400));
    }

    @Test
    void should_return_200_with_customer() throws Exception {
        Mockito.when(customerService.getCustomer(Mockito.anyInt())).thenCallRealMethod();
        this.mockMvc.perform(get("/customers/100"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("100"))
                .andReturn().getResponse().getContentAsString();
    }

}
