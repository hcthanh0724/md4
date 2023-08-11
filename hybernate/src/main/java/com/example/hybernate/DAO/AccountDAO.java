package com.example.hybernate.DAO;

import com.example.hybernate.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class AccountDAO {
    @PersistenceContext
    EntityManager entityManager;
    public List<Account> getAll(){
        String queryStr = "SELECT a FROM Account a";
        TypedQuery<Account> query = entityManager.createQuery(queryStr, Account.class);
        return (List<Account>) query.getResultList();
    }
    public Account findById(int id){
        String queryStr = "SELECT a FROM Account a where a.id = :id";
        TypedQuery<Account> query = entityManager.createQuery(queryStr, Account.class).setParameter("id",id);
        return query.getSingleResult();
    }
    public void save(Account account){
        entityManager.merge(account);

    }
    public void edit(Account account){
        entityManager.merge(account);
    }
    public void delete(Account account){
        EntityTransaction txn = entityManager.getTransaction();
        txn.begin();
        entityManager.remove(account);
        txn.commit();
    }
    public Account findAccount(String name,String password){
        String queryStr ="Select a From Account a where a.name = :name AND a.password = :password";
        TypedQuery<Account> query = entityManager.createQuery(queryStr, Account.class)
                .setParameter("name",name)
                .setParameter("password",password);
        return query.getSingleResult();
    }
}
