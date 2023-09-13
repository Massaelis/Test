package com.prodius.module4.module4.threads;

import com.prodius.module4.module4.model.FuelTruck;

public class MyThreadStarter {
    public void start() throws InterruptedException {
        final FuelTruck fuelTruck = new FuelTruck();
        final Thread robot1 = new MyThreadForFuel(fuelTruck);
        robot1.setDaemon(true);
        robot1.start();

        final Thread robot2 = new MyThreadsForDetails();
        final Thread robot3 = new MyThreadsForDetails();
        robot2.start();
        robot3.start();
        robot2.join();
        robot3.join();

        final Thread robot4 = new MyThreadForSchema();
        robot4.start();
        robot4.join();

        final Thread robot5 = new MyThreadsForRobot5(fuelTruck);
        robot5.start();
    }
}
