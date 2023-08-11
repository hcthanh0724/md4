package com.example.ajaxlogin.controller;

import com.example.ajaxlogin.model.Account;
import com.example.ajaxlogin.service.AccountServiceImpl;
import com.example.ajaxlogin.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/signIn")
public class AccountController {
    @Autowired
    IAccountService iAccountService;
    @Autowired
    AccountServiceImpl accountService;
    @GetMapping("")
    public List<Account> getAll(){
        return iAccountService.selectAll();
    }
    @PostMapping("")
    public void createAccount(@RequestBody Account account){
        iAccountService.create(account);
    }
    @GetMapping("/check")
    public ResponseEntity<Account> checkAccount(@RequestBody Account  account){
        Account account1 = accountService.login(account.getUsername(), account.getPassword());
//        Optional<Account> accountOptional = iAccountService.findOne(account.getId());
        if (account1 != null){
            return new ResponseEntity<>(account1, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }
    @PutMapping("")
    public void edit(@RequestBody Account account){
        iAccountService.edit(account);
    }

    @DeleteMapping("")
    public void delete(@RequestParam int id){
        iAccountService.delete(id);
    }
}
