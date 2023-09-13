package com.prodius.module4.module4.threads;

import lombok.Getter;

import java.util.Random;

@Getter
public class MyThreadForSchema extends Thread {
    private final Random random = new Random();
    private static int schemas;

    @Override
    public void run() {
        while (schemas < 101) {
            int point = random.nextInt(25, 35);
            int brokeProcent = random.nextInt(0, 100);
            if (brokeProcent > 30) {
                schemas = schemas + point;
                System.out.println(Thread.currentThread().getName());
                System.out.println("schemas = " + schemas);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}