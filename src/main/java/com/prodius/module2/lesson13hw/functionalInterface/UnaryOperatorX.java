package com.prodius.module2.lesson13hw.functionalInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

public class UnaryOperatorX {
    private final static UnaryOperator<Integer> negativeNumber = i -> i * -1;

    public final static List<Integer> listInt = List.of(
            10,
            20,
            30,
            40,
            50
    );

    public static List<Integer> list(List<Integer> list) {
        List<Integer> integerList = new ArrayList<>();
        for (Integer i : list) {
            integerList.add(negativeNumber.apply(i));
        }
        return integerList;
    }
}
