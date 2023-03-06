package org.testing.service.testdrivenservice.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.testing.service.testdrivenservice.model.Customer;
import org.testing.service.testdrivenservice.service.CustomerService;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@RunWith(SpringRunner.class)
@WebMvcTest
public class CustomerControllerTest {

    @Autowired
    MockMvc mockMvc;
    @MockBean
    CustomerService customerService;

    @Test
    public void findByIdTest() throws Exception {
        when(customerService.findById(anyInt())).thenReturn(Optional.of(new Customer(1,"Conroy","Dagenham")));
        mockMvc.perform(get("/customer/2"))
                .andDo(print())
                .andExpect( jsonPath("id").exists())
                .andExpect( jsonPath("name").value("Conroy"))
                .andExpect(( jsonPath("address").value("Dagenham")))
                .andReturn();
    }


    @Test
    public void findAll() throws Exception {
        List<Customer> findAll = List.of(new Customer(1,"Conroy","Dagenham"),
                new Customer(2,"Stephen","Luton"),
                new Customer(3,"Delroy White","Leicester"));
        when(customerService.findAll()).thenReturn(findAll);
        mockMvc.perform(get("/customer"))
                .andDo(print())
                .andReturn();
    }



}