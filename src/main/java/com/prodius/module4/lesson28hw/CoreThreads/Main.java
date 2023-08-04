package com.prodius.module4.lesson28hw.CoreThreads;

import lombok.SneakyThrows;

import java.util.HashSet;
import java.util.Set;

public class Main {
    static Set<Integer> list = new HashSet<>();

    static final CommonResource commonResource = new CommonResource();
    @SneakyThrows
    public static void main(String[] args) {
        myThread(10);

        System.out.println(list);
        System.out.println(list.size());
        System.out.println(commonResource.get());

        final Thread myThreadSum = new Thread(new MyThreadForSum(list));
        myThreadSum.start();
        myThreadSum.join();
    }

    private static void myThread(int thread) throws InterruptedException {
        for (int i = 1; i <= thread; i++) {
            Thread myThreads = new Thread(new MyThread(list, commonResource));
            myThreads.start();
            myThreads.join();
        }
    }
}