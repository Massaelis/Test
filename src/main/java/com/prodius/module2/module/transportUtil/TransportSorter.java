package com.prodius.module2.module.transportUtil;

import com.prodius.module2.module.vehicle.Vehicle;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TransportSorter {

    public static List<Vehicle> sortByBrand(List<Vehicle> transportList) {
        return transportList.stream()
                .sorted(Comparator.comparing(Vehicle::getBrand))
                .collect(Collectors.toList());
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
