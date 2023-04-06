package com.prodius.module2.lesson10hw;

public class NumberPair2<E extends Number> {
    final E first;

    final E second;

    public NumberPair2(final E x, final E y) {
        this.first = x;
        this.second = y;
    }

    public int getInteger() {
        return first.intValue();
    }

    public double getDouble() {
        return second.doubleValue();
    }
}
