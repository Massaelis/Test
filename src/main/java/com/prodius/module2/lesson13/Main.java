package com.prodius.module2.lesson13;

import lombok.Getter;
import lombok.ToString;

import java.util.Optional;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {

    private static String decode3 = "~~~";

    public static void main(String[] args) {
        final Predicate<Integer> p1 = p -> true; // compliant
        final Predicate<Integer> p2 = (p) -> true; // non-compliant
        final Predicate<Integer> p3 = (Integer p) -> true; // non-compliant
        final Predicate<?> p4 = (Integer p) -> true; // compliant*
        final BiPredicate<Integer, Integer> p5 = (a, b) -> a.equals(b); // compliant
//        final BiPredicate<Integer, Integer> p6 = a, b -> a.equals(b); // ERROR
        final Predicate<Integer> p7 = p -> {
            return true;
        }; // non-compliant
        final Predicate<Integer> p8 = p -> {
            System.out.println("test");
            return true;
        }; // compliant
        final Consumer<String> p9 = p -> System.out.println(p); // compliant
        final Consumer<String> p20 = p -> {
            System.out.println(p);
            System.out.println(p);
        }; // non-compliant
        final Consumer<String> p21 = p -> {
            if (p == null) {
                return;
            }
            int a = 0;
            if (p.equals("")) {
                p = "qwerty";
                a = 100;
            }
            System.out.println(p);
        }; // compliant

        final Optional<Integer> integerOptional = Optional.of(5);
        if (integerOptional.isPresent()) {
            System.out.println(integerOptional.get());
        }

        integerOptional.ifPresent(number -> System.out.println(number));

        integerOptional.ifPresent(System.out::println);

        integerOptional.ifPresent(number -> System.out.println("*" + number + "*"));


        Optional.of(5)
                .map(Cat::new)
                .ifPresent(System.out::println);

        final Mapper<Cat, String> mapper1 = new Mapper<>() {
            @Override
            public String map(final Cat value) {
                return value.toString();
            }
        };

        final Mapper<Cat, String> mapper2 = value -> value.toString();
        final Mapper<Cat, String> mapper3 = Cat::toString;
        System.out.println(mapper3.map(new Cat(10)));

        final String decode1 = "***";
        final Mapper<Cat, String> mapper4 = cat -> decode1 + cat + decode1;

        String decode2 = "***";
        final Mapper<Cat, String> mapper5 = cat -> decode2 + cat + decode3;
//         decode2 = "-";
        decode3 = "^^^^";


    }
}

@Getter
@ToString
class Cat {
    private final int age;

    public Cat(final int age) {
        this.age = age;
    }
}

@FunctionalInterface
interface Mapper<I, O> {
    O map(final I value);

//    void map1(); ERROR

    String toString();

    default void map2() {

    }

    static void map3() {

    }
}
