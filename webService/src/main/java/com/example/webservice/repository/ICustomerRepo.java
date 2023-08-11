package com.example.webservice.repository;

import com.example.webservice.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface ICustomerRepo extends CrudRepository<Customer,Integer> {
}
