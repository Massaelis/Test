package com.prodius.module4.lesson28hw.CoreThreads;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

public class MyThread implements Runnable {

    private static final Object MONITOR = new Object();
    static List<Integer> integerList = new ArrayList<>();


    MyThread(final List<Integer> list) {
        integerList = list;
    }

    @SneakyThrows
    @Override
    public void run() {
        synchronized (MONITOR) {
            for (int i = 0; i < 20; i++) {
                int integer = (int) Math.round((Math.random() * 1000));
                if (integerList.size() == 100) {
                    break;
                } else if (!integerList.contains(integer)) {
                    integerList.add(integer);
                }
            }
        }
    }
}