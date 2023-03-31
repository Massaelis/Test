package com.prodius.lesson11hw.linkedList;

public interface List<T> {
    void addFirst( T value);

    void addLast(T value);

    void set(int index, T t);

    void remove(T value);

    int get(T value);
}
