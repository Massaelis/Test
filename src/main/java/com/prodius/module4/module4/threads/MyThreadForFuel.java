package com.prodius.module4.module4.threads;

import com.prodius.module4.module4.model.FuelTruck;
import lombok.Getter;

import java.util.Random;

@Getter
public class MyThreadForFuel extends Thread {

    private final Random random = new Random();

    private final FuelTruck fuelTruck;

    MyThreadForFuel(final FuelTruck fuelTruck) {
        this.fuelTruck = fuelTruck;
    }

    @Override
    public void run() {
        while (true) {
            fuelTruck.addFuel(random.nextInt(500, 1000));
            System.out.println(Thread.currentThread().getName() + " Fuels = " + fuelTruck.getInfo() + " l");
            try {
                Thread.sleep(3 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}