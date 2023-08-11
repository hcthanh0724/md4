package com.example.ajaxlogin.repo;

import com.example.ajaxlogin.model.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface IAccountRepo extends CrudRepository<Account,Integer> {
    @Query(value = "select a from Account a where a.username =:u and a.password=:p")
    Account getAccount(@Param("u")String username,@Param("p")String password);
}
