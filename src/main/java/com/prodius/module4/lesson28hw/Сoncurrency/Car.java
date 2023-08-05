package com.prodius.module4.lesson28hw.Сoncurrency;

import java.util.concurrent.Semaphore;

public class Car implements Runnable {
    private static final int parkingPlace = 4;
    //Парковочное место занято - true, свободно - false
    protected static final boolean[] PARKING_PLACES = new boolean[parkingPlace];
    //Устанавливаем флаг "справедливый", в таком случае метод
    //aсquire() будет раздавать разрешения в порядке очереди
    protected static final Semaphore SEMAPHORE = new Semaphore(parkingPlace, true);
    private int carNumber;

    public Car(int carNumber) {
        this.carNumber = carNumber;
    }

    @Override
    public void run() {
        System.out.println("Car " + carNumber + " near parking");
        try {
            //acquire() запрашивает доступ к следующему за вызовом этого метода блоку кода,
            //если доступ не разрешен, поток вызвавший этот метод блокируется до тех пор,
            //пока семафор не разрешит доступ
            SEMAPHORE.acquire();

            int parkingNumber = -1;

            //Ищем свободное место и паркуемся
            synchronized (PARKING_PLACES) {
                for (int i = 0; i < PARKING_PLACES.length; i++)
                    if (!PARKING_PLACES[i]) {      //Если место свободно
                        PARKING_PLACES[i] = true;  //занимаем его
                        parkingNumber = i;         //Наличие свободного места, гарантирует семафор
                        System.out.println("Car " + carNumber + " parked on place number " + i);
                        break;
                    }
            }
            Thread.sleep(2000);

            synchronized (PARKING_PLACES) {
                PARKING_PLACES[parkingNumber] = false;//Освобождаем место
            }
            SEMAPHORE.release(); //release(), освобождает ресурс
            System.out.println("Car " + carNumber + " left the parking lot.");
        } catch (InterruptedException e) {
        }
    }
}