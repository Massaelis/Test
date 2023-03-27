package com.prodius.lesson10hw.shapes;

public class Triangle<E extends Number> implements Figure {

    private final E a;

    private final E b;

    private final E c;

    public Triangle(final E a, final E b, final E c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double getArea() {
        final double pp = (a.doubleValue() + b.doubleValue() + c.doubleValue()) / 2.0;
        final double area = Math.sqrt(pp * (pp - a.doubleValue()) * (pp - b.doubleValue()) * (pp - c.doubleValue()));
        System.out.println("Triangle area: " + area);
        return area;
    }
}
