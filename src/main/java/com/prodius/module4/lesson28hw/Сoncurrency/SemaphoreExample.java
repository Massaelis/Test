package com.prodius.module4.lesson28hw.Сoncurrency;

public class SemaphoreExample {
    public static void main(String[] args) throws InterruptedException {
        example(7);
    }

    private static void example(int cars) throws InterruptedException {
        for (int i = 1; i <= cars; i++) {
            new Thread(new Car(i)).start();
            Thread.sleep(200);
        }
    }
}