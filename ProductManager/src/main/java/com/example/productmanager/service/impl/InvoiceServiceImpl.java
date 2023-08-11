package com.example.productmanager.service.impl;

import com.example.productmanager.model.Invoice;
import com.example.productmanager.repository.InterfaceInvoiceRepo;
import com.example.productmanager.service.ICrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InvoiceServiceImpl implements ICrudService<Invoice> {
    @Autowired
    InterfaceInvoiceRepo interfaceInvoiceRepo;

    @Override
    public List<Invoice> getAll() {
        return (List<Invoice>) interfaceInvoiceRepo.findAll();
    }

    @Override
    public void save(Invoice invoice) {
        interfaceInvoiceRepo.save(invoice);
    }

    @Override
    public void edit(Invoice invoice) {
        interfaceInvoiceRepo.save(invoice);
    }

    @Override
    public void delete(Invoice invoice) {
        interfaceInvoiceRepo.delete(invoice);
    }
}
