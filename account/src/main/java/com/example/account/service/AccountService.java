package com.example.account.service;

import com.example.account.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {
    List<Account> accounts;

    public AccountService() {
        accounts = new ArrayList<>();
        accounts.add(new Account(1,"datphit69","djphatt6969","https://camstreams.tv/contents/videos_screenshots/502000/502759/preview.jpg"));
        accounts.add(new Account(2,"tungsmile09","smiley09","https://i.ebayimg.com/images/g/lJ0AAOSwsHxjxeZV/s-l1600.jpg"));
        accounts.add(new Account(3,"totle","totle555","https://xxxbios.com/wp-content/uploads/2022/11/kagney-e1669766167285.jpg"));
        accounts.add(new Account(4,"omatase","omataseshimashita","https://images2.thanhnien.vn/uploaded/tuyenth/2020_06_15/8_IIQF.jpg?width=500"));
    }
    public List<Account> showList(){
        return accounts;
    }
    public void addAccount(Account account){
        accounts.add(account);
    }
    public Account findById(int id){
        for (Account account: accounts){
            if(account.getId() == id){
                return account;
            }
        }
        return null;
    }
    public void edit(int id,Account account){
        accounts.set(id,account);
    }
    public void delete(int id){
        accounts.remove(id);
    }
}
