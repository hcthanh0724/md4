package com.example.demojwt.controller;

import com.example.demojwt.model.Account;
import com.example.demojwt.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountControllerAPI {
    @Autowired
    IAccountService iAccountService;
    @PostMapping("/register")
    public Account register(@RequestBody Account account){
        return account;
    }
    @GetMapping
    public List<Account> getAll(){
        return iAccountService.getAll();
    }
    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }
    @GetMapping("/user")
    public String user(){
        return "user";
    }
}
