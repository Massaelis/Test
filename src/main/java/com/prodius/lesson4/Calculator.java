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


    public double log(final int a, final int b) {
        return Math.log(a) / Math.log(b);
    }

    public int rooting(final int a) {
        if (a < 2) {
            return a;
        }
        int i = 1;
        while (i * i <= a) {
            if (i * i <= 0) {
                break;
            }
            i++;
        }
        return --i;
    }

    public int exponentiation(final int a, final int b) {
        int result = 1;
        for (int i = 1; i <= b; i++) {
            result = result * a;
        }
        return result;
    }

    public String conversionInFraction(final int a, final int b) {
        int topPart = a * b;
        return topPart + "/" + b;
    }
}
