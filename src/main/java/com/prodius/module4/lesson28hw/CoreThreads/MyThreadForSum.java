package com.prodius.module4.lesson28hw.CoreThreads;

import lombok.SneakyThrows;

import java.util.Set;

public class MyThreadForSum implements Runnable {
    private final Set<Integer> list;

    MyThreadForSum(final Set<Integer> list) {
        this.list = list;

    }

    @SneakyThrows
    @Override
    public void run() {
        int sum = 0;
        for (int integer : list) {
            sum += integer;
        }
        System.out.println("All sum: " + sum);
    }
}