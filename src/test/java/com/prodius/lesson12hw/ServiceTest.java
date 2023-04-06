package com.prodius.lesson12hw;

import com.prodius.module2.lesson12hw.Person;
import com.prodius.module2.lesson12hw.Service;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ServiceTest {

    private Service target;

    @BeforeEach
    void setUp() {
        target = new Service();
    }

    @Test
    void litToMapSuccess() {
        // initialization
        final List<Person> list = new ArrayList<>();
        list.add(new Person(10));
        list.add(new Person(10));
        list.add(new Person(30));
        list.add(new Person(40));

        final Map<Integer, Integer> expected = new HashMap<>();
        expected.put(10, 2);
        expected.put(30, 1);
        expected.put(40, 1);

        // test method
        final Map<Integer, Integer> actual = target.litToMap(list);

        // checks
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void litToMapNullPerson() {
        // initialization
        final List<Person> list = new ArrayList<>();
        list.add(null);

        // test method
        // checks
        Assertions.assertThrowsExactly(
                IllegalArgumentException.class,
                () -> target.litToMap(list),
                "List contains null"
        );
    }

    @Test
    void litToMapNullAge() {
        // initialization
        final List<Person> list = new ArrayList<>();
        list.add(new Person(null));


        // test method
        // checks
        Assertions.assertThrowsExactly(
                IllegalArgumentException.class,
                () -> target.litToMap(list),
                "Negative age is not allowed"
        );
    }

    @Test
    void litToMapEmptyList() {
        // initialization
        final List<Person> list = new ArrayList<>();

        final Map<Integer, Integer> expected = new HashMap<>();

        // test method
        final Map<Integer, Integer> actual = target.litToMap(list);

        // checks
        Assertions.assertEquals(expected, actual);
    }
}