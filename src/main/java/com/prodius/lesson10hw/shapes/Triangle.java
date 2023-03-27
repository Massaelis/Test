package com.prodius.lesson10hw.shapes;

public class Triangle {
    public <E extends Number> double triangleArea(final E a, final E b, final E c) {
        final double pp = (a.doubleValue() + b.doubleValue() + c.doubleValue()) / 2.0;
        final double area = Math.sqrt(pp * (pp - a.doubleValue()) * (pp - b.doubleValue()) * (pp - c.doubleValue()));
        System.out.println("Triangle area: " + area);
        return area;
    }
}
