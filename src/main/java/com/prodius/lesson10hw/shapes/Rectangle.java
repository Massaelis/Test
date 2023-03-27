package com.prodius.lesson10hw.shapes;

public class Rectangle<E extends Number> implements Figure {
    private final E a;

    private final E b;

    public Rectangle(final E a, final E b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double getArea() {
        final double area = a.doubleValue() * b.doubleValue();
        System.out.println("Rectangle area: " + area);
        return area;
    }
}
