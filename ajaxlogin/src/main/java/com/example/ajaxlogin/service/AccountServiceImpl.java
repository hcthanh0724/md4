package com.example.ajaxlogin.service;

import com.example.ajaxlogin.model.Account;
import com.example.ajaxlogin.repo.IAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements IAccountService {
    @Autowired
    IAccountRepo iAccountRepo;


    @Override
    public List<Account> selectAll() {
        return (List<Account>) iAccountRepo.findAll();
    }

    @Override
    public void create(Account account) {
        iAccountRepo.save(account);
    }
    public Account login(String username,String password){
        return iAccountRepo.getAccount(username,password);
    }

    @Override
    public Optional<Account> findOne(int id) {
        return iAccountRepo.findById(id);
    }

    @Override
    public void edit(Account account) {
        iAccountRepo.save(account);
    }

    @Override
    public void delete(int id) {
        iAccountRepo.deleteById(id);
    }
}
