package org.example.services;

import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface ProductServices <T>{
    T getById(Integer id);
    Collection<T> getAll();
    void create(T item);
    void delete(Integer id);
    void update(T item);
}
