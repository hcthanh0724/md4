package com.example.demospringboot.service;

import com.example.demospringboot.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    Page<Product> getAll(Pageable pageable);
    void save(Product product);
    void delete(int id);
    void edit(Product product);
    Product findById(int id);
}
