package com.example.demospringboot.repository;

import com.example.demospringboot.model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IProductRepo extends PagingAndSortingRepository<Product,Integer> {
}
