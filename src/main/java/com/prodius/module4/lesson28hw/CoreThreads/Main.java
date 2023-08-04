package com.prodius.module4.lesson28hw.CoreThreads;

import lombok.SneakyThrows;

import java.util.HashSet;
import java.util.Set;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {

        Set<Integer> list = new HashSet<>();
        list.add(0);
        final CommonResource commonResource = new CommonResource();

        final Thread myThread1 = new Thread(new MyThread(list, commonResource));
        final Thread myThread2 = new Thread(new MyThread(list, commonResource));
        final Thread myThread3 = new Thread(new MyThread(list, commonResource));
        final Thread myThread4 = new Thread(new MyThread(list, commonResource));
        final Thread myThread5 = new Thread(new MyThread(list, commonResource));
        final Thread myThread6 = new Thread(new MyThread(list, commonResource));
        final Thread myThread7 = new Thread(new MyThread(list, commonResource));
        final Thread myThread8 = new Thread(new MyThread(list, commonResource));
        final Thread myThread9 = new Thread(new MyThread(list, commonResource));
        final Thread myThread10 = new Thread(new MyThread(list, commonResource));

        myThread1.start();
        myThread2.start();
        myThread3.start();
        myThread4.start();
        myThread5.start();
        myThread6.start();
        myThread7.start();
        myThread8.start();
        myThread9.start();
        myThread10.start();


        myThread1.join();
        myThread2.join();
        myThread3.join();
        myThread4.join();
        myThread5.join();
        myThread6.join();
        myThread7.join();
        myThread8.join();
        myThread9.join();
        myThread10.join();

        System.out.println(list);
        System.out.println(list.size());
        System.out.println(commonResource.get());

        final Thread myThreadSum = new Thread(new MyThreadForSum(list));
        myThreadSum.start();
        myThreadSum.join();
    }
}