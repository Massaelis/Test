package com.prodius.module4.lesson28hw.CoreThreads;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

public class MyThreadForSum implements Runnable {
    private static final Object MONITOR = new Object();
    static List<Integer> integerList = new ArrayList<>();
    static int threadSum;

    MyThreadForSum(final List<Integer> list) {
        integerList = list;

    }

    @SneakyThrows
    @Override
    public void run() {
        synchronized (MONITOR) {
            int sum = 0;
            for (int integer : integerList) {
                sum += integer;
            }
            threadSum = sum;
        }
    }
}