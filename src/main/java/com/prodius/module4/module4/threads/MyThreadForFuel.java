package com.prodius.module4.module4.threads;

import lombok.Getter;

import java.util.Random;

@Getter
public class MyThreadForFuel extends Thread {

    private final Random random = new Random();

    public static int FUELS;

    private boolean doStop = false;

    public synchronized void doStop() {
        this.doStop = true;
    }

    private synchronized boolean keepRunning() {
        return this.doStop == false;
    }

    @Override
    public void run() {
        while (keepRunning()) {
            int fuel = random.nextInt(500, 1000);
            FUELS += fuel;
            System.out.println(Thread.currentThread().getName());
            System.out.println("Fuels = " + FUELS + " l");
            try {
                Thread.sleep(3 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}