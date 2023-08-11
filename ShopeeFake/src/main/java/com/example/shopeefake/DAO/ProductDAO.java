package com.example.shopeefake.DAO;

import com.example.shopeefake.model.Product;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class ProductDAO {
    @PersistenceContext
    EntityManager entityManager;
    public List<Product> getAll(){
        String queryStr = "SELECT p FROM Product p";
        TypedQuery<Product> query = entityManager.createQuery(queryStr, Product.class);
        return query.getResultList();
    }
    public Product findById(int id_product){
        return entityManager.find(Product.class,id_product);
    }

    public void addProduct(Product product) {
        entityManager.persist(product);
    }
    public void editProduct(Product product){
        entityManager.merge(product);
    }
    public void deleteProduct(Product product){
        entityManager.remove(product);
    }
}
