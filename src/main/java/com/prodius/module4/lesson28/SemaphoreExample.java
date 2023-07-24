package com.prodius.module4.lesson28;

import lombok.Getter;
import lombok.SneakyThrows;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreExample {
    public static void main(String[] args) {
        final Semaphore semaphore = new Semaphore(1);
        final CommonResource commonResource = new CommonResource();
        new Thread(new MyThread1(commonResource, semaphore)).start();
        new Thread(new MyThread1(commonResource, semaphore)).start();
        new Thread(new MyThread1(commonResource, semaphore)).start();
    }
}

class MyThread1 implements Runnable {

    private final CommonResource resource;

    private final Semaphore semaphore;

    MyThread1(final CommonResource resource, final Semaphore semaphore) {
        this.resource = resource;
        this.semaphore = semaphore;
    }

    @SneakyThrows
    @Override
    public void run() {
        final String name = Thread.currentThread().getName();
        System.out.println(name + " starting...");
        semaphore.acquire();

        for (int i = 0; i < 30; i++) {
            resource.increase();
            System.out.println(name + " resource " + resource.getNumber());
            TimeUnit.MILLISECONDS.sleep(10);
        }
        semaphore.release();
    }
}

@Getter
class CommonResource {
    private int number = 0;

    public void increase() {
        number++;
    }
}