package com.example.productmanager.service.impl;

import com.example.productmanager.model.Product;
import com.example.productmanager.repository.InterfaceProductRepo;
import com.example.productmanager.service.ICrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ICrudService<Product> {
@Autowired
    InterfaceProductRepo interfaceProductRepo;
    @Override
    public List<Product> getAll() {
        return (List<Product>) interfaceProductRepo.findAll();
    }
    public Page<Product> getAll(Pageable pageable) {
        return interfaceProductRepo.findAll(pageable);
    }

    @Override
    public void save(Product product) {
        interfaceProductRepo.save(product);
    }

    @Override
    public void edit(Product product) {
        interfaceProductRepo.save(product);
    }

    @Override
    public void delete(Product product) {
        interfaceProductRepo.deleteById(product.getId());
    }
    public Product findById(int id){
        return interfaceProductRepo.findById(id).get();
    }
}
