package com.prodius.module2.lesson13hw;

import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.Random;
import java.util.function.BiPredicate;

@EqualsAndHashCode
public class Test {
    private final static Random RANDOM = new Random();
    public final static List<String> listString = List.of(
            "First",
            "Second",
            "Third",
            "Four"
    );

    private final static BiPredicate<String, String> firstEquals = String::equals;
    private final static BiPredicate<String, String> secondEquals = (firstString, secondString) -> {
        return secondString.equals(firstString);
    };
    public final static boolean equalsResult = firstEquals.test(listString.get(RANDOM.nextInt(listString.size())),
            listString.get(RANDOM.nextInt(listString.size())));

}
