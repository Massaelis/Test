package com.prodius.lesson10hw.shapes;

public class Rectangle {
    public <E extends Number> double rectangleArea(final E a, final E b) {
        final double area = a.doubleValue() * b.doubleValue();
        System.out.println("Rectangle area: " + area);
        return area;
    }
}
