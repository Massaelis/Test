package com.prodius.module4.lesson28;

import lombok.SneakyThrows;

import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class PhaserExample {
    public static void main(String[] args) {
        final Phaser phaser = new Phaser(1);
        System.out.println("Start all threads");
        new Thread(new MyThread5(phaser)).start();
        new Thread(new MyThread5(phaser)).start();
        new Thread(new MyThread5(phaser)).start();

        int phase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Phase " + phase + " finished!");

        phase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Phase " + phase + " finished!");

        phase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Phase " + phase + " finished!");

        phaser.arriveAndDeregister();
        if (phaser.isTerminated()) {
            System.out.println("Phaser is closed");
        }
    }
}

class MyThread5 implements Runnable {
    private final Phaser phaser;

    MyThread5(final Phaser phaser) {
        this.phaser = phaser;
        phaser.register();
    }

    @SneakyThrows
    @Override
    public void run() {
        final String name = Thread.currentThread().getName();
        System.out.println("Thread " + name + " is starting first phase");
        phaser.arriveAndAwaitAdvance();
        TimeUnit.SECONDS.sleep(10);

        System.out.println("Thread " + name + " is starting second phase");
        phaser.arriveAndAwaitAdvance();
        TimeUnit.SECONDS.sleep(10);

        System.out.println("Thread " + name + " is starting 3 phase");
        TimeUnit.SECONDS.sleep(10);
        phaser.arriveAndDeregister();
        TimeUnit.SECONDS.sleep(2);
    }
}