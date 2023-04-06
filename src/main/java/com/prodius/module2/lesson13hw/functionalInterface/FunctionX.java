package com.prodius.module2.lesson13hw.functionalInterface;

import java.util.function.Function;

public class FunctionX {
    public static final Function<String, Integer> STRING_INTEGER_FUNCTION = String::length;
}
