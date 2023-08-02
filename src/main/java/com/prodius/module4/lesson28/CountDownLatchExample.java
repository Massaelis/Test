package com.prodius.module4.lesson28;

import lombok.SneakyThrows;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchExample {

    public static void main(String[] args) {
//        singleThreadExample();
        multiThreadsExample();
    }

    @SneakyThrows
    private static void multiThreadsExample() {
        final CountDownLatch latch = new CountDownLatch(3);
        new Thread(new MyThread22(latch)).start();
        new Thread(new MyThread22(latch)).start();
        new Thread(new MyThread22(latch)).start();
        System.out.println("Main waiting");
        final boolean awaited = latch.await(35, TimeUnit.SECONDS);
        if (awaited) {
            System.out.println("Everything is fine");
        } else {
            System.out.println("Something wrong");
        }
        System.out.println("Main continue");
    }

    @SneakyThrows
    private static void singleThreadExample() {
        final CountDownLatch latch = new CountDownLatch(5);
        new Thread(new MyThread2(latch)).start();
        System.out.println("Main waiting");
        latch.await();
        System.out.println("Main continue");
    }
}

class MyThread2 implements Runnable {
    private final CountDownLatch latch;

    MyThread2(final CountDownLatch latch) {
        this.latch = latch;
    }

    @SneakyThrows
    @Override
    public void run() {
        final String name = Thread.currentThread().getName();
        for (int i = 0; i < 5; i++) {
            System.out.println(name + ": " + i);
            TimeUnit.SECONDS.sleep(1);
            latch.countDown();
        }

        for (int i = 5; i < 10; i++) {
            System.out.println(name + ": " + i);
            TimeUnit.SECONDS.sleep(1);
        }
    }
}

class MyThread22 implements Runnable {
    private final CountDownLatch latch;

    private final Random random = new Random();

    MyThread22(final CountDownLatch latch) {
        this.latch = latch;
    }

    @SneakyThrows
    @Override
    public void run() {
        final String name = Thread.currentThread().getName();
        final int i1 = random.nextInt(30);

        System.out.println(name + " will be slipping for " + i1);
        TimeUnit.SECONDS.sleep(i1);
        System.out.println(name + " countDown");
        latch.countDown();
    }
}