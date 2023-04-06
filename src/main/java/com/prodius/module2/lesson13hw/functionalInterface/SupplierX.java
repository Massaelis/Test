package com.prodius.module2.lesson13hw.functionalInterface;

import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class SupplierX {
    private static final Random RANDOM = new Random();

    private static final List<String> LIST_NAME = List.of(
            "Batman",
            "Spider-Man",
            "Iron man",
            "Claptrap",
            "One punch man"
    );

    public static final Supplier<String> GET_NAME = () -> LIST_NAME.get(RANDOM.nextInt(LIST_NAME.size()));
}
