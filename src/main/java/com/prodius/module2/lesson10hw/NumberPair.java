package com.prodius.module2.lesson10hw;

public class NumberPair<E extends Number> {
    final int first;
    final double second;

    public NumberPair(final E x, final E y) {
        this.first = x.intValue();
        this.second = y.doubleValue();
    }

    public int getInteger() {
        return first;
    }

    public double getDouble() {
        return second;
    }
}
