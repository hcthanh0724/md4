package com.example.webservice.service;

import com.example.webservice.model.Customer;
import com.example.webservice.repository.ICustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService{
    @Autowired
    ICustomerRepo iCustomerRepo;

    @Override
    public List<Customer> showAll() {
        return (List<Customer>) iCustomerRepo.findAll();
    }

    @Override
    public void create(Customer customer) {
        iCustomerRepo.save(customer);
    }

    @Override
    public void update(Customer customer) {
        iCustomerRepo.save(customer);
    }

    @Override
    public void delete(int id) {
        iCustomerRepo.deleteById(id);
    }
}
