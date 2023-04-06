package com.prodius.module2.lesson6hw2.transport;

import lombok.Getter;

@Getter
public abstract class Transport {
    private final String brand;
    private final String model;
    private final int year;

    protected Transport(String brand, String model, int year){
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    public abstract void startEngine();

    public abstract void stopEngine();

}
