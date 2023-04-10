package com.prodius.module2.lesson14;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        final List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 7, 8, 9, 10);
        final Stream<Integer> stream = list.stream();
        stream.filter(x -> x >= 5)
                .peek(System.out::println)
                .sorted(Main::sort)
                .map(x -> "*" + x + "*")
                .distinct()
                .limit(5)
                .forEach(System.out::println);

        System.out.println(list);

        final boolean allMatch = list.stream().allMatch(x -> x > 0);
        System.out.println("allMatch " + allMatch);

        final boolean anyMatch = list.stream().anyMatch(x -> x == 7);
        System.out.println("anyMatch " + anyMatch);

        final boolean noneMatch1 = list.stream().noneMatch(x -> x == 7);
        System.out.println("noneMatch1 " + noneMatch1);
        final boolean noneMatch2 = list.stream().noneMatch(x -> x == 11);
        System.out.println("noneMatch2 " + noneMatch2);

        final long count = list.stream().count();
        System.out.println("count " + count);

        final Optional<Integer> findFirst = list.stream().findFirst();
        findFirst.ifPresent(System.out::println);

        final Optional<Integer> findAny = list.stream().findAny();
        findAny.ifPresent(System.out::println);

        final Optional<Integer> max = list.stream().max(Main::sort);
        max.ifPresent(System.out::println);

        final Optional<Integer> min = list.stream().min(Main::sort);
        min.ifPresent(System.out::println);

        final Integer[] numIntegers = list.stream().toArray(Integer[]::new);
        System.out.println(Arrays.toString(numIntegers));

        final Integer reduce = list.stream().reduce(1, (a, b) -> a * b);
        System.out.println(reduce);

        final IntSummaryStatistics intSummaryStatistics = list.stream()
                .mapToInt(value -> value)
                .summaryStatistics();
        System.out.println(intSummaryStatistics);

        Stream.of(new Cat(1), new Cat(2), new Cat(3))
                .mapToInt(Cat::getAge)
                .max()
                .ifPresent(System.out::println);

        final long count1 = Stream.of(new Cat(1), new Cat(2), new Cat(3))
                .mapToInt(Cat::getAge)
                .filter(age -> age >= 2)
                .boxed()
                .count();
        System.out.println(count1);


        final List<String> collect = list.stream().filter(x -> x >= 5)
                .peek(System.out::println)
                .sorted(Main::sort)
                .map(x -> "*" + x + "*")
                .distinct()
                .limit(5)
                .collect(Collectors.toList());

        final Map<Integer, Integer> map = list.stream()
                .collect(Collectors.toMap(x -> x, Function.identity(), (o, o2) -> o));
        System.out.println(map);

        final Map<Integer, List<Integer>> map1 = list.stream()
                .collect(Collectors.groupingBy(Function.identity()));
        System.out.println(map1);


        final Dog dog11 = new Dog(11);
        final Dog dog12 = new Dog(12);
        final Dog dog13 = new Dog(13);
        final Cat cat1 = new Cat(1, List.of(dog11, dog12, dog13));
        final Dog dog21 = new Dog(21);
        final Dog dog22 = new Dog(22);
        final Dog dog23 = new Dog(23);
        final Cat cat2 = new Cat(2, List.of(dog21, dog22, dog23));


        final List<List<Dog>> collect1 = Stream.of(cat1, cat2)
                .map(Cat::getDogs)
                .collect(Collectors.toList());

        final List<Dog> collect2 = Stream.of(cat1, cat2)
                .flatMap(cat -> cat.getDogs().stream())
                .collect(Collectors.toList());

        /*
        peek == foreach, not terminated
        map == convert A to B
        mapToInt == convert A to primitive int
        flatMap == convert inner list to outer stream
         */

    }

    private static int sort(final Integer x1, final Integer x2) {
        if (x1 % 2 == 0) {
            return -1;
        } else if (x1.equals(x2)) {
            return 0;
        } else {
            return 1;
        }
    }
}

@Getter
class Cat {
    private final int age;

    private List<Dog> dogs;

    Cat(final int age) {
        this.age = age;
    }

    Cat(final int age, final List<Dog> dogs) {
        this.age = age;
        this.dogs = dogs;
    }
}

@Getter
@AllArgsConstructor
class Dog {
    private int age;
}
