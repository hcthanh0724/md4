package com.example.hybernate.DAO;

import com.example.hybernate.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@Component
public class RoleDAO {
    @Autowired
    EntityManager entityManager;
    public Role findById(int id){
        String queryStr ="SELECT r FROM Role r where r.id = : id";
        TypedQuery<Role> query = entityManager.createQuery(queryStr, Role.class).setParameter("id",id);
        return query.getSingleResult();
    }
}
