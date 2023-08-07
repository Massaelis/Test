package com.prodius.module4.lesson28hw.CoreThreads;

import lombok.SneakyThrows;

import java.util.*;

public class Main {
    static List<Integer> integerList = new ArrayList<>();
    static List<Thread> threads = new ArrayList<>();
    static List<Thread> threadsForSum = new ArrayList<>();

    @SneakyThrows
    public static void main(String[] args) {
        myThread(10);

        threads.forEach(thread1 -> {
            try {
                thread1.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        final Thread myThreadSum = new Thread(new MyThreadForSumPoint(integerList));
        myThreadSum.start();
        myThreadSum.join();

        myThreadForSum(4);

        threadsForSum.forEach(thread1 -> {
            try {
                thread1.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        System.out.println("All sum: " + MyThreadForSum.threadSum);
    }

    private static void myThread(int thread) throws InterruptedException {
        for (int i = 1; i <= thread; i++) {
            Thread myThreads = new Thread(new MyThread(integerList));
            threads.add(myThreads);
            myThreads.start();
        }
    }

    private static void myThreadForSum(int thread) throws InterruptedException {
        for (int i = 1; i <= thread; i++) {
            Thread myThreads = new Thread(new MyThreadForSum(integerList));
            threadsForSum.add(myThreads);
            myThreads.start();
        }
    }
}