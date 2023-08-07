package com.prodius.module4.lesson28hw.CoreThreads;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

public class MyThreadForSumPoint implements Runnable {
    static List<Integer> integerList = new ArrayList<>();

    MyThreadForSumPoint(final List<Integer> list) {
        integerList = list;

    }

    @SneakyThrows
    @Override
    public void run() {
        int sum = 0;
        for (int integer : integerList) {
            sum++;
        }
        System.out.println("Sum points: " + sum);
    }
}