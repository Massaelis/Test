package com.prodius.module3.lesson25hw.action;

public interface Command<T> {
    void execute();
    void execute(T value);
}