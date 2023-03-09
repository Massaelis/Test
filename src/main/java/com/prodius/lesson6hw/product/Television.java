package com.prodius.lesson6hw.product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Television extends Product {
    private final int quantity;
    private final double diagonal;
    private final String colorRendering;

    public Television(String name, int price, int quantity, double diagonal, String colorRendering) {
        super(name, price);
        this.quantity = quantity;
        this.diagonal = diagonal;
        this.colorRendering = colorRendering;
    }

    @Override
    public void display() {
        System.out.println("Television ~ "
                + "name: " + super.getName()
                + "; price: " + super.getPrice() + "$"
                + "; diagonal: " + diagonal
                + "; quantity: " + quantity
                + "; color rendering: " + colorRendering);
    }

}
