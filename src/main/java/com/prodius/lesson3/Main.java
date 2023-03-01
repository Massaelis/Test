package com.prodius.lesson3;

public class Main {
    public static void main(String[] args) {
        final Car car1 = new Car();
        car1.setCount(1);
        Car.setPrice1(100);
        System.out.println(car1);

        final Car car2 = new Car();
        car2.setCount(2);
        Car.setPrice1(200);
        System.out.println(car2);

        final Car car3 = new Car();
        car3.setCount(3);
        Car.setPrice1(300);
        System.out.println(car3);

        Car.setPrice1(500);

        System.out.println("car1 " + car1);
        System.out.println("car2 " + car2);
        System.out.println("car3 " + car3);
    }
}
