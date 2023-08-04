package com.prodius.module4.lesson28hw.CoreThreads;

import lombok.SneakyThrows;

import java.util.Set;

public class MyThread implements Runnable {

    private final Set<Integer> list;

    private final CommonResource commonResourse;

    MyThread(final Set<Integer> list, final CommonResource commonResourse) {
        this.list = list;
        this.commonResourse = commonResourse;
    }

    @SneakyThrows
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            int integer = (int) Math.round((Math.random() * 1000));
            list.add(integer);
            commonResourse.incrise();
        }
    }
}