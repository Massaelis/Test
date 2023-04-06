package com.prodius.module2.lesson6hw.product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class MeasurableProduct extends Product {
    private int count;

    protected MeasurableProduct(final String name, final int price, final int count, final ProductType type) {
        super(name, price, type);
        this.count = count;
    }
}
