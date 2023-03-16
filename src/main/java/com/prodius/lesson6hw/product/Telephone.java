package com.prodius.lesson6hw.product;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Telephone extends DiagonalProduct {
    private final int generation;

    public Telephone(String name, int price, int quantity, double diagonal, int generation) {
        super(name, price, quantity, diagonal, ProductType.TELEPHONE);
        this.generation = generation;
    }

    @Override
    public String toString() {
        return String.format("Telephone ~ name: %s; price: %d$; quantity: %d; diagonal: %.2f; generation: %d",
                super.getName(), super.getPrice(), super.getCount(), super.getDiagonal(), generation);
    }
}
