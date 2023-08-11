package com.example.shopeefake.controller;

import com.example.shopeefake.DAO.ProductDAO;
import com.example.shopeefake.model.Product;
import com.example.shopeefake.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    ProductDAO productDAO;
    @GetMapping("/home")
    public String showHome(Model model){
        model.addAttribute("product",productService.showProduct());
        return "vegetables";
    }
    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("product",new Product());
        return "create";
    }
    @PostMapping("/create")
    public String create(@ModelAttribute Product product,@RequestParam MultipartFile imgFile) {
        productService.addProduct(product,imgFile);
        return "redirect:/home";
    }
    @GetMapping("/edit/{id}")
    public String showEdit(Model model,@PathVariable int id){
        Product product = productDAO.findById(id);
        model.addAttribute("product",product);
        return "edit";
    }
    @PostMapping("/edit/{id}")
    public String editProduct(@PathVariable int id, @ModelAttribute Product product, MultipartFile imgFile){
        product.setId_Product(id);
        productService.editProduct(product, imgFile);
        return "redirect:/home";
    }
}
