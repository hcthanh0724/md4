package com.example.shopeefake.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_invoice;
    private Date invoice_date;
    private String customer_name;
    private String address;
    private double total;
    private String note;

    public Invoice() {
    }

    public Invoice(int id_invoice, Date invoice_date, String customer_name, String address, double total, String note) {
        this.id_invoice = id_invoice;
        this.invoice_date = invoice_date;
        this.customer_name = customer_name;
        this.address = address;
        this.total = total;
        this.note = note;
    }

    public int getId_invoice() {
        return id_invoice;
    }

    public void setId_invoice(int id_invoice) {
        this.id_invoice = id_invoice;
    }

    public Date getInvoice_date() {
        return invoice_date;
    }

    public void setInvoice_date(Date invoice_date) {
        this.invoice_date = invoice_date;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
