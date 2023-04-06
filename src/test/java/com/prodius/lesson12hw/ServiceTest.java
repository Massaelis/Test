package com.prodius.lesson12hw;

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
        // TODO: 03/04/23

        final Map<Integer, Integer> expected = new HashMap<>();
        // TODO: 03/04/23

        // test method
        final Map<Integer, Integer> actual = target.litToMap(list);

        // checks
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void litToMapNullPerson() {
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

    @Test
    void litToMapNullAge() {
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