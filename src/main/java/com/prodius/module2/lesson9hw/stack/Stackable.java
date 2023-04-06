package com.prodius.module2.lesson9hw.stack;

public interface Stackable<E> {
    void push(E item);

    E pop();

    E peek();

    boolean isEmpty();
}
