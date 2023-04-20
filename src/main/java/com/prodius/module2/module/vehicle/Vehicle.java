package com.prodius.module2.module.vehicle;

import com.prodius.module2.module.transportUtil.TransportManager;
import com.prodius.module2.module.transportUtil.TransportSorter;
import lombok.Getter;
import lombok.Setter;

import java.util.*;
import java.util.stream.Collectors;

@Setter
@Getter
public class Vehicle extends Transport implements Movable, TransportManager {
    public static List<Vehicle> transportList = new ArrayList<>();
    private final String brand;
    private final int yearOfIssue;
    private final double maxSpeed;

    public Vehicle(final Type type, final int numberOfWheels, final String brand,
                   final int yearOfIssue, final double maxSpeed) {
        super(type, numberOfWheels);
        this.brand = brand;
        this.yearOfIssue = yearOfIssue;
        this.maxSpeed = maxSpeed;
    }

    public String toString() {
        return "Vehicle {"
                + "Type: " + getType()
                + ", Wheels: " + getNumberOfWheels()
                + ", Brand: " + getBrand()
                + ", Year: " + getYearOfIssue()
                + ", Max speed: " + getMaxSpeed()
                + '}';
    }

    @Override
    public void move() {
        System.out.println("Start moving: " + getType());
    }

    @Override
    public void calculateSpeed() {
        System.out.println("Speed " + getType() + ": " + getMaxSpeed());
    }

    @Override
    public void addTransport(Vehicle transport) {
        transportList.add(transport);
    }

    @Override
    public void removeTransport(Vehicle transport) {
        transportList.remove(transport);
    }

    @Override
    public void getTransportList() {
        System.out.println(transportList);
    }

    //сделать!!!
    @Override
    public void findTransportByBrand(String brand) {

    }

    @Override
    public void sortTransportByBrand() {
        TransportSorter.sortByBrand();
    }

    @Override
    public void sortTransportByYear() {
        TransportSorter.sortByYear();
    }

    @Override
    public void sortTransportByMaxSpeed() {
        TransportSorter.sortByMaxSpeed();
    }

    @Override
    public void filterTransportByMaxSpeed(int maxSpeeds) {
        final List<Vehicle> filterList = transportList.stream()
                .filter(vehicle -> vehicle.maxSpeed <= maxSpeeds)
                .collect(Collectors.toList());
        System.out.println(filterList);
    }
}