package org.testing.service.testdrivenservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.testing.service.testdrivenservice.model.Customer;
import org.testing.service.testdrivenservice.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> findAll(){
        return (List<Customer>) customerRepository.findAll();
    }

    public  Optional<Customer> findById(int id){
        return customerRepository.findById(id);
    }
    public Customer save(Customer customer){
        return customerRepository.save(customer);
    }

    public void delete(Customer customer){
        customerRepository.delete(customer);
    }

    public Customer update(Customer customer){
        Customer entity = new Customer(customer.getId(),customer.getName(),customer.getAddress());
        return save(entity);
    }
}
