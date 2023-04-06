package com.prodius.lesson12hw;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Service {

    public Map<Integer, Integer> litToMap(final List<Person> list) {
        final Map<Integer, Integer> map = new HashMap<>();

        for (Person person : list) {
            Optional.ofNullable(person).ifPresentOrElse(
                    p -> Optional.ofNullable(p.getAge())
                            .filter(age -> age >= 0)
                            .ifPresentOrElse(
                                    age -> {
                                        if (map.containsKey(age)) {
                                            map.merge(age, 1, (oldVal, newVal) -> oldVal + newVal);
                                        } else {
                                            map.putIfAbsent(age, 1);
                                        }
                                    },
                                    () -> {
                                        throw new IllegalArgumentException("Negative age is not allowed");
                                    }
                            ),
                    () -> {
                        throw new IllegalArgumentException("List contains null");
                    }
            );
        }

        return map;
    }
}
