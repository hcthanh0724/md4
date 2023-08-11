package com.example.shopeefake.model;

import javax.persistence.*;

@Entity
public class Product {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id_Product;
private String name_product;
private double price;
private String img;
@Column(length = 2000)
private String content;

    public Product() {
    }

    public Product(int id_Product, String name_product, double price, String img, String content) {
        this.id_Product = id_Product;
        this.name_product = name_product;
        this.price = price;
        this.img = img;
        this.content = content;
    }

    public int getId_Product() {
        return id_Product;
    }

    public void setId_Product(int id_Product) {
        this.id_Product = id_Product;
    }

    public String getName_product() {
        return name_product;
    }

    public void setName_product(String name_product) {
        this.name_product = name_product;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
