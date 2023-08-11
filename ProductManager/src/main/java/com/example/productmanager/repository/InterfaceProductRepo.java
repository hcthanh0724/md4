package com.example.productmanager.repository;

import com.example.productmanager.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface InterfaceProductRepo extends PagingAndSortingRepository<Product,Integer> {

}
