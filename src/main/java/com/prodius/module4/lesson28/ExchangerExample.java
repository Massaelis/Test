package com.prodius.module4.lesson28;

import lombok.SneakyThrows;

import java.util.Random;
import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

public class ExchangerExample {
    public static void main(String[] args) {
        final Exchanger<String> exchanger = new Exchanger<>();
        new Thread(new MyThread41(exchanger)).start();
        new Thread(new MyThread42(exchanger)).start();
    }
}

class MyThread41 implements Runnable {
    private final Exchanger<String> exchanger;

    private final Random random = new Random();

    MyThread41(final Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    @SneakyThrows
    @Override
    public void run() {
        final String name = Thread.currentThread().getName();
        String line = "";
        char ch = 'A';
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                line += ch++;
            }
            final int i1 = random.nextInt(5);
            TimeUnit.SECONDS.sleep(i1);
            System.out.println(name + " start exchange");
            final String exchange = exchanger.exchange(line);
            System.out.println(name + " '" + exchange + "'");
        }
    }
}

class MyThread42 implements Runnable {
    private final Exchanger<String> exchanger;

    private final Random random = new Random();

    MyThread42(final Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    @SneakyThrows
    @Override
    public void run() {
        final String name = Thread.currentThread().getName();
        for (int i = 0; i < 5; i++) {
            final int i1 = random.nextInt(5);
            TimeUnit.SECONDS.sleep(i1);
            System.out.println(name + " start exchange");
            final String exchange = exchanger.exchange(null);
            System.out.println(name + " '" + exchange + "'");
        }
    }
}
