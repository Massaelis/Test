package com.prodius.module3.lesson24hw.repository;

public interface Crud<T> {
    void create();
    void read();
    void updateOfName(T before, T after);
    void deleteOfName(T value);

}