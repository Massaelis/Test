package com.prodius.module2.module.vehicle.typeVehicle;

import com.prodius.module2.module.vehicle.Type;
import com.prodius.module2.module.vehicle.Vehicle;

public class Bicycle extends Vehicle {

    public Bicycle(final int numberOfWheels, final String brand, final int yearOfIssue, final double maxSpeed) {
        super(Type.BICYCLE, numberOfWheels, brand, yearOfIssue, maxSpeed);
    }

    @Override
    public void calculateSpeed() {
        System.out.println("Speed " + getType() + ": " + getMaxSpeed() + " or low");
    }

    public String toString() {
        return "Bicycle {"
                + "Type: " + getType()
                + ", Wheels: " + getNumberOfWheels()
                + ", Brand: " + getBrand()
                + ", Year: " + getYearOfIssue()
                + ", Max speed: " + getMaxSpeed()
                + '}';
    }
}
