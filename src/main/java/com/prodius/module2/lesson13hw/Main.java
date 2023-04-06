package com.prodius.module2.lesson13hw;

import com.prodius.module2.lesson13hw.functionalInterface.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("~".repeat(10));
        System.out.println(SupplierX.getName.get());
        System.out.println("~".repeat(10));
        System.out.println(BiPredicateX.palindromeResult);
        System.out.println("~".repeat(10));
        ConsumerX.list(ConsumerX.listGame);
        System.out.println("~".repeat(10));
        System.out.println(FunctionX.list(FunctionX.listGame));
        System.out.println("~".repeat(10));
        System.out.println(UnaryOperatorX.list(UnaryOperatorX.listInt));
        System.out.println("~".repeat(10));
        MyOperator.gcd(10, 15);

        System.out.println(Test.equalsResult);
    }
}
