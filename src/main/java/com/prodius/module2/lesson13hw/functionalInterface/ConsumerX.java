package com.prodius.module2.lesson13hw.functionalInterface;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerX {
    private final static Consumer<String> getUpperCase = string -> System.out.println(string.toUpperCase());

    public final static List<String> listGame = List.of(
            "The last of us",
            "God of war 3",
            "Uncharted 4",
            "AS: Odyssey",
            "Borderlands"
    );

    public static void list(List<String> list) {
        for (String s : list) {
            getUpperCase.accept(s);
        }
    }
}
