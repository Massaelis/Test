package com.prodius.module4.module4.threads;

import com.prodius.module4.module4.model.Details;
import com.prodius.module4.module4.model.FuelTruck;

import java.time.LocalDate;

public class MyThreadStarter {
    final FuelTruck fuelTruck = new FuelTruck();
    long timeWork;

    public void start() throws InterruptedException {

        final Thread robot1 = new MyThreadForFuel(fuelTruck);
        robot1.setDaemon(true);

        long time = System.currentTimeMillis();

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
        robot5.join();

        timeWork = (System.currentTimeMillis() - time) / 1000;
        System.out.println("Time in seconds " + timeWork);
    }

    public Details createDetails() {
        Details details = new Details();

        details.setDate(LocalDate.now());
        details.setTime(timeWork);
        details.setFuel(fuelTruck.getUsedFuel());
        details.setBrokeSchemas(MyThreadForSchema.getBrokeSchemas());

        System.out.println(details);
        return details;
    }
}