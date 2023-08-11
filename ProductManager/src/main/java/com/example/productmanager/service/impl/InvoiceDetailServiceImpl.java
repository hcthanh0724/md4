package com.example.productmanager.service.impl;

import com.example.productmanager.model.InvoiceDetail;
import com.example.productmanager.repository.InterfaceInvoiceDetailRepo;
import com.example.productmanager.repository.InterfaceInvoiceRepo;
import com.example.productmanager.service.ICrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceDetailServiceImpl implements ICrudService<InvoiceDetail> {
    @Autowired
    InterfaceInvoiceDetailRepo interfaceInvoiceDetailRepo;
    @Override

    public List<InvoiceDetail> getAll() {
        return (List<InvoiceDetail>) interfaceInvoiceDetailRepo.findAll();
    }

    @Override
    public void save(InvoiceDetail invoiceDetail) {
        interfaceInvoiceDetailRepo.save(invoiceDetail);
    }

    @Override
    public void edit(InvoiceDetail invoiceDetail) {
        interfaceInvoiceDetailRepo.save(invoiceDetail);
    }

    @Override
    public void delete(InvoiceDetail invoiceDetail) {
        interfaceInvoiceDetailRepo.delete(invoiceDetail);
    }
}
