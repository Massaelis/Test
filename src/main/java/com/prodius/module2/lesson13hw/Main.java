package com.prodius.module2.lesson13hw;

import com.prodius.module2.lesson13hw.functionalInterface.BiPredicateX;
import com.prodius.module2.lesson13hw.functionalInterface.ConsumerX;
import com.prodius.module2.lesson13hw.functionalInterface.FunctionX;
import com.prodius.module2.lesson13hw.functionalInterface.MyOperator;
import com.prodius.module2.lesson13hw.functionalInterface.SupplierX;
import com.prodius.module2.lesson13hw.functionalInterface.UnaryOperatorX;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("~".repeat(10));
        System.out.println(SupplierX.GET_NAME.get());
        System.out.println("~".repeat(10));
        System.out.println(BiPredicateX.PALINDROME.test("Anna", "An na"));
        System.out.println("~".repeat(10));
        ConsumerX.GET_UPPER_CASE.accept("Anna");
        System.out.println("~".repeat(10));
        System.out.println(FunctionX.STRING_INTEGER_FUNCTION.apply("Anna"));
        System.out.println("~".repeat(10));
        System.out.println(UnaryOperatorX.NEGATIVE_NUMBER.apply(10));
        System.out.println("~".repeat(10));
        MyOperator.gcd(10, 15);

        List<String> listString = new ArrayList<>();
        listString.add("First");
        listString.add("Second");
        listString.add("Third");
        listString.add("Four");

        final Test test = new Test();
        for (int i = 0; i < 5; i++) {
            test.sortList(listString);
            System.out.println(listString);
        }


    }
}
