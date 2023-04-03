package com.prodius.lesson12hw;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        final Service service = new Service();
        final List<Person> list = List.of(
                new Person(10),
                new Person(20),
                new Person(30),
                new Person(20),
                new Person(30),
                new Person(40),
                new Person(50),
                new Person(20)
        );
        final Map<Integer, Integer> map = service.litToMap(list);
        System.out.println(map);

        try {
            service.litToMap(Collections.singletonList(null));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            service.litToMap(Collections.singletonList(new Person(-4)));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}