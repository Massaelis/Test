package com.prodius.lesson4;

import lombok.Getter;

@Getter
public class Calculator { // ctrl+shift+t create a test

    public int sum(final int a, final int b) {
        return a + b;
    }

    public int subtract(final int a, final int b) {
        return a - b;
    }

    public int multiply(final int a, final int b) {
        if (a == 0 && b == 0) {
            return 1;
        } else if (a == 0) {
            return b;
        } else if (b == 0) {
            return a;
        } else {
            return a * b;
        }
    }

    public double divide(final int a, final int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Invalid b parameter");
        }
        return a * 1.0 / b;
    }

    // TODO: 24/02/23
    //  логарифм, корень, степень, перевод в дробь
}
