package com.prodius.module2.lesson13hw.functionalInterface;

import java.util.function.BiPredicate;

public class BiPredicateX {
    public static final BiPredicate<String, String> PALINDROME = (firstString, secondString) ->
            firstString.replaceAll("\\W", "")
                    .equalsIgnoreCase(secondString.replaceAll("\\W", ""));
}
