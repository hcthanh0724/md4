package com.example.hybernate.service;

import com.example.hybernate.DAO.AccountDAO;
import com.example.hybernate.DAO.RoleDAO;
import com.example.hybernate.model.Account;
import com.example.hybernate.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.NoResultException;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class AccountService {
    @Autowired
    AccountDAO accountDAO;
    @Autowired
    RoleDAO roleDAO;

    public void save(Account account, int id_role, MultipartFile imgFile){
        String nameFile = imgFile.getOriginalFilename();

        try {
            imgFile.transferTo(new File("D:\\module 4\\hybernate\\src\\main\\webapp\\WEB-INF\\img\\"+nameFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        account.setAvatar(nameFile);
        Role role = roleDAO.findById(id_role);
        account.setRole(role);
        accountDAO.save(account);
    }
    public void updateAccount(Account account){
        accountDAO.edit(account);
    }

    public List<Account> getAll(){
        return accountDAO.getAll();
    }


public Account findAccount(Account account){
    for (Account a: accountDAO.getAll()) {
        if(a.getName().equals(account.getName()) && a.getPassword().equals(account.getPassword())){
            return a;
        }
    }
    return null;
}
}
