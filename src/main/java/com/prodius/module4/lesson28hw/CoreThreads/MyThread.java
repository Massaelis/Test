package com.prodius.module4.lesson28hw.CoreThreads;

import lombok.SneakyThrows;

import java.util.List;
import java.util.Random;

public class MyThread extends Thread {

    private static final Object MONITOR = new Object();

    private final List<Integer> integerList;

    private final Random random = new Random();


    MyThread(final List<Integer> list) {
        integerList = list;
    }

    @SneakyThrows
    @Override
    public void run() {
        int count = 0;
        do {
            synchronized (MONITOR) {
                int integer = random.nextInt(10000);
                if (!integerList.contains(integer)) {
                    integerList.add(integer);
                    count++;
                    System.out.println(Thread.currentThread().getName() + " add number: " + integer);
                }
            }
        } while (count < 100);
    }
}