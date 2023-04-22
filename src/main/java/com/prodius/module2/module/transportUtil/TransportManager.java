package com.prodius.module2.module.transportUtil;

import com.prodius.module2.module.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TransportManager {

    public static List<Vehicle> transportList = new ArrayList<>();

    public void addTransport(Vehicle transport) {
        transportList.add(transport);
    }

    public void removeTransport(Vehicle transport) {
        transportList.remove(transport);
    }

    public List<Vehicle> getTransportList() {
        System.out.println(transportList);
        return transportList;
    }

    //сделать!!!
    public boolean findTransportByBrand(String brand) {
        final boolean filterList = transportList.stream()
                .anyMatch(vehicle -> vehicle.getBrand().equals(brand));
        System.out.println(filterList);
        return filterList;
    }

    public void sortTransportByBrand() {
        TransportSorter.sortByBrand(transportList);
    }

    public void sortTransportByYear() {
        TransportSorter.sortByYear(transportList);
    }

    public void sortTransportByMaxSpeed() {
        TransportSorter.sortByMaxSpeed(transportList);
    }

    public void filterTransportByMaxSpeed(int maxSpeeds) {
        final List<Vehicle> filterList = transportList.stream()
                .filter(vehicle -> vehicle.getMaxSpeed() <= maxSpeeds)
                .collect(Collectors.toList());
        System.out.println(filterList);
    }
}
