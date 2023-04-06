package com.prodius.module2.lesson13hw.functionalInterface;


public class MyOperator {
    private static final GreatestCommonDivisor<Integer, Integer, Integer> evclide = (x, y) -> {
        while (x != 0 && y != 0) {
            int value = x % y;
            x = y;
            y = value;
        }
        return x;
    };

    public static void gcd(int a, int b) {
        System.out.println(evclide.apply(a, b));
    }

    @FunctionalInterface
    interface GreatestCommonDivisor<T, U, R> {
        R apply(T t, U u);

        String toString();
    }
}
