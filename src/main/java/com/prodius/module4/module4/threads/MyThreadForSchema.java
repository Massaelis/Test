package com.prodius.module4.module4.threads;

import lombok.Getter;

import java.util.Random;

@Getter
public class MyThreadForSchema extends Thread {
    private final Random random = new Random();

    private int schemas;

    @Override
    public void run() {
        while (schemas < 100) {
            int brokePercent = random.nextInt(0, 100);
            if (brokePercent > 30) {
                schemas += random.nextInt(25, 35);
                System.out.println(Thread.currentThread().getName() + " schemas = " + schemas);
            } else {
                schemas = 0;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}