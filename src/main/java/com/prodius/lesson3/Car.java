package com.prodius.lesson3;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Car {
    private static int price;
    private int count;

    void setCount(final int count) {
        this.count = count;
    }

    public static void setPrice1(final int price1) {
//        count = price1; ERROR
        price = price1;
    }

    public void setPrice2(final int price1) {
        count = price1;
        price = price1;
    }

    public void setPrice3() {
        int price1;
//        price = price1; ERROR
        price1 = 0;
        price = price1;
    }

    @Override
    public String toString() {
        return "Car{" +
                "count=" + count +
                " price=" + price +
                '}';
    }
}
