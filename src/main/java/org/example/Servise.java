package org.example;

import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface Servise <T>{
    T getById(Integer id);
    Collection<T> getAll();
    void create(T item);
    void update(Integer id, T item);
    void delete(Integer id);
    T getByPhone(String number);
    T getByEmail(String email);
}
