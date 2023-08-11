package com.example.shopeefake.service;

import com.example.shopeefake.DAO.ProductDAO;
import com.example.shopeefake.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductDAO productDAO;
    public List<Product> showProduct(){
       return productDAO.getAll();
    }
    public void addProduct(Product product, MultipartFile imgFile){
        String nameFile = imgFile.getOriginalFilename();

        try{
            imgFile.transferTo(new File("D:\\module 4\\ShopeeFake\\src\\main\\webapp\\img\\" +nameFile));
        }
        catch (IOException e){
            e.printStackTrace();
        }
        product.setImg(nameFile);
        productDAO.addProduct(product);
    }
    public void editProduct(Product product, MultipartFile imgFile){
        String nameFile = imgFile.getOriginalFilename();
        try{
            imgFile.transferTo(new File("D:\\module 4\\ShopeeFake\\src\\main\\webapp\\img\\" +nameFile));
        }
        catch (IOException e){
            e.printStackTrace();
        }
        product.setImg("img\\" +nameFile);
        productDAO.editProduct(product);
    }
    public void deleteProduct(int id_product){
        Product product = productDAO.findById(id_product);
        productDAO.deleteProduct(product);
    }
}
