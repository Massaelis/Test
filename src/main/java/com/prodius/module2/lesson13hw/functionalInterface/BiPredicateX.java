package com.prodius.module2.lesson13hw.functionalInterface;

import java.util.function.BiPredicate;

public class BiPredicateX {
    private final static BiPredicate<String, String> palindrome = (firstString, secondString) -> {
        return firstString.replaceAll("\\W", "")
                .equalsIgnoreCase(secondString.replaceAll("\\W", ""));
    };
    public final static boolean palindromeResult = palindrome.test("Anna", "an`na");
}
