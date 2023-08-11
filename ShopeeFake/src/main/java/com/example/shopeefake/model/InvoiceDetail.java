package com.example.shopeefake.model;

import javax.persistence.*;

@Entity
public class InvoiceDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_detail;
    private int id_product;
    private int id_invoice;
    private int quantity;
    @ManyToOne
    private Product product;
    @ManyToOne
    private Invoice invoice;

    public InvoiceDetail() {
    }

    public InvoiceDetail(int id_detail, int id_product, int id_invoice, int quantity, Product product, Invoice invoice) {
        this.id_detail = id_detail;
        this.id_product = id_product;
        this.id_invoice = id_invoice;
        this.quantity = quantity;
        this.product = product;
        this.invoice = invoice;
    }

    public int getId_detail() {
        return id_detail;
    }

    public void setId_detail(int id_detail) {
        this.id_detail = id_detail;
    }

    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    public int getId_invoice() {
        return id_invoice;
    }

    public void setId_invoice(int id_invoice) {
        this.id_invoice = id_invoice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
}
