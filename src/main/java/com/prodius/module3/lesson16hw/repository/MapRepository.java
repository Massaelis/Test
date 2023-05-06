package com.prodius.module3.lesson16hw.repository;

import com.prodius.module3.lesson16hw.annotation.Singleton;

import java.util.HashMap;
import java.util.Map;

@Singleton
public class MapRepository<K, V> extends Repository<V, K> {
    private final Map<K, V> map = new HashMap<>();

    @Override
    public void set(K key, V o) {
        map.put(key, o);
    }

    @Override
    public void addIndex(K key, V o) {
        map.put(key, o);
    }

    @Override
    public void add(V o) {
        throw new UnsupportedOperationException("Map doesn't support adding");
    }

    @Override
    public void remove(V value) {
        map.entrySet().removeIf(kvEntry -> kvEntry.getValue().equals(value));
    }

    @Override
    public void show() {
        System.out.println(map);
    }
}