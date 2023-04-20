package com.prodius.module2.module.vehicle.typeVehicle;

import com.prodius.module2.module.vehicle.Type;
import com.prodius.module2.module.vehicle.Vehicle;

public class Car extends Vehicle {

    public Car(int numberOfWheels, String brand, int yearOfIssue, double maxSpeed) {
        super(Type.CAR, numberOfWheels, brand, yearOfIssue, maxSpeed);
    }

//    @Override
//    public void calculateSpeed() {
//        System.out.println("Speed " + getType() + ": " + getMaxSpeed());
//    }

    public String toString() {
        return "Car {"
                + "Type: " + getType()
                + ", Wheels: " + getNumberOfWheels()
                + ", Brand: " + getBrand()
                + ", Year: " + getYearOfIssue()
                + ", Max speed: " + getMaxSpeed()
                + '}';
    }
}
