package com.prodius.module2.lesson6hw.product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class DiagonalProduct extends MeasurableProduct {
    private double diagonal;

    protected DiagonalProduct(
            final String name, final int price, final int count, final double diagonal, final ProductType type
    ) {
        super(name, price, count, type);
        this.diagonal = diagonal;
    }
}
