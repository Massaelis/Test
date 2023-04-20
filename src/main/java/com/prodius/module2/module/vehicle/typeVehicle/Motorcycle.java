package com.prodius.module2.module.vehicle.typeVehicle;

import com.prodius.module2.module.vehicle.Type;
import com.prodius.module2.module.vehicle.Vehicle;

public class Motorcycle extends Vehicle {
    public Motorcycle(int numberOfWheels, String brand, int yearOfIssue, double maxSpeed) {
        super(Type.MOTORCYCLE, numberOfWheels, brand, yearOfIssue, maxSpeed);
    }
//    @Override
//    public void calculateSpeed() {
//        System.out.println("Speed " + getType() + ": " + getMaxSpeed());
//    }

    public String toString() {
        return "Motorcycle {"
                + "Type: " + getType()
                + ", Wheels: " + getNumberOfWheels()
                + ", Brand: " + getBrand()
                + ", Year: " + getYearOfIssue()
                + ", Max speed: " + getMaxSpeed()
                + '}';
    }
}
