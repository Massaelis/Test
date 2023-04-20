package com.prodius.module2.module.transportUtil;

import com.prodius.module2.module.vehicle.Vehicle;


public interface TransportManager {
    void addTransport(Vehicle transport);

    void removeTransport(Vehicle transport);

    void getTransportList();

    void findTransportByBrand(String brand);

    void sortTransportByBrand();

    void sortTransportByYear();

    void sortTransportByMaxSpeed();

    void filterTransportByMaxSpeed(int maxSpeed);
}
