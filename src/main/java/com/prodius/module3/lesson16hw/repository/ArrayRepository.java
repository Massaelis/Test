package com.prodius.module3.lesson16hw.repository;

import com.prodius.module3.lesson16hw.annotation.Singleton;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class ArrayRepository<T> extends Repository {
    List<T> list = new ArrayList<>();

    @Override
    public void set(Object index, Object o) {
        list.set((Integer) index, (T) o);
    }

    @Override
    public void addIndex(Object index, Object o) {
        list.add((Integer) index, (T) o);
    }

    @Override
    public void add(Object o) {
        list.add((T) o);
    }

    @Override
    public void remove(Object value) {
        list.remove(value);
    }

    @Override
    public void show() {
        System.out.println(list);
    }
}