package com.example.webservice.controller;

import com.example.webservice.model.Customer;
import com.example.webservice.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    ICustomerService iCustomerService;
    @GetMapping("/customer")
    public List<Customer> getAllCustomer(){
        return iCustomerService.showAll();
    }
    @PostMapping("/create")
    public void create(@RequestBody Customer customer){
        iCustomerService.create(customer);
    }
    @GetMapping("/edit")
    public void edit(@RequestBody Customer customer){
        iCustomerService.update(customer);
    }
    @GetMapping("/delete")
    public void delete(@RequestParam int id){
        iCustomerService.delete(id);
    }
}
