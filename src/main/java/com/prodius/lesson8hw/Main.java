package com.prodius.lesson8hw;

import java.util.Date;
import java.util.Optional;

public class Main {
    public static <T> void main(String[] args) {
        final Optional<T> valueOne = getT(2);
        final Optional<T> valueTwo = getT(1);

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
        getString(4)
                .filter(value -> value.equals(4))
                .map(value -> 4)
                .ifPresentOrElse(
                        value -> System.out.println(value),
                        () -> System.out.println("Empty value"));
        System.out.println("~".repeat(10));

        System.out.println("[ifPresentOrElse example:]");
        ifPresentOrElse(valueString);
        System.out.println("~".repeat(10));

        try {
            System.out.println("changeString example:]");
            changeString(valueString);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("~".repeat(10));

        System.out.println("flatMap example:]");
        flatMap(valueOne, valueTwo);
        System.out.println("~".repeat(10));

    }

    private static <T> void get(final Optional<T> value) {
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

    private static <T> void orElse(final Optional<T> value1, final Optional<T> value2) {
        System.out.println(value1.orElse((T) value2));
    }

    private static <T> void orElseThrow(final Optional<T> value) {
        Date date = new Date();
        System.out.println(value.orElseThrow(() ->
                new IllegalStateException(String.valueOf(date))));
    }

    private static <T> void orElseGet(final Optional<T> value) {
        System.out.println(value.orElseGet(() -> {
            return (T) "Default value";
        }));
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
        StringBuilder sb = new StringBuilder();
        if (valueString.isEmpty()) {
            System.out.println(Optional.empty());
        }
        for (int i = 0; i < valueString.get().length(); i++) {
            valueString.get().charAt(i);
            if (i % 2 == 0) {
                sb.append('*');
            } else {
                sb.append('+');
            }
        }
        System.out.println(sb);

        if(sb.toString().length() < 5){
            System.out.println(Optional.of("string is short"));
        }
    }

    private static <T> void flatMap(final Optional<T> valueOne, final Optional<T> valueTwo) {
        final Optional<T> value = valueOne.flatMap(value1 -> valueTwo.map(value2 -> {
            return merge(value1, value2);
        }));
        value.ifPresent(value3 -> System.out.println(value));

    }

    private static <T> T merge(T value1, T value2) {
        T s = (T) (value1 + "" + value2);
        return s;
    }

    private static <T> Optional<T> getT(final int id) {
        final T value = id >= 0 ? (T) "value" : null;
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
