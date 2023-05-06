package com.prodius.module3.lesson16hw.repository;

public abstract class Repository<T> {

    abstract void set(T index, T t);

    abstract void addIndex(T index, T t);

    abstract void add(T t);

    abstract void remove(T value);

    abstract void show();

}