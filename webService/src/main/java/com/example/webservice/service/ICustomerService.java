package com.example.webservice.service;

import com.example.webservice.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> showAll();
    void create(Customer customer);
    void update(Customer customer);
    void delete(int id);
}
