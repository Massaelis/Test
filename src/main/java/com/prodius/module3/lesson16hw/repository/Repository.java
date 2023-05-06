package com.prodius.module3.lesson16hw.repository;

public abstract class Repository<T, I> {

    public abstract void set(I index, T t);

    public abstract void addIndex(I index, T t);

    public abstract void add(T t);

    public abstract void remove(T value);

    public abstract void show();

}