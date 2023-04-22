package com.prodius.module2.module.transportUtil;

import com.prodius.module2.module.vehicle.Vehicle;
import com.prodius.module2.module.vehicle.typeVehicle.Car;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class TransportManagerTest {
    private TransportManager target;

    @BeforeEach
    void setUp() {
        target = new TransportManager();
    }

    @Test
    void addTransport() {
        Car car = new Car(4, "Subaru", 2017, 250);
        target.addTransport(car);

        final List<Vehicle> actual = TransportManager.transportList;

        final List<Vehicle> expected = new ArrayList<>();
        expected.add(car);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void removeTransport() {
        Car car = new Car(4, "Subaru", 2017, 250);

        final List<Vehicle> actual = TransportManager.transportList;
        actual.add(car);
        target.removeTransport(car);

        final List<Vehicle> expected = new ArrayList<>();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getTransportList() {
        target.getTransportList();

        final List<Vehicle> actual = TransportManager.transportList;

        final List<Vehicle> expected = new ArrayList<>();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void findTransportByBrand() {
        Car car = new Car(4, "Subaru", 2017, 250);

        final List<Vehicle> actual = TransportManager.transportList;
        actual.add(car);

        target.findTransportByBrand("Subaru");

        final List<Vehicle> expected = new ArrayList<>();

        expected.add(car);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void sortTransportByBrand() {
        Car car = new Car(4, "Subaru", 2017, 250);
        Car car2 = new Car(4, "Audi", 2017, 280);

        final List<Vehicle> actual = TransportManager.transportList;
        actual.add(car);
        actual.add(car2);
        target.sortTransportByBrand();

        final List<Vehicle> expected = new ArrayList<>();
        expected.add(car2);
        expected.add(car);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void sortTransportByYear() {
        Car car = new Car(4, "Subaru", 2017, 250);
        Car car2 = new Car(4, "Audi", 2010, 280);

        final List<Vehicle> actual = TransportManager.transportList;
        actual.add(car);
        actual.add(car2);
        target.sortTransportByYear();

        final List<Vehicle> expected = new ArrayList<>();
        expected.add(car2);
        expected.add(car);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void sortTransportByMaxSpeed() {
        Car car = new Car(4, "Subaru", 2017, 250);
        Car car2 = new Car(4, "Audi", 2010, 280);

        final List<Vehicle> actual = TransportManager.transportList;
        actual.add(car);
        actual.add(car2);
        target.sortTransportByMaxSpeed();

        final List<Vehicle> expected = new ArrayList<>();
        expected.add(car2);
        expected.add(car);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void filterTransportByMaxSpeed() {
        Car car = new Car(4, "Subaru", 2017, 250);

        final List<Vehicle> actual = TransportManager.transportList;
        actual.add(car);

        target.filterTransportByMaxSpeed(180);

        final List<Vehicle> expected = new ArrayList<>();

        Assertions.assertEquals(expected, actual);
    }
}