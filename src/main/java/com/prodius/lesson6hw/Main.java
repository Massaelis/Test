package com.prodius.lesson6hw;

import com.prodius.lesson6hw.product.Refrigerator;
import com.prodius.lesson6hw.product.Tablet;
import com.prodius.lesson6hw.product.Telephone;
import com.prodius.lesson6hw.product.Television;
import com.prodius.lesson6hw.repository.Repository;
import com.prodius.lesson6hw.service.Count;
import com.prodius.lesson6hw.service.Service;

import java.util.Objects;

/*
~Написать семейство классом интернет магазина.
~Есть несколько товаров
~Телевизор (название, цена, количество, диагональ, передача цвета)
~Холодильник (название, цена, мощность)
~Телефон (название, цена, количество, диагональ, поколение)
~Планшет (название, цена, количество, рейтинг)

~Нужно построить иерархию наследования. Сделать сервис и репозиторий со следующими методами

~В сервисе методы создания каждого конкретного товара.
Сохранение в репозиторий через один метод.
~В сервисе посчитать цену всех товаров.
Через репозиторий достать нужные данные.
~В сервисе посчитать кол-во товаров по типу.
 Через репозиторий достать нужные данные.
В сервисе сделать двух этапное сравнение двух переданных товаров
 */
public class Main {
    public static void main(String[] args) {
        Service service = new Service();

        Television television = new Television("Samsung Q8000", 500, 2,55.0,"QLED");
        Count firstType = new Count();
        Refrigerator refrigerator = new Refrigerator("LG 5000", 500, 2);
        Count secondType = new Count();
        Telephone telephone = new Telephone("Iphone XR", 500, 3,9.3, 10);
        Count thirdType = new Count();
        Tablet tablet = new Tablet("Ipad mini", 400, 5,7);
        Count fourType = new Count();

        service.createTelevision(television);
        service.createRefrigerator(refrigerator);
        service.createTelephone(telephone);
        service.createTablet(tablet);
        //
        service.sumAllProduct(television,refrigerator,telephone,tablet);
        //
        System.out.println("Crete type products: " + Count.count);
        //

    }
}
