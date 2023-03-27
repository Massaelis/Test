package com.prodius.lesson10hw.shapes;

public class Circle<E extends Number> implements Figure {

    private final E radius;

    public Circle(final E radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        final double area = Math.PI * (radius.doubleValue() * radius.doubleValue());
        System.out.println("Circle area: " + area);
        return area;
    }
}
