package com.prodius.module3.lesson20hw.repository;


import java.util.Set;

public interface Crud<T, K> {
    void save(T value);

    default T getById(K id) {
        throw new UnsupportedOperationException("Not supported");
    }

    Set<T> getAll();

    default void delete(K id) {
        throw new UnsupportedOperationException("Not supported");
    }

}
