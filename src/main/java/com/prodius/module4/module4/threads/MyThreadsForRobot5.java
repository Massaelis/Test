package com.prodius.module4.module4.threads;

import lombok.Getter;
import lombok.SneakyThrows;

import java.util.Random;

@Getter
public class MyThreadsForRobot5 extends Thread {
    private final Random random = new Random();

    private static int details = 0;


    @SneakyThrows
    @Override
    public void run() {
        while (details < 100) {
            int point = 10;
            int fuel = random.nextInt(350, 700);
            MyThreadForFuel.FUELS = MyThreadForFuel.FUELS - fuel;
            if (MyThreadForFuel.FUELS > 0) {
                details = details + point;
                System.out.println(Thread.currentThread().getName());
                System.out.println("Finish details = " + details);
//                System.out.println(fuel);
//                System.out.println(MyThreadForFuel.FUELS);
            } else {
                Thread.sleep(3000);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}