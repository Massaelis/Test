package com.prodius.lesson8hw;

import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        final Optional<String> valueOne = getT(2);
        final Optional<String> valueTwo = getT(1);

        final Optional<Integer> valueInt = getInteger(2);

        final Optional<String> valueString = getString(4);


        System.out.println("[get example:]");
        get(valueOne);
        System.out.println("~".repeat(10));

        System.out.println("[ifPresent example:]");
        ifPresent(valueInt);
        System.out.println("~".repeat(10));

        System.out.println("[orElse example:]");
        orElse(valueOne, valueTwo);
        System.out.println("~".repeat(10));

        try {
            System.out.println("[orElseThrow example:]");
            orElseThrow(valueOne);
            System.out.println("~".repeat(10));
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("[orElseGet example:]");
        orElseGet(valueOne);
        System.out.println("~".repeat(10));

        System.out.println("[filter and map example:]");
        filterMap(valueOne);
        System.out.println("~".repeat(10));

        System.out.println("[ifPresentOrElse example:]");
        ifPresentOrElse(valueString);
        System.out.println("~".repeat(10));

        System.out.println("[changeString example:]");
        changeString(valueString);
        System.out.println("~".repeat(10));

        System.out.println("flatMap example:]");
        flatMap(valueOne, valueTwo);
        System.out.println("~".repeat(10));

    }

    private static void get(final Optional<String> value) {
        if (value.isPresent()) {
            System.out.println(value.get());
        } else {
            System.out.println("Value is null");
        }
    }

    private static void ifPresent(final Optional<Integer> valueInt) {
        valueInt.ifPresent(value -> {
            System.out.println((int) Math.pow(value, 3));
        });
    }

    private static void orElse(final Optional<String> value1, final Optional<String> value2) {
        final String secondValue = value2.orElse(null);
        System.out.println(value1.orElse(secondValue));
    }

    private static void orElseThrow(final Optional<String> value) {
        Date date = new Date();
        System.out.println(value.orElseThrow(
                () -> new IllegalStateException(String.valueOf(date))
        ));
    }

    private static void orElseGet(final Optional<String> value) {
        System.out.println(value.orElseGet(() -> {
            return defaultValue();
        }));
    }

    private static void filterMap(final Optional<String> input) {
        input.filter(value -> StringUtils.isNumeric(value))
                .map(value -> Integer.parseInt(value))
                .ifPresentOrElse(
                        value -> System.out.println(value),
                        () -> System.out.println("Empty value")
                );

        input.filter(value -> {
                    return isNumeric(value);
                })
                .map(value -> Integer.parseInt(value))
                .ifPresentOrElse(
                        value -> System.out.println(value),
                        () -> System.out.println("Empty value")
                );
    }

    private static boolean isNumeric(final String value) {
        boolean isNumber = false;
        try {
            Integer.parseInt(value);
            isNumber = true;
        } catch (NumberFormatException e) {
            System.out.println("Input not a number");
        }
        return isNumber;
    }

    private static String defaultValue() {
        return "Default value";
    }

    private static void ifPresentOrElse(final Optional<String> valueString) {
        valueString.ifPresentOrElse(
                value -> {
                    System.out.println(value.toUpperCase());
                },
                () -> {
                    System.out.println("Empty value");
                }
        );
    }

    private static void changeString(final Optional<String> valueString) {
        valueString.map(value -> {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < value.length(); i++) {
                        if (i % 2 == 0) {
                            sb.append('*');
                        } else {
                            sb.append('+');
                        }
                    }
                    return sb.toString();
                })
                .map(value -> {
                    if (value.length() < 5) {
                        return "string is short";
                    }
                    return value;
                })
                .ifPresentOrElse(value -> System.out.println(value),
                        () -> System.out.println("Empty")
                );
    }

    private static void flatMap(final Optional<String> valueOne, final Optional<String> valueTwo) {
        valueOne.flatMap(value1 -> valueTwo.map(value2 -> {
            return merge(value1, value2);
        })).ifPresent(value3 -> System.out.println(value3));

    }

    private static String merge(final String value1, final String value2) {
        return value1 + value2;
    }

    private static Optional<String> getT(final int id) {
        final String value = id >= 0 ? "value" : null;
        return Optional.ofNullable(value);
    }

    private static Optional<Integer> getInteger(final int id) {
        final Integer value = id >= 0 ? id : null;
        return Optional.ofNullable(value);
    }

    private static Optional<String> getString(final int id) {
        final String value = id >= 0 ? "value" : null;
        return Optional.ofNullable(value);
    }
}
