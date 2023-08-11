package com.example.demojwt.service;

import com.example.demojwt.model.Account;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IAccountService extends UserDetailsService {
    Account getAccountLogin(String username,String password);
    List<Account> getAll();
}
