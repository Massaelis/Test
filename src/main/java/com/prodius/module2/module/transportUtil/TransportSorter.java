package com.prodius.module2.module.transportUtil;

import com.prodius.module2.module.vehicle.Vehicle;

import java.util.Comparator;

public class TransportSorter {

    public static void sortByBrand() {
        Vehicle.transportList.sort(Comparator.comparing(Vehicle::getBrand));
        for (Vehicle v : Vehicle.transportList) {
            System.out.println(v);
        }
    }

    public static void sortByYear() {
        Vehicle.transportList.sort(Comparator.comparing(Vehicle::getYearOfIssue));
        for (Vehicle v : Vehicle.transportList) {
            System.out.println(v);
        }
    }

    public static void sortByMaxSpeed() {
        Vehicle.transportList.sort(Comparator.comparing(Vehicle::getMaxSpeed).reversed());
        for (Vehicle v : Vehicle.transportList) {
            System.out.println(v);
        }
    }
}
