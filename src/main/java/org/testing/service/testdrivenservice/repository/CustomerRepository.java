package org.testing.service.testdrivenservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.testing.service.testdrivenservice.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer,Integer> {
}
