package org.testing.service.testdrivenservice.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.testing.service.testdrivenservice.model.Customer;
import org.testing.service.testdrivenservice.repository.CustomerRepository;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HttpApiTest {

    @LocalServerPort
    private int port;

    @Autowired
    TestRestTemplate restTemplate;
    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void findByIdTest(){
        assertThat(restTemplate.getForObject("http://localhost:"+port+"/customer/1",String.class)).contains("CONROY");
    }

    @Test
    public void findAllTest(){
        restTemplate.getForObject("http://localhost:"+port+"/customer",String.class).contains("LOUISE");
    }

    @Test
    public void createCustomerTest(){
        Customer customer = new Customer(20,"Steven","Louding");
       restTemplate.postForObject("http://localhost:"+port+"/customer",customer,Customer.class);
    }
}