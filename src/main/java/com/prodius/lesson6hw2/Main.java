package com.prodius.lesson6hw2;

import com.prodius.lesson6hw2.transport.Airplane;
import com.prodius.lesson6hw2.transport.Car;
import com.prodius.lesson6hw2.transport.FlyingTransport;
import com.prodius.lesson6hw2.transport.Hybrid;
import com.prodius.lesson6hw2.transport.RidingTransport;
import com.prodius.lesson6hw2.transport.Transport;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Transport airplane = new Airplane("Mriya", "An-225", 1989);
        Transport car = new Car("Porsche", "Taycan Turbo S", 2022);
        Transport hybrid = new Hybrid("Space", "UFO", 1947);

        List<Transport> transports = List.of(airplane, car, hybrid);

        for (Transport transport : transports) {
            transport.startEngine();

            if (transport instanceof RidingTransport) {
                ((RidingTransport) transport).startMoving();
                System.out.println("Это автомобиль");
                ((RidingTransport) transport).stopMoving();
            }
            if (transport instanceof FlyingTransport) {
                ((FlyingTransport) transport).takeOff();
                System.out.println("Это самолет");
                ((FlyingTransport) transport).land();
            }

            transport.stopEngine();
        }
    }
}
