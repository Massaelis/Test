package com.prodius.module4.lesson28hw.CoreThreads;

import lombok.Getter;
import lombok.SneakyThrows;

import java.util.List;

@Getter
public class MyThreadForSum extends Thread {

    private final List<Integer> integerList;

    private int threadSum;

    MyThreadForSum(final List<Integer> list) {
        integerList = list;

    }

    @SneakyThrows
    @Override
    public void run() {
        for (int integer : integerList) {
            threadSum += integer;
        }
    }
}