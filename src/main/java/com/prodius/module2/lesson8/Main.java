package com.prodius.module2.lesson8;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        final Optional<String> existValue = getUserEmailSecondWay(4);
        final Optional<String> emptyValue = getUserEmailSecondWay(-4);

//        System.out.println("[get example:]");
//        get(existValue, emptyValue);
//        System.out.println("~".repeat(10));
//
//        System.out.println("[ifPresent example:]");
//        ifPresent(existValue, emptyValue);
//        System.out.println("~".repeat(10));
//
//        System.out.println("[orElse example:]");
//        orElse(existValue, emptyValue);
//        System.out.println("~".repeat(10));

//        try {
//            System.out.println("[orElseThrow example:]");
//            orElseThrow(existValue, emptyValue);
//            System.out.println("~".repeat(10));
//        } catch (IllegalStateException e) {
//            System.out.println(e.getMessage());
//        }

//        System.out.println("[orElseGet example:]");
//        orElseGet(existValue, emptyValue);
//        System.out.println("~".repeat(10));

//        System.out.println("[map example:]");
//        map(existValue, emptyValue);
//        System.out.println("~".repeat(10));

//        System.out.println("[filter example:]");
//        filter(existValue, emptyValue);
//        System.out.println("~".repeat(10));

//        System.out.println("[ifPresentOrElse example:]");
//        ifPresentOrElse(existValue, emptyValue);
//        System.out.println("~".repeat(10));

//        System.out.println("[or example:]");
//        or(existValue, emptyValue);
//        System.out.println("~".repeat(10));


//        System.out.println("[flatMap with additional value example:]");
//        flatMap(existValue, Optional.of("Default value"));
//        System.out.println("[flatMap without additional value example:]");
//        flatMap(existValue, Optional.empty());
//        System.out.println("~".repeat(10));

        /*
        проверить что строка равна value
        преобразовать число в 10
        если значение есть - показать на экран квадрат числа
        если значения нет - показать на экран 0
         */
        getUserEmailSecondWay(-4)
                .filter(value -> value.equals("value"))
                .map(value -> 10)
                .ifPresentOrElse(
                        value -> System.out.println(value * value),
                        () -> System.out.println(0)
                );

        final String userEmail = getUserEmailWrongWay(-4);
        if (userEmail != null) {
            if (userEmail.equals("value")) {
                Integer newValue = 10;
                if (newValue != null) {
                    System.out.println(newValue * newValue);
                } else {
                    System.out.println(0);
                }
            } else {
                System.out.println(0);
            }
        } else {
            System.out.println(0);
        }
    }

    private static void flatMap(final Optional<String> existValue, final Optional<String> defaultValue) {
        System.out.println("incorrectState:");
        final Optional<Optional<String>> incorrectState = existValue.map(value -> {
            return defaultValue;
        });

        incorrectState.ifPresent(value -> System.out.println(value));

        System.out.println("correctStateIncorrectWay:");
        final Optional<String> correctStateIncorrectWay = existValue.map(value -> {
            if (defaultValue.isPresent()) {
                return defaultValue.get();
            }
            return "";
        });
        correctStateIncorrectWay.ifPresent(value -> System.out.println(value));

        System.out.println("correctStateCorrectWay:");
        final Optional<String> correctStateCorrectWay = existValue.flatMap(value -> {
            return defaultValue;
        });
        correctStateCorrectWay.ifPresent(value -> System.out.println(value));
    }

    private static void or(final Optional<String> existValue, final Optional<String> emptyValue) {
        System.out.println("ExistValue:");
        final Optional<String> defaultValue = existValue.or(() -> Optional.of("Default value"));
        defaultValue.ifPresent(value -> {
            System.out.println(value);
        });

        System.out.println("EmptyValue:");
        emptyValue.or(() -> Optional.of("Default value"))
                .ifPresent(value -> {
                    System.out.println(value);
                });
    }


    private static void ifPresentOrElse(final Optional<String> existValue, final Optional<String> emptyValue) {
        System.out.println("ExistValue:");
        existValue.ifPresentOrElse(
                value -> {
                    int a = 100;
                    int b = 150;
                    int c = a + b;
                    System.out.println(value + " " + c);
                },
                () -> {
                    int a = 100;
                    int b = 150;
                    int c = a + b;
                    System.out.println("EmptyValue " + c);
                }
        );

        System.out.println("EmptyValue:");
        emptyValue.ifPresentOrElse(
                value -> {
                    int a = 100;
                    int b = 150;
                    int c = a + b;
                    System.out.println(value + " " + c);
                },
                () -> {
                    int a = 100;
                    int b = 150;
                    int c = a + b;
                    System.out.println("EmptyValue " + c);
                }
        );
    }

    private static void filter(final Optional<String> existValue, final Optional<String> emptyValue) {
        System.out.println("ExistValue:");
        final Optional<String> integer = existValue.filter(value -> {
            return value.length() > 2;
        });
        integer.ifPresent(value -> {
            System.out.println(value);
        });

        System.out.println("ExistValue 2:");
        existValue.filter(value -> {
            return value.length() > 20;
        }).ifPresent(value -> {
            System.out.println(value);
        });

        System.out.println("EmptyValue:");
        emptyValue.filter(value -> {
            return value.length() > 2;
        }).ifPresent(value -> {
            System.out.println(value);
        });
    }

    private static void map(final Optional<String> existValue, final Optional<String> emptyValue) {
        System.out.println("ExistValue:");
        final Optional<Integer> integer = existValue.map(value -> {
            int a = 100;
            int b = 150;
            return a + b;
        });
        integer.ifPresent(value -> {
            System.out.println(value);
        });

        integer.ifPresent(value -> System.out.println(value));

        System.out.println("EmptyValue:");
        emptyValue.map(value -> {
            int a = 100;
            int b = 150;
            return a + b;
        }).ifPresent(value -> {
            System.out.println(value);
        });
    }

    private static void orElseGet(final Optional<String> existValue, final Optional<String> emptyValue) {
        System.out.println("ExistValue:");
        System.out.println(existValue.orElseGet(() -> {
            return "Default value";
        }));

        existValue.orElseGet(() -> "Default value");

        System.out.println("EmptyValue:");
        System.out.println(emptyValue.orElseGet(() -> {
            int a = 100;
            int b = 150;
            int c = a + b;
            System.out.println(c);
            return "Default value";
        }));
    }

    private static void orElseThrow(final Optional<String> existValue, final Optional<String> emptyValue) {
        System.out.println("ExistValue:");
        System.out.println(existValue.orElseThrow(IllegalStateException::new));

        System.out.println("EmptyValue:");
        System.out.println(emptyValue.orElseThrow(() -> new IllegalStateException("IllegalStateException")));
    }

    private static void orElse(final Optional<String> existValue, final Optional<String> emptyValue) {
        System.out.println("ExistValue:");
        System.out.println(existValue.orElse("Default value"));

        System.out.println("EmptyValue:");
        System.out.println(emptyValue.orElse("Default value"));
    }

    private static void ifPresent(final Optional<String> existValue, final Optional<String> emptyValue) {
        System.out.println("ExistValue:");
        existValue.ifPresent(value -> {
            System.out.println(value);
        });

        System.out.println("EmptyValue:");
        emptyValue.ifPresent(value -> {
            System.out.println(value);
        });
    }

    private static void get(final Optional<String> existValue, final Optional<String> emptyValue) {
        System.out.println("ExistValue:");
        if (existValue.isPresent()) {
            System.out.println(existValue.get());
        }

        System.out.println("EmptyValue:");
        if (emptyValue.isPresent()) {
            System.out.println(emptyValue.get());
        }
    }

    private static Optional<String> getUserEmail(final int id) {
        if (id >= 0) {
            return Optional.of("value");
        } else {
            return Optional.empty();
        }
    }

    private static Optional<String> getUserEmailSecondWay(final int id) {
        final String email = id >= 0 ? "value" : null;
        return Optional.ofNullable(email);
    }

    private static String getUserEmailWrongWay(final int id) {
        return id >= 0 ? "value" : null;
    }
}
