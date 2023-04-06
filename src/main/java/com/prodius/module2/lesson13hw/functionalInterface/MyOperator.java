package com.prodius.module2.lesson13hw.functionalInterface;


public class MyOperator {
    private static final GreatestCommonDivisor<Integer> EVCLIDE = (x, y) -> {
        int tempX = x;
        int tempY = y;
        while (tempX != 0 && tempY != 0) {
            int value = tempX % tempY;
            tempX = tempY;
            tempY = value;
        }
        return tempX;
    };

    public static void gcd(int a, int b) {
        System.out.println(EVCLIDE.apply(a, b));
    }

    @FunctionalInterface
    interface GreatestCommonDivisor<T> {
        T apply(T t, T u);

    }
}
