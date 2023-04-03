package com.prodius.lesson12hw;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

class ServiceTest {

    private Service target;
    @BeforeEach
    void setUp() {
        target = new Service();
    }

    @Test
    void checkPersonAgeValue() {
        final Map<Person, Integer> map = new HashMap<>();
        map.put(new Person(10), null);
        ArrayList<Integer> values = new ArrayList<>(map.values());
        Optional<ArrayList> result = target.checkPersonAgeValue(values);
        Assertions.assertEquals(values, result);
    }
}