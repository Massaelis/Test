package com.prodius.lesson6hw2.transport;

public class Hybrid extends Car implements FlyingTransport{
    public Hybrid(String brand, String model, int year) {
        super(brand, model, year);
    }

    @Override
    public void takeOff() {
        System.out.println("Взлетаем");
    }

    @Override
    public void land() {
        System.out.println("Приземляемся");
    }
}
