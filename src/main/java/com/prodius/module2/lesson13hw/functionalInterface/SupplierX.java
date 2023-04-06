package com.prodius.module2.lesson13hw.functionalInterface;

import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class SupplierX {
    private final static Random RANDOM = new Random();
    private final static List<String> listName = List.of(
            "Batman",
            "Spider-Man",
            "Iron man",
            "Claptrap",
            "One punch man"
    );
    public final static Supplier<String> getName = () -> listName.get(RANDOM.nextInt(listName.size()));
}
