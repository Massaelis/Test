package com.prodius.module3.lesson20hw.repository;


import java.util.Set;

public interface Crud<T, K> {
    void save(T value);

//    T getById(K id);

    Set<T> getAll();

//    void delete(K id);

}
