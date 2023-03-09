package com.prodius.lesson6hw.product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Tablet extends Product{
    private final int quantity;
    private final int rating;

    public Tablet(String name, int price, int quantity, int rating) {
        super(name, price);
        this.quantity = quantity;
        this.rating = rating;
    }

    @Override
    public void display() {
        System.out.println("Tablet ~ "
                + "name: " + super.getName()
                + "; price: " + super.getPrice() + "$"
                + "; quantity: " + quantity
                + "; rating: " + rating +"/10");
    }
}
