package com.prodius.module2.lesson6hw2.transport;

public class Airplane extends Transport implements FlyingTransport{
    public Airplane(String brand, String model, int year) {
        super(brand, model, year);
    }

    @Override
    public void startEngine() {
        System.out.println("Запустить двигатель");
    }

    @Override
    public void stopEngine() {
        System.out.println("Остановить двигатель");
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
