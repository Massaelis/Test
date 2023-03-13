package com.prodius.lesson6hw.product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Tablet extends MeasurableProduct {
    private int rating;

    public Tablet(String name, int price, int quantity, int rating) {
        super(name, price, quantity, ProductType.TABLET);
        this.rating = rating;
    }

    @Override
    public String toString() {
        return String.format("Tablet ~ name: %s; price: %d$; quantity: %d; rating: %d/10",
                super.getName(), super.getPrice(), super.getCount(), rating);
    }
}
