package com.prodius.lesson4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    private Calculator target;

    @BeforeEach
    void setUp() {
        target = new Calculator();
    }

    @Nested
    class SumTest{
        @Test
        void sumPositive() {
            int a = 1;
            int b = 1;
            int expected = a + b;

            final int actualSum = target.sum(a, b);

            Assertions.assertEquals(expected, actualSum);
        }

        @Test
        void sumNegative() {
            int a = -1;
            int b = -1;
            int expected = a + b;

            final int actualSum = target.sum(a, b);

            Assertions.assertEquals(expected, actualSum);
        }

        @Test
        void sumZero() {
            int a = 0;
            int b = 0;
            int expected = 0;

            final int actualSum = target.sum(a, b);

            Assertions.assertEquals(expected, actualSum);
        }

        @Test
        void sumDifferent() {
            int a = -5;
            int b = 10;
            int expected = a + b;

            final int actualSum = target.sum(a, b);

            Assertions.assertEquals(expected, actualSum);
        }
    }

    @Nested
    class SubtractTest {
        @Test
        void subtractPositive() {
            int a = 1;
            int b = 1;
            int expected = 0;

            final int actualSum = target.subtract(a, b);

            Assertions.assertEquals(expected, actualSum);
        }

        @Test
        void subtractNegative() {
            int a = -1;
            int b = -1;
            int expected = 0;

            final int actualSum = target.subtract(a, b);

            Assertions.assertEquals(expected, actualSum);
        }

        @Test
        void subtractZero() {
            int a = 0;
            int b = 0;
            int expected = 0;

            final int actualSum = target.subtract(a, b);

            Assertions.assertEquals(expected, actualSum);
        }

        @Test
        void subtractDifferent() {
            int a = -5;
            int b = 10;
            int expected = a - b;

            final int actualSum = target.subtract(a, b);

            Assertions.assertEquals(expected, actualSum);
        }
    }

    @Nested
    class MultiplyTest {
        @Test
        void multiplyPositive() {
            int a = 1;
            int b = 1;
            int expected = a * b;

            final int actualSum = target.multiply(a, b);

            Assertions.assertEquals(expected, actualSum);
        }

        @Test
        void multiplyNegative() {
            int a = -1;
            int b = -1;
            int expected = a * b;

            final int actualSum = target.multiply(a, b);

            Assertions.assertEquals(expected, actualSum);
        }

        @Test
        void multiplyZeroBoth() {
            int a = 0;
            int b = 0;
            int expected = 1;

            final int actualSum = target.multiply(a, b);

            Assertions.assertEquals(expected, actualSum);
        }

        @Test
        void multiplyZeroFirst() {
            int a = 0;
            int b = 5;

            final int actualSum = target.multiply(a, b);

            Assertions.assertEquals(b, actualSum);
        }

        @Test
        void multiplyZeroSecond() {
            int a = 7;
            int b = 0;

            final int actualSum = target.multiply(a, b);

            Assertions.assertEquals(a, actualSum);
        }

        @Test
        void multiplyDifferent() {
            int a = -5;
            int b = 10;
            int expected = a * b;

            final int actualSum = target.multiply(a, b);

            Assertions.assertEquals(expected, actualSum);
        }
    }

    @Nested
    class DivideTest {
        @Test
        void dividePositive() {
            int a = 1;
            int b = 1;
            double expected = prepareResult(a, b);

            final double actualSum = target.divide(a, b);

            Assertions.assertEquals(expected, actualSum);
        }

        @Test
        void divideNegative() {
            int a = -1;
            int b = -1;
            double expected = prepareResult(a, b);

            final double actualSum = target.divide(a, b);

            Assertions.assertEquals(expected, actualSum);
        }

        @Test
        void divideZero() {
            int a = 0;
            int b = 0;

            Assertions.assertThrows(
                    IllegalArgumentException.class,
                    () -> target.divide(a, b),
                    "Invalid b parameter"
            );
        }

        @Test
        void divideDifferent() {
            int a = -1;
            int b = 1;
            double expected = prepareResult(a, b);

            final double actualSum = target.divide(a, b);

            Assertions.assertEquals(expected, actualSum);
        }

        @Test
        void divideNotOne() {
            int a = 10;
            int b = 3;
            double expected = prepareResult(a, b);

            final double actualSum = target.divide(a, b);

            Assertions.assertEquals(expected, actualSum, 0.00001);
        }

        @Test
        void divideSecondOne() {
            int a = RandomInt.rand(1000);
            int b = 1;
            double expected = prepareResult(a, b);

            final double actualSum = target.divide(a, b);

            Assertions.assertEquals(expected, actualSum, 0.00001);
        }

        private double prepareResult(final int a, final int b) {
            return a * 1.0 / b;
        }
    }
}