package org.testing.service.testdrivenservice.data;

import org.testing.service.testdrivenservice.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerDataSource {
    public static List<Customer> customers = new ArrayList<>();

    static{
       customers.add(new Customer(1,"Conroy","Dagenham")) ;
       customers.add(new Customer(2,"Stephen","Luton"));
       customers.add(new Customer(3,"Alvin","new york"));
    }

}
