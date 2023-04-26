package com.prodius.module2.module.vehicle;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Vehicle extends Transport implements Movable{
    private final String brand;
    private final int yearOfIssue;
    private final double maxSpeed;

    protected Vehicle(final Type type, final int numberOfWheels, final String brand,
                      final int yearOfIssue, final double maxSpeed) {
        super(type, numberOfWheels);
        this.brand = brand;
        this.yearOfIssue = yearOfIssue;
        this.maxSpeed = maxSpeed;
    }

    @Override
    public void move() {
        System.out.println("Start moving: " + getType());
    }

    @Override
    public void calculateSpeed() {
        System.out.println("Speed " + getType() + ": " + getMaxSpeed());
    }
}