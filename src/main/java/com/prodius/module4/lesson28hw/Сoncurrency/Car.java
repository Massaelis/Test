package com.prodius.module4.lesson28hw.Сoncurrency;

import java.util.concurrent.Semaphore;

public class Car implements Runnable {
    private static final int parkingPlace = 4;
    protected static final boolean[] PARKING_PLACES = new boolean[parkingPlace];

    protected static final Semaphore SEMAPHORE = new Semaphore(parkingPlace, true);
    private int carNumber;

    public Car(int carNumber) {
        this.carNumber = carNumber;
    }

    @Override
    public void run() {
        System.out.println("Car " + carNumber + " near parking");
        try {
            SEMAPHORE.acquire();

            int parkingNumber = -1;

            synchronized (PARKING_PLACES) {
                for (int i = 0; i < PARKING_PLACES.length; i++)
                    if (!PARKING_PLACES[i]) {
                        PARKING_PLACES[i] = true;
                        parkingNumber = i;
                        System.out.println("Car " + carNumber + " parked on place number " + i);
                        break;
                    }
            }
            Thread.sleep(2000);

            synchronized (PARKING_PLACES) {
                PARKING_PLACES[parkingNumber] = false;
            }
            SEMAPHORE.release();
            System.out.println("Car " + carNumber + " left the parking lot.");
        } catch (InterruptedException e) {
        }
    }
}