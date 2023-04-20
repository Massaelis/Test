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
    private String brand;
    private int yearOfIssue;
    private double maxSpeed;

    public Vehicle(final Type type, final int numberOfWheels, final String brand,
                   final int yearOfIssue, final double maxSpeed) {
        super(type, numberOfWheels);
        this.brand = brand;
        this.yearOfIssue = yearOfIssue;
        this.maxSpeed = maxSpeed;
    }

    public Vehicle(){

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
    public List<Vehicle> addTransport(Vehicle transport, List<Vehicle> transportList) {
        transportList.add(transport);
        return transportList;
    }

    @Override
    public List<Vehicle> removeTransport(Vehicle transport, List<Vehicle> transportList) {
        transportList.remove(transport);
        return transportList;
    }

    @Override
    public List<Vehicle> getTransportList(List<Vehicle> transportList) {
        System.out.println(transportList);
        return transportList;
    }

    //сделать!!!
    @Override
    public void findTransportByBrand(String brand) {

    }

    @Override
    public List<Vehicle> sortTransportByBrand(List<Vehicle> transportList) {
        TransportSorter.sortByBrand(transportList);
        return transportList;
    }

    @Override
    public List<Vehicle> sortTransportByYear(List<Vehicle> transportList) {
        TransportSorter.sortByYear(transportList);
        return transportList;
    }

    @Override
    public List<Vehicle> sortTransportByMaxSpeed(List<Vehicle> transportList) {
        TransportSorter.sortByMaxSpeed(transportList);
        return transportList;
    }

    @Override
    public List<Vehicle> filterTransportByMaxSpeed(int maxSpeeds, List<Vehicle> transportList) {
        final List<Vehicle> filterList = transportList.stream()
                .filter(vehicle -> vehicle.maxSpeed <= maxSpeeds)
                .collect(Collectors.toList());
        System.out.println(filterList);
        return filterList;
    }
}