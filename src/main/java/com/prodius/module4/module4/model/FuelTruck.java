package com.prodius.module4.module4.model;

import lombok.Getter;

import java.util.Random;

public class FuelTruck {
    private final Random random = new Random();
    private int fuel;
    @Getter
    private int usedFuel;

    public void addFuel(final int count) {
        fuel = fuel + count;
    }

    public int getInfo() {
        return fuel;
    }

    public int getFuel() {
        int fuels = random.nextInt(350, 700);
        fuel = fuel - fuels;
        usedFuel = usedFuel + fuels;
        return fuel;
    }
}
