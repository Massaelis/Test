package com.prodius.module4.lesson27;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        atomicInteger.incrementAndGet();

        List<Integer> list = new ArrayList<>();
        list.add(0);
        final CommonResource commonResource = new CommonResource();

        final Thread myThread31 = new Thread(new MyThread3(list, commonResource));
        final Thread myThread32 = new Thread(new MyThread3(list, commonResource));
        myThread31.start();
        myThread32.start();

        myThread31.join();
        myThread32.join();
        System.out.println(list.get(0));
        System.out.println(commonResource.get());

//        myThread31.start();
    }

    @SneakyThrows
    private static void interruptThreads() {
        final Thread thread = new Thread(new MyThread2());

        thread.start();
//        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();
    }

    @SneakyThrows
    private static void joinThreads() {
        System.out.println("Before start thread");
        final Thread thread = new Thread(new MyThread2());

        thread.start();

        thread.join(30 * 1000);

        System.out.println("After start thread");
    }

    private static void createThreads() {
        System.out.println(Thread.currentThread().getName());
        final Thread myThread1 = new MyThread();
        myThread1.start();
        myThread1.stop();
        new Thread(new MyThread2()).start();

        Runnable myThread3 = () -> System.out.println(Thread.currentThread().getName());
        new Thread(myThread3).start();
    }
}

class MyThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class MyThread2 implements Runnable {
    @SneakyThrows
    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            System.out.println(Thread.currentThread().isInterrupted());
            System.out.println(Thread.interrupted());
        }
    }
}

class MyThread3 implements Runnable {

    private final List<Integer> list;

    private final CommonResource commonResource;

    MyThread3(final List<Integer> list, final CommonResource commonResource) {
        this.list = list;
        this.commonResource = commonResource;
    }

    @SneakyThrows
    @Override
    public void run() {
        for (int i = 0; i < 10_000; i++) {
            int integer = list.get(0);
            integer += 1;
            list.set(0, integer);

            commonResource.incrise();
        }
    }
}

class CommonResource {
    private static final Object MONITOR = new Object();

    private final List<Integer> list = new ArrayList<>();

    CommonResource() {
        list.add(0);
    }

    public static synchronized void incrise5() {
        // TODO: 19/07/23
    }

    public synchronized void incrise() {
        int integer = list.get(0);
        integer += 1;
        list.set(0, integer);
    }

    public void incrise2() {
        int integer = list.get(0);
        synchronized (this) {
            integer += 1;
            list.set(0, integer);
        }
    }

    public void incrise3() {
        int integer = list.get(0);
        synchronized (MONITOR) {
            integer += 1;
            list.set(0, integer);
        }
    }

    public void incrise4() {
        int integer = list.get(0);
        synchronized (CommonResource.class) {
            integer += 1;
            list.set(0, integer);
        }
    }

    Integer get() {
        return list.get(0);
    }
}