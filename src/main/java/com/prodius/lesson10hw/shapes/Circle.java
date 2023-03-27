package com.prodius.lesson10hw.shapes;

public class Circle {
    public <E extends Number> double circleArea(final E radius) {
        final double area = Math.PI * (radius.doubleValue() * radius.doubleValue());
        System.out.println("Circle area: " + area);
        return area;
    }
}
