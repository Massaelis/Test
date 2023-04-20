package com.prodius.module2.module;

import com.prodius.module2.module.transportUtil.TransportFileReader;
import com.prodius.module2.module.vehicle.*;
import com.prodius.module2.module.vehicle.typeVehicle.Bicycle;
import com.prodius.module2.module.vehicle.typeVehicle.Car;
import com.prodius.module2.module.vehicle.typeVehicle.Motorcycle;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Vehicle> transportList = new ArrayList<>();
        Vehicle vehicle = new Vehicle();
        Car car = new Car(4, "Subaru", 2017, 250);
        car.move();
        car.calculateSpeed();

        Car car2 = new Car(4, "Audi", 2017, 280);

        Bicycle bicycle = new Bicycle(2, "Local", 2020, 40);
        bicycle.move();
        bicycle.calculateSpeed();

        Motorcycle motorcycle = new Motorcycle(2, "Loncine", 2021, 180);
        motorcycle.move();
        motorcycle.calculateSpeed();

        vehicle.addTransport(car, transportList);
        vehicle.addTransport(car2, transportList);
        vehicle.addTransport(motorcycle, transportList);
        vehicle.addTransport(bicycle, transportList);

        vehicle.removeTransport(car2, transportList);

        System.out.println("~".repeat(10) + "Get Transport List" + "~".repeat(10));
        vehicle.getTransportList(transportList);

        System.out.println("~".repeat(10) + "Sort by Brand" + "~".repeat(10));
        vehicle.sortTransportByBrand(transportList);

        System.out.println("~".repeat(10) + "Sort by Year" + "~".repeat(10));
        vehicle.sortTransportByYear(transportList);

        System.out.println("~".repeat(10) + "Sort by MaxSpeed" + "~".repeat(10));
        vehicle.sortTransportByMaxSpeed(transportList);

        System.out.println("~".repeat(10) + "Filter by MaxSpeed" + "~".repeat(10));
        vehicle.filterTransportByMaxSpeed(180, transportList);

        TransportFileReader.saveVehicleToFile(transportList);

        System.out.println("~".repeat(10) + "Read from file" + "~".repeat(10));
        TransportFileReader.readeVehicleFromFile();
    }
}
