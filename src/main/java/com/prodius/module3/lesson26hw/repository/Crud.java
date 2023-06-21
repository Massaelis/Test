package com.prodius.module3.lesson26hw.repository;

public interface Crud<T, O, I> {
    void create(O object);

    void read();

    void updateNameOfId(T before, T after);

    void updateAgeOfId(T before, I after);

    void deleteOfId(T value);
}