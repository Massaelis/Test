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

    @Nested
    class LogTest{
        @Test
        void logPositive() {
            int a = 1;
            int b = 1;
            double expected = (Math.log(a) / Math.log(b));

            final double actualLog = target.log(a, b);

            Assertions.assertEquals(expected, actualLog);
        }

        @Test
        void logNegative() {
            int a = -1;
            int b = -1;
            double expected = Math.log(a) / Math.log(b);

            final double actualLog = target.log(a, b);


            Assertions.assertEquals(expected, actualLog);
        }

        @Test
        void logZero() {
            int a = 0;
            int b = 0;
            double expected = Math.log(a) / Math.log(b);

            final double actualLog = target.log(a, b);

            Assertions.assertEquals(expected, actualLog);
        }

        @Test
        void logDifferent() {
            int a = -5;
            int b = 10;
            double expected = Math.log(a) / Math.log(b);

            final double actualLog = target.log(a, b);

            Assertions.assertEquals(expected, actualLog);
        }
    }

    @Nested
    class RootingTest{
        @Test
        void rootingPositive() {
            int a = 1;
            int expected = (int) Math.sqrt(a * a);

            final int actualRooting = target.rooting(a);

            Assertions.assertEquals(expected, actualRooting);
        }

        @Test
        void rootingNegative() {
            int a = -1;

            final int actualRooting = target.rooting(a);

            Assertions.assertEquals(a, actualRooting);
        }

        @Test
        void rootingZero() {
            int a = 0;
            int expected = 0;

            final int actualRooting = target.rooting(a);

            Assertions.assertEquals(expected, actualRooting);
        }

        @Test
        void rootingBiggerThenOne() {
            int a = 10;
            int expected = 3;

            final int actualRooting = target.rooting(a);

            Assertions.assertEquals(expected, actualRooting);
        }

    }

    @Nested
    class ExponentiationTest{
        @Test
        void exponentiationPositive() {
            int a = 1;
            int b = 1;
            int expected = (int) Math.pow(a, b);


            final int actualExponentiation = target.exponentiation(a, b);

            Assertions.assertEquals(expected, actualExponentiation);
        }

        @Test
        void exponentiationNegative() {
            int a = -1;
            int b = -1;
            int expected = 1;

            final int actualExponentiation = target.exponentiation(a, b);

            Assertions.assertEquals(expected, actualExponentiation);
        }

        @Test
        void exponentiationZero() {
            int a = 0;
            int b = 0;
            int expected = (int) Math.pow(a, b);

            final int actualExponentiation = target.exponentiation(a, b);

            Assertions.assertEquals(expected, actualExponentiation);
        }

        @Test
        void exponentiationDifferent() {
            int a = -5;
            int b = 10;
            int expected = (int) Math.pow(a, b);

            final int actualExponentiation = target.exponentiation(a, b);

            Assertions.assertEquals(expected, actualExponentiation);
        }
    }

    @Nested
    class ConversionInFractionTest{
        @Test
        void conversionInFractionPositive() {
            int a = 1;
            int b = 1;
            int topPart = a * b;

            String expected = topPart + "/" + b;

            final String actualConversionInFraction = target.conversionInFraction(a, b);

            Assertions.assertEquals(expected, actualConversionInFraction);
        }

        @Test
        void conversionInFractionNegative() {
            int a = -1;
            int b = -1;
            int topPart = a * b;

            String expected = topPart + "/" + b;

            final String actualConversionInFraction = target.conversionInFraction(a, b);

            Assertions.assertEquals(expected, actualConversionInFraction);
        }

        @Test
        void conversionInFractionZero() {
            int a = 0;
            int b = 0;
            int topPart = 0;

            String expected = topPart + "/" + b;

            final String actualConversionInFraction = target.conversionInFraction(a, b);

            Assertions.assertEquals(expected, actualConversionInFraction);
        }

        @Test
        void conversionInFractionDifferent() {
            int a = -5;
            int b = 10;
            int topPart = a * b;

            String expected = topPart + "/" + b;

            final String actualConversionInFraction = target.conversionInFraction(a, b);

            Assertions.assertEquals(expected, actualConversionInFraction);
        }
    }
}