package com.prodius.module2.lesson11hw.treeSet;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Person {

    private final int age;

    private final String name;

    Person(final int age) {
        this.age = age;
        this.name = "Name" + Math.random();
    }
}
