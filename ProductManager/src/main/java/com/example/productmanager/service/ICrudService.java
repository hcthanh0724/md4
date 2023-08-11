package com.example.productmanager.service;

import java.util.List;

public interface ICrudService <E>{
    List<E> getAll();
    void save(E e);
    void edit(E e);
    void delete(E e);
}
