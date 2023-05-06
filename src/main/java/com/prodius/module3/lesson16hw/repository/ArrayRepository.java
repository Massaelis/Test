package com.prodius.module3.lesson16hw.repository;

import com.prodius.module3.lesson16hw.annotation.Singleton;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class ArrayRepository<T> extends Repository<T, Integer> {
    private final List<T> list = new ArrayList<>();

    @Override
    public void set(Integer index, T o) {
        list.set(index, o);
    }

    @Override
    public void addIndex(Integer index, T o) {
        list.add(index, o);
    }

    @Override
    public void add(T o) {
        list.add(o);
    }

    @Override
    public void remove(T value) {
        list.remove(value);
    }

    @Override
    public void show() {
        System.out.println(list);
    }
}