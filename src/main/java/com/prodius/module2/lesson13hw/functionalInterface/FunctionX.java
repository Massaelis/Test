package com.prodius.module2.lesson13hw.functionalInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionX {
    private final static Function<String, Integer> changeStringToInteger = string -> string.length();
    public final static List<String> listGame = List.of(
            "The last of us",
            "God of war 3",
            "Uncharted 4",
            "AS: Odyssey",
            "Borderlands"
    );

    public static List<Integer> list(List<String> list) {
        List<Integer> integerList = new ArrayList<>();
        for (String s : list) {
            integerList.add(changeStringToInteger.apply(s));
        }
        return integerList;
    }
}
