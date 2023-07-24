package com.prodius.module4.lesson28;

import lombok.SneakyThrows;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class CyclicBarrierExample {
    @SneakyThrows
    public static void main(String[] args) {
        final CyclicBarrier barrier = new CyclicBarrier(3, () -> System.out.println("BINGO!"));
        new Thread(new MyThread3(barrier)).start();
        new Thread(new MyThread3(barrier)).start();
        new Thread(new MyThread3(barrier)).start();
    }
}

class MyThread3 implements Runnable {

    private final CyclicBarrier barrier;

    private final Random random = new Random();

    MyThread3(final CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    @SneakyThrows
    @Override
    public void run() {
        final String name = Thread.currentThread().getName();
        final int i1 = random.nextInt(30);

        System.out.println(name + " will be slipping for " + i1);
        TimeUnit.SECONDS.sleep(i1);
        System.out.println(name + " barrier");
        barrier.await();

        final int i2 = random.nextInt(10);
        System.out.println(name + " generate " + i2);
    }
}