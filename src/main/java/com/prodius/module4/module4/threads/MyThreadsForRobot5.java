package com.prodius.module4.module4.threads;

import com.prodius.module4.module4.model.FuelTruck;
import lombok.Getter;
import lombok.SneakyThrows;

import java.util.Random;

@Getter
public class MyThreadsForRobot5 extends Thread {
    private final Random random = new Random();

    private int details = 0;

    private final FuelTruck fuelTruck;

    MyThreadsForRobot5(final FuelTruck fuelTruck) {
        this.fuelTruck = fuelTruck;
    }

    @SneakyThrows
    @Override
    public void run() {
        while (details < 100) {
            int point = 10;
            final int fuel = fuelTruck.getFuel();
            if (fuel > 0) {
                details = details + point;
                System.out.println(Thread.currentThread().getName() + " Finish details = " + details);
            } else {
                Thread.yield();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}