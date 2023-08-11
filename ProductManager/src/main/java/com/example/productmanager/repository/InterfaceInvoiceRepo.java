package com.example.productmanager.repository;

import com.example.productmanager.model.Invoice;
import org.springframework.data.repository.CrudRepository;

public interface InterfaceInvoiceRepo extends CrudRepository<Invoice,Integer> {
}
