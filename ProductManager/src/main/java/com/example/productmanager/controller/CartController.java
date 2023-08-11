package com.example.productmanager.controller;

import com.example.productmanager.model.Invoice;
import com.example.productmanager.model.InvoiceDetail;
import com.example.productmanager.model.Product;
import com.example.productmanager.service.impl.InvoiceDetailServiceImpl;
import com.example.productmanager.service.impl.InvoiceServiceImpl;
import com.example.productmanager.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    HttpSession httpSession;
    @Autowired
    ProductServiceImpl productService;
    @Autowired
    InvoiceServiceImpl invoiceService;
    @Autowired
    InvoiceDetailServiceImpl invoiceDetailService;
    @GetMapping("/showCart")
    public ModelAndView showCart() {
        ModelAndView modelAndView = new ModelAndView("cart");
        List<Product> products = (List<Product>) httpSession.getAttribute("products");
        modelAndView.addObject("products", products);
        modelAndView.addObject("total", httpSession.getAttribute("total"));
        return modelAndView;
    }
    @GetMapping("/addCart")
    public String addCart(@RequestParam int id){
        Product product = productService.findById(id);
        product.setQuantity(1);
        List<Product> products = (List<Product>) httpSession.getAttribute("products");
        if(products == null){
            products = new ArrayList<>();
        }
        boolean check = false;
        double total = 0;
        //kiểm tra nếu sp thêm vào đã tồn tại, tăng số lượng thêm 1
        for (Product p: products) {
            if(p.getId() == id){
                check = true;
                p.setQuantity(p.getQuantity()+1);
            }
            total += (p.getPrice() * p.getQuantity());
        }
        if(!check){
            products.add(product);
            total += (product.getPrice() * product.getQuantity());
        }
        httpSession.setAttribute("products",products);
        httpSession.setAttribute("total",total);
        return "redirect:/cart/showCart";
    }

    @GetMapping("/pay")
    public String pay() {
        List<Product> products = (List<Product>) httpSession.getAttribute("products");
        if (products != null) {
            double total = (double) httpSession.getAttribute("total");
            Invoice hoaDon = new Invoice(0, new Date(System.currentTimeMillis()), total);
            invoiceService.save(hoaDon);
            for (Product p : products) {
                InvoiceDetail hoaDonChiTiet = new InvoiceDetail(0, p.getQuantity(), p, hoaDon);
                invoiceDetailService.save(hoaDonChiTiet);
                Product product = productService.findById(p.getId());
                product.setQuantity(product.getQuantity() - p.getQuantity());
                productService.edit(product);
            }
            httpSession.setAttribute("products", null);
        }
        return "redirect:/home";
    }

}
