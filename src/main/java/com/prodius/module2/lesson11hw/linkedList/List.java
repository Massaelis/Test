package com.prodius.module2.lesson11hw.linkedList;

public interface List<T> {
    void addFirst(T value);

    void addLast(T value);

    void set(int index, T t);

    void add(int index, T t);

    void remove(T value);

    int indexOf(T value);
}
