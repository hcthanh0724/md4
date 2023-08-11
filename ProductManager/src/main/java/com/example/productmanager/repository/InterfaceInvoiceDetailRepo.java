package com.example.productmanager.repository;

import com.example.productmanager.model.InvoiceDetail;
import org.springframework.data.repository.CrudRepository;

public interface InterfaceInvoiceDetailRepo extends CrudRepository<InvoiceDetail,Integer> {
}
