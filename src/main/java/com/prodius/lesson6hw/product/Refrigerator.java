package com.prodius.lesson6hw.product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Refrigerator extends Product {
    private final int power;

    public Refrigerator(String name, int price, int power) {
        super(name, price, ProductType.REFRIGERATOR);
        this.power = power;
    }

    @Override
    public String toString() {
        return String.format("Refrigerator ~ name: %s; price: %d$; power: %dkW",
                super.getName(), super.getPrice(), power);
    }
}
