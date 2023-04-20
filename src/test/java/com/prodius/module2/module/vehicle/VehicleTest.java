package com.prodius.module2.module.vehicle;

import com.prodius.module2.module.vehicle.typeVehicle.Car;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


class VehicleTest {
    private Vehicle target;

    @BeforeEach
    void setUp() {
        target = new Vehicle();
    }

    @Test
    void addTransport() {
        final List<Vehicle> list = new ArrayList<>();
        Car car = new Car(4, "Subaru", 2017, 250);

        final List<Vehicle> actual = target.addTransport(car, list);

        final List<Vehicle> expected = new ArrayList<>();
        expected.add(car);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void removeTransport() {
        final List<Vehicle> list = new ArrayList<>();
        Car car = new Car(4, "Subaru", 2017, 250);
        list.add(car);

        final List<Vehicle> actual = target.removeTransport(car, list);

        final List<Vehicle> expected = new ArrayList<>();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getTransportList() {
        final List<Vehicle> list = new ArrayList<>();
        Car car = new Car(4, "Subaru", 2017, 250);
        list.add(car);
        final List<Vehicle> actual = target.getTransportList(list);

        final List<Vehicle> expected = new ArrayList<>();
        expected.add(car);

        Assertions.assertEquals(expected, actual);
    }

//    @Test
//    void findTransportByBrand() {
//    }

    @Test
    void sortTransportByBrand() {
        final List<Vehicle> list = new ArrayList<>();
        Car car = new Car(4, "Subaru", 2017, 250);
        Car car2 = new Car(4, "Audi", 2017, 280);
        list.add(car);
        list.add(car2);

        final List<Vehicle> actual = target.sortTransportByBrand(list);

        final List<Vehicle> expected = new ArrayList<>();
        expected.add(car2);
        expected.add(car);

        Assertions.assertEquals(expected, actual);
    }


    @Test
    void sortTransportByYear() {
        final List<Vehicle> list = new ArrayList<>();
        Car car = new Car(4, "Subaru", 2017, 250);
        Car car2 = new Car(4, "Audi", 2010, 280);
        list.add(car);
        list.add(car2);

        final List<Vehicle> actual = target.sortTransportByYear(list);

        final List<Vehicle> expected = new ArrayList<>();
        expected.add(car2);
        expected.add(car);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void sortTransportByMaxSpeed() {
        final List<Vehicle> list = new ArrayList<>();
        Car car = new Car(4, "Subaru", 2017, 250);
        Car car2 = new Car(4, "Audi", 2010, 280);
        list.add(car);
        list.add(car2);

        final List<Vehicle> actual = target.sortTransportByMaxSpeed(list);

        final List<Vehicle> expected = new ArrayList<>();
        expected.add(car2);
        expected.add(car);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void filterTransportByMaxSpeed() {
        final List<Vehicle> list = new ArrayList<>();
        Car car = new Car(4, "Subaru", 2017, 250);
        list.add(car);

        final List<Vehicle> actual = target.filterTransportByMaxSpeed(180, list);

        final List<Vehicle> expected = new ArrayList<>();

        Assertions.assertEquals(expected, actual);
    }
}