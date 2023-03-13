package com.prodius.lesson6hw2;

import com.prodius.lesson6hw2.transport.Airplane;
import com.prodius.lesson6hw2.transport.Car;
import com.prodius.lesson6hw2.transport.Hybrid;
import com.prodius.lesson6hw2.transport.Transport;

public class Main {
    public static void main(String[] args) {
        Service service = new Service();

        Airplane airplane = new Airplane("Mriya","An-225",1989);
        Car car = new Car("Porsche","Taycan Turbo S", 2022);
        Hybrid hybrid = new Hybrid("Space", "UFO", 1947);

        airplane.startEngine();
        airplane.takeOff();
        airplane.land();
        airplane.stopEngine();

        service.isTheSame(airplane);

        car.startEngine();
        car.startMoving();
        car.stopMoving();
        car.stopEngine();

        service.isTheSame(car);

        hybrid.startEngine();
        hybrid.takeOff();
        hybrid.land();
        hybrid.stopEngine();

        service.isTheSame(hybrid);
    }
}
