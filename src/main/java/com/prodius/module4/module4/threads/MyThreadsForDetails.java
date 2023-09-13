package com.prodius.module4.module4.threads;

import lombok.Getter;
import lombok.SneakyThrows;

import java.util.Random;

@Getter
public class MyThreadsForDetails extends Thread {
    private static final Object MONITOR = new Object();
    private final Random random = new Random();
    private static int iterationsCount = 0;
    public static int details;

    public MyThreadsForDetails(final int detail) {
        details = detail;
    }

    @SneakyThrows
    @Override
    public void run() {
        while (details < 101) {
            synchronized (MONITOR) {
                int point = random.nextInt(10, 20);
                details = details + point;
                System.out.println(Thread.currentThread().getName());
                System.out.println("Basic details = " + details);
                iterationsCount++;
//                System.out.println("iterationsCount = " + iterationsCount);
                try {
                    Thread.sleep(2 * 1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}