package com.prodius.module3.lesson16hw.repository;

import com.prodius.module3.lesson16hw.annotation.Singleton;

import java.util.HashMap;
import java.util.Map;


@Singleton
public class MapRepository<K, V> extends Repository {
    Map<K, V> map = new HashMap<>();


    @Override
    public void set(Object key, Object o) {

    }

    @Override
    public void addIndex(Object key, Object o) {
        map.put((K) key, (V) o);
    }

    @Override
    public void add(Object o) {
        System.out.println("used another method");
    }

    @Override
    public void remove(Object key) {
        map.remove(key);
    }

    @Override
    public void show() {
        System.out.println(map);
    }
}