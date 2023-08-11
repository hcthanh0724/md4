package com.example.demospringboot.controller;

import com.example.demospringboot.model.Product;
import com.example.demospringboot.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/products")
public class ProductController {
    @Autowired
    IProductService iProductService;

    @GetMapping
    public ResponseEntity<Page<Product>> getAll(@RequestParam(defaultValue = "0")int page){
        Page<Product> productPage = iProductService.getAll(PageRequest.of(page,2));
        return new ResponseEntity<>(productPage, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Product> save(@RequestBody Product product){
        iProductService.save(product);
        return new ResponseEntity<>(product,HttpStatus.OK);
    }
}
