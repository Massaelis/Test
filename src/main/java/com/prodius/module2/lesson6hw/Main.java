package com.prodius.module2.lesson6hw;

import com.prodius.module2.lesson6hw.product.ProductType;
import com.prodius.module2.lesson6hw.product.Refrigerator;
import com.prodius.module2.lesson6hw.product.Tablet;
import com.prodius.module2.lesson6hw.product.Telephone;
import com.prodius.module2.lesson6hw.product.Television;
import com.prodius.module2.lesson6hw.repository.Repository;
import com.prodius.module2.lesson6hw.service.Service;

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
        Service service = new Service(new Repository());

        final Television television = service.createTelevision("Samsung Q8000", 500, 2, 55.0, "QLED");
        System.out.println(television);

        final Refrigerator refrigerator = service.createRefrigerator("LG 5000", 500, 2);
        System.out.println(refrigerator);

        final Telephone telephone = service.createTelephone("Iphone XR", 500, 3, 9.3, 10);
        System.out.println(telephone);

        final Tablet tablet = service.createTablet("Ipad mini", 400, 5, 7);
        System.out.println(tablet);

        //
        service.sumAllProduct();

        //
        service.countByType(ProductType.TABLET);
        final Tablet tablet2 = service.createTablet("Ipad mini", 450, 5, 7);
        service.countByType(ProductType.TABLET);

        //
        final boolean same1 = service.isTheSame(television, tablet);
        System.out.println(same1);
        final boolean same2 = service.isTheSame(television, television);
        System.out.println(same2);
        final boolean same3 = service.isTheSame(tablet, tablet2);
        System.out.println(same3);
    }
}
