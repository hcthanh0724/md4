package com.example.ajaxlogin.service;

import com.example.ajaxlogin.model.Account;

import java.util.List;
import java.util.Optional;

public interface IAccountService {
    List<Account> selectAll();
    void create(Account account);
    Account login(String username, String password);
    Optional<Account> findOne(int id);

    void edit(Account account);
    void delete(int id);
}
