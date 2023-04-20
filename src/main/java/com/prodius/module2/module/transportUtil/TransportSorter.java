package com.prodius.module2.module.transportUtil;

import com.prodius.module2.module.vehicle.Vehicle;

import java.util.Comparator;
import java.util.List;

public class TransportSorter {

    public static void sortByBrand(List<Vehicle> transportList) {
        transportList.sort(Comparator.comparing(Vehicle::getBrand));
        for (Vehicle vehicle : transportList) {
            System.out.println(vehicle);
        }
    }

    public static void sortByYear(List<Vehicle> transportList) {
        transportList.sort(Comparator.comparing(Vehicle::getYearOfIssue));
        for (Vehicle vehicle : transportList) {
            System.out.println(vehicle);
        }
    }

    public static void sortByMaxSpeed(List<Vehicle> transportList) {
        transportList.sort(Comparator.comparing(Vehicle::getMaxSpeed).reversed());
        for (Vehicle vehicle : transportList) {
            System.out.println(vehicle);
        }
    }
}
