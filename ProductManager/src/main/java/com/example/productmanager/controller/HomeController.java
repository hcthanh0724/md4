package com.example.productmanager.controller;

import com.example.productmanager.model.Product;
import com.example.productmanager.service.impl.InvoiceDetailServiceImpl;
import com.example.productmanager.service.impl.InvoiceServiceImpl;
import com.example.productmanager.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @Autowired
    ProductServiceImpl productService;
    @Autowired
    InvoiceServiceImpl invoiceService;
    @Autowired
    InvoiceDetailServiceImpl invoiceDetailService;
    @GetMapping("/home")
    public ModelAndView showHome(@RequestParam(defaultValue = "0")int page){
        ModelAndView modelAndView = new ModelAndView("index");
        Page<Product> products = productService.getAll(PageRequest.of(page,3));
        modelAndView.addObject("product",products);
        return modelAndView;
    }
    @GetMapping("/detail")
    public String showDetail(@RequestParam int id, Model model){
        Product product = productService.findById(id);
        model.addAttribute("product",product);
        return "detail";
    }
//    @GetMapping("/store")
//    public ModelAndView showStore(@RequestParam(defaultValue ="0") int page, Model model){
//        ModelAndView modelAndView = new ModelAndView("store");
//        Page<Product> products = productService.showAll(PageRequest.of(page,4));
//        modelAndView.addObject("store",products);
//        return modelAndView;
//    }
}
