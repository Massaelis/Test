package com.prodius.module2.lesson6hw.product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Product {
    private final String name;
    private final int price;

    private final ProductType type;

    protected Product(String name, int price, final ProductType type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }
}
