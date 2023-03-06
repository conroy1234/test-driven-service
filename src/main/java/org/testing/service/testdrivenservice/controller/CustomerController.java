package org.testing.service.testdrivenservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.testing.service.testdrivenservice.exception.CustomerException;
import org.testing.service.testdrivenservice.model.Customer;
import org.testing.service.testdrivenservice.service.CustomerService;

import java.net.URI;
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
      Optional<Customer> customer = customerService.findById(id);
      if(customer.isEmpty()){
          throw new CustomerException("customer not found");
      }
      return customer;
    }

    @PostMapping("/customer")
    public ResponseEntity<Customer> save(@RequestBody Customer customer){
       Customer customers = customerService.save(customer);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(customer.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

}
