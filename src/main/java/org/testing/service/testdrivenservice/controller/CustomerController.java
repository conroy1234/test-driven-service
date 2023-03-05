package org.testing.service.testdrivenservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.testing.service.testdrivenservice.model.Customer;
import org.testing.service.testdrivenservice.service.CustomerService;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/customer")
    public ResponseEntity<List<Customer>> findAll(){
       List<Customer> customers = customerService.findAll();
       return ResponseEntity.ok(customers);
    }

    @GetMapping("/customer/{id}")
    public Optional<Customer> findById(@PathVariable int id){
        return customerService.findById(id);
    }
}
