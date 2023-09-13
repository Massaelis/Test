package com.prodius.module4.module4.threads;

import lombok.Getter;
import lombok.SneakyThrows;

import java.util.Random;

@Getter
public class MyThreadsForDetails extends Thread {
    private static final Object MONITOR = new Object();
    private final Random random = new Random();

    private static int details = 0;

    @SneakyThrows
    @Override
    public void run() {
        while (details < 100) {
            synchronized (MONITOR) {
                details += random.nextInt(10, 20);
                System.out.println(Thread.currentThread().getName() + " Basic details = " + details);
                try {
                    Thread.sleep(2 * 1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}