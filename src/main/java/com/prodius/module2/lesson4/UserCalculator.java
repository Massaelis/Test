package com.prodius.module2.lesson4;

import java.util.Random;

public class UserCalculator {
    private final Random random;
    private final Holder holder;

    public UserCalculator(final Random random, final Holder holder) {
        this.random = random;
        this.holder = holder;
    }

    public int sumReturn(final int b) {
        holder.hold("test");
        return random.nextInt(100) + b;
    }

    public void sumVerify(final int b) {
        final int i;
        if (b >= 0) {
            i = random.nextInt(100);
        } else {
            i = random.nextInt(1000);
        }
        System.out.println(i + b);
    }

    public int sumTimes(final int b, final int count) {
        int rc = b;
        for (int i = 0; i < count; i++) {
            rc += random.nextInt(100);
        }
        return rc;
    }

    public int sumReal(final int b) {
        return random.nextInt(1) + b;
    }

    public int sumRandomFromRandom(final int b) {
        final int random1 = random.nextInt(100);
        System.out.println(random1);
        final int random2 = random.nextInt(random1);
        return random2 + b;
    }
}
