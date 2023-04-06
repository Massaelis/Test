package com.prodius.module2.lesson13hw.functionalInterface;

import java.util.function.Consumer;

public class ConsumerX {
    public static final Consumer<String> GET_UPPER_CASE = string -> System.out.println(string.toUpperCase());
}
