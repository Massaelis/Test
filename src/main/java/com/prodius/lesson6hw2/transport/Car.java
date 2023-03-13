package com.prodius.lesson6hw2.transport;

public class Car extends Transport implements RidingTransport{
    public Car(String brand, String model, int year) {
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
    public void startMoving() {
        System.out.println("Начинаем движение");
    }

    @Override
    public void stopMoving() {
        System.out.println("Заканчиваем движение");
    }
}
