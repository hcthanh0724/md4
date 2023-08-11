package com.example.demojwt.repository;

import com.example.demojwt.model.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface IAccountRepo extends CrudRepository<Account,Integer> {
    @Query(nativeQuery = true,value = "select * from Account where username= :username and password= :password")
    Account getAccountLogin(@Param("username")String username,@Param("password")String password);
    Account getAccountByUsername(String username);
}
