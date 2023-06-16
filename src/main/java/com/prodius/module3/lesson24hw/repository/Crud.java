package com.prodius.module3.lesson24hw.repository;

public interface Crud<T,O> {
    void create(O object);
    void read();
    void updateOfName(T before, T after);
    void deleteOfName(T value);

}