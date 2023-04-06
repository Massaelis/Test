package com.prodius.module2.lesson6hw.product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Television extends DiagonalProduct {
    private final String colorRendering;

    public Television(String name, int price, int quantity, double diagonal, String colorRendering) {
        super(name, price, quantity, diagonal, ProductType.TELEVISION);
        this.colorRendering = colorRendering;
    }

    @Override
    public String toString() {
        return String.format("Television ~ name: %s; price: %d$; quantity: %d; diagonal: %.2f; color rendering: %s",
                super.getName(), super.getPrice(), super.getCount(), super.getDiagonal(), colorRendering);
    }

}
