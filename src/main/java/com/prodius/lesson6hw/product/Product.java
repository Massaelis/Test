package com.prodius.lesson6hw.product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
abstract class Product {
    private final String name;
    private final int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public abstract void display();
}
