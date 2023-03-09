package com.prodius.lesson6hw.product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Refrigerator extends Product {
    private final int power;

    public Refrigerator(String name, int price, int power) {
        super(name, price);
        this.power = power;
    }

    @Override
    public void display() {
        System.out.println("Refrigerator ~ "
                + "name: " + super.getName()
                + "; price: " + super.getPrice() + "$"
                + "; power: " + power + "kW");
    }
}
