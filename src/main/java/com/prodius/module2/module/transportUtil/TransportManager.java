package com.prodius.module2.module.transportUtil;

import com.prodius.module2.module.vehicle.Vehicle;

import java.util.List;

public interface TransportManager {
    List<Vehicle> addTransport(Vehicle transport, List<Vehicle> transportList);

    List<Vehicle> removeTransport(Vehicle transport, List<Vehicle> transportList);

    List<Vehicle> getTransportList(List<Vehicle> transportList);

    void findTransportByBrand(String brand);

    List<Vehicle> sortTransportByBrand(List<Vehicle> transportList);

    List<Vehicle> sortTransportByYear(List<Vehicle> transportList);

    List<Vehicle> sortTransportByMaxSpeed(List<Vehicle> transportList);

    List<Vehicle> filterTransportByMaxSpeed(int maxSpeed, List<Vehicle> transportList);
}
