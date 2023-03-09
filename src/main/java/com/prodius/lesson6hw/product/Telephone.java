package com.prodius.lesson6hw.product;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Telephone extends Product {
    private final int quantity;
    private final int generation;
    private final double diagonal;

    public Telephone(String name, int price, int quantity, double diagonal, int generation) {
        super(name, price);
        this.quantity = quantity;
        this.diagonal = diagonal;
        this.generation = generation;
    }

    @Override
    public void display() {
        System.out.println("Telephone ~ "
                + "name: " + super.getName()
                + "; price: " + super.getPrice() + "$"
                + "; quantity: " + quantity
                + "; diagonal: " + diagonal
                + "; generation: " + generation);
    }
}
