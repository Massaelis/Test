package com.prodius.lesson4;

import java.util.Random;

public class RandomInt {
    private static final Random RANDOM = new Random();
    public static int rand(final int bound) {
        return RANDOM.nextInt(bound);
    }
}
