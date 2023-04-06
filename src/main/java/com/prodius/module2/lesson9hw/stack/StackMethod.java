package com.prodius.module2.lesson9hw.stack;

import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Array;

@Getter
@Setter
public class StackMethod<E> implements Stackable<E> {

    private int capacity;

    private E[] arr;

    private int head;

    @SuppressWarnings("unchecked")
    public StackMethod(Class<E> clazz, int capacity) {
        arr = (E[]) Array.newInstance(clazz, capacity);
    }

    //добавляет элемент на вершину стека;
    @Override
    public void push(E item) {
        if (isFull()) {
            System.out.println("Stack is full");
            return;
        }
        arr[++head] = item;
    }

    //удаляет и возвращает элемент с вершины стека;
    @Override
    public E pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }
        return arr[head--];
    }

    //возвращает элемент с вершины стека, не удаляя его;
    @Override
    public E peek() {
        return arr[head];
    }

    //возвращает true, если стек пустой;
    @Override
    public boolean isEmpty() {
        return head == -1;
    }

    //возвращает true, если стек заполнен;
    public boolean isFull() {
        return head == capacity - 1;
    }

    //возвращает количество элементов в стеке.
    public int size() {
        return head + 1;
    }
}

