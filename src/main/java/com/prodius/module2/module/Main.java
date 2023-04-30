package com.prodius.module2.module;

import com.prodius.module2.module.transportUtil.TransportFileReader;
import com.prodius.module2.module.transportUtil.TransportManager;
import com.prodius.module2.module.vehicle.typeVehicle.Bicycle;
import com.prodius.module2.module.vehicle.typeVehicle.Car;
import com.prodius.module2.module.vehicle.typeVehicle.Motorcycle;

public class Main {
    public static void main(String[] args) {
        TransportManager transportManager = new TransportManager();
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

        transportManager.addTransport(car);
        transportManager.addTransport(car2);
        transportManager.addTransport(motorcycle);
        transportManager.addTransport(bicycle);

        transportManager.removeTransport(car2);

        System.out.println("~".repeat(10) + "Get Transport List" + "~".repeat(10));
        transportManager.getTransportList();

        System.out.println("~".repeat(10) + "Sort by Brand" + "~".repeat(10));
        transportManager.sortTransportByBrand();

        System.out.println("~".repeat(10) + "Sort by Year" + "~".repeat(10));
        transportManager.sortTransportByYear();

        System.out.println("~".repeat(10) + "Sort by MaxSpeed" + "~".repeat(10));
        transportManager.sortTransportByMaxSpeed();

        System.out.println("~".repeat(10) + "Filter by MaxSpeed" + "~".repeat(10));
        transportManager.filterTransportByMaxSpeed(180);

        TransportFileReader.saveVehicleToFile(transportManager.getTransportList());

        System.out.println("~".repeat(10) + "Read from file" + "~".repeat(10));
        TransportFileReader.readeVehicleFromFile();

        System.out.println("~".repeat(10) + "Find transport by brand" + "~".repeat(10));
        transportManager.findTransportByBrand("Subaru");
    }
}
