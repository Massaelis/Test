package com.prodius.module4.lesson28hw.CoreThreads;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

public class MyThreadStarter {
    public void start() {
        final List<Integer> integers = firstPart(10);
        secondPart(integers);
    }

    @SneakyThrows
    private void secondPart(final List<Integer> integers) {
        final List<MyThreadForSum> threads = new ArrayList<>();
        for (int i = 0; i < 4; i++) {

            int start = 5 * 5 * i;
            int end = 5 * 5 * (i + 1);

            final List<Integer> sunList = integers.subList(start, end);

            MyThreadForSum myThreads = new MyThreadForSum(sunList);
            threads.add(myThreads);
            myThreads.start();
        }

        int sum = 0;
        for (MyThreadForSum thread : threads) {
            thread.join();
            sum += thread.getThreadSum();
            System.out.println(thread.getName() + " : " + thread.getThreadSum());
        }

        System.out.println("All sum: " + sum);
    }

    private List<Integer> firstPart(int thread) {
        final List<Thread> threads = new ArrayList<>();
        final List<Integer> integerList = new ArrayList<>();
        for (int i = 1; i <= thread; i++) {
            Thread myThreads = new MyThread(integerList);
            threads.add(myThreads);
            myThreads.start();
        }

        threads.forEach(thread1 -> {
            try {
                thread1.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        System.out.println(integerList.size());
        return integerList;
    }
}
