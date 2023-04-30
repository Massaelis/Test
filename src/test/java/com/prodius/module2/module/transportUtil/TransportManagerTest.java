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

        final List<Vehicle> actual = target.getTransportList();

        final List<Vehicle> expected = new ArrayList<>();
        expected.add(car);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void removeTransport() {
        Car car = new Car(4, "Subaru", 2017, 250);

        final List<Vehicle> list = target.getTransportList();
        list.add(car);
        target.removeTransport(car);

        final List<Vehicle> actual = target.getTransportList();

        Assertions.assertEquals(0, actual.size());
    }

    @Test
    void getTransportList() {
        target.getTransportList();

        final List<Vehicle> actual = target.getTransportList();

        Assertions.assertEquals(0, actual.size());
    }

    @Test
    void findTransportByBrand() {
        Car car = new Car(4, "Subaru", 2017, 250);

        final List<Vehicle> actual = target.getTransportList();
        actual.add(car);

        final boolean isFind = target.findTransportByBrand("Subaru");

        Assertions.assertTrue(isFind);
    }

    @Test
    void findTransportByBrandNotFind() {
        Car car = new Car(4, "Subaru2", 2017, 250);

        final List<Vehicle> actual = target.getTransportList();
        actual.add(car);

        final boolean isFind = target.findTransportByBrand("Subaru");

        Assertions.assertFalse(isFind);
    }

    @Test
    void sortTransportByBrand() {
        Car car = new Car(4, "Subaru", 2017, 250);
        Car car2 = new Car(4, "Audi", 2017, 280);

        final List<Vehicle> list = target.getTransportList();
        list.add(car);
        list.add(car2);
        target.sortTransportByBrand();

        final List<Vehicle> actual = target.getTransportList();

        Assertions.assertEquals(2, actual.size());
        Assertions.assertEquals(car2, actual.get(0));
        Assertions.assertEquals(car, actual.get(1));
    }

    @Test
    void sortTransportByYear() {
        Car car = new Car(4, "Subaru", 2017, 250);
        Car car2 = new Car(4, "Audi", 2010, 280);

        final List<Vehicle> list = target.getTransportList();
        list.add(car);
        list.add(car2);
        target.sortTransportByYear();

        final List<Vehicle> actual = target.getTransportList();

        Assertions.assertEquals(2, actual.size());
        Assertions.assertEquals(car2, actual.get(0));
        Assertions.assertEquals(car, actual.get(1));
    }

    @Test
    void sortTransportByMaxSpeed() {
        Car car = new Car(4, "Subaru", 2017, 250);
        Car car2 = new Car(4, "Audi", 2010, 280);

        final List<Vehicle> list = target.getTransportList();
        list.add(car);
        list.add(car2);
        target.sortTransportByMaxSpeed();

        final List<Vehicle> actual = target.getTransportList();

        Assertions.assertEquals(2, actual.size());
        Assertions.assertEquals(car2, actual.get(0));
        Assertions.assertEquals(car, actual.get(1));
    }

    @Test
    void filterTransportByMaxSpeed() {
        Car car = new Car(4, "Subaru", 2017, 250);

        final List<Vehicle> actual = target.getTransportList();
        actual.add(car);

        final List<Vehicle> result = target.filterTransportByMaxSpeed(180);

        Assertions.assertEquals(0, result.size());
    }

    @Test
    void filterTransportByMaxSpeed2() {
        Car car1 = new Car(4, "Subaru", 2017, 250);
        Car car2 = new Car(4, "Subaru", 2017, 150);

        final List<Vehicle> actual = target.getTransportList();
        actual.add(car1);
        actual.add(car2);

        final List<Vehicle> result = target.filterTransportByMaxSpeed(200);

        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals(car2, result.get(0));
    }
}