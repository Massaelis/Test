package com.prodius.lesson12hw;

import com.prodius.module2.lesson12hw.Person;
import com.prodius.module2.lesson12hw.Service;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

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
        list.add( new Person(10));
        list.add( new Person(10));
        list.add( new Person(30));
        list.add( new Person(40));

        final Map<Integer, Integer> expected = new HashMap<>();
        expected.put(10,2);
        expected.put(30,1);
        expected.put(40,1);

        // test method
        final Map<Integer, Integer> actual = target.litToMap(list);

        // checks
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void litToMapNullPerson() {
        // initialization
        final List<Person> list = new ArrayList<>();
        list.add( new Person(10));
        list.add( new Person(10));
        list.add( new Person(30));
        list.add(null);

        final Map<Integer, Integer> expected = new HashMap<>();
        expected.put(10,2);
        expected.put(30,1);

        // test method
        final Map<Integer, Integer> actual = target.litToMap(list);

        // checks
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void litToMapNullAge() {
        // initialization
        final List<Person> list = new ArrayList<>();
        list.add( new Person(10));
        list.add( new Person(10));
        list.add( new Person(30));
        list.add( new Person(null));

        final Map<Integer, Integer> expected = new HashMap<>();
        expected.put(10,2);
        expected.put(30,1);

        // test method
        final Map<Integer, Integer> actual = target.litToMap(list);

        // checks
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void litToMapEmptyList() {
        // initialization
        final List<Person> list = new ArrayList<>();
        // TODO: 03/04/23

        final Map<Integer, Integer> expected = new HashMap<>();
        // TODO: 03/04/23

        // test method
        final Map<Integer, Integer> actual = target.litToMap(list);

        // checks
        Assertions.assertEquals(expected, actual);
    }
}