package com.prodius.module3.lesson17hw.animal;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public abstract class Animal {
    private final String name;

    private final int age;

    public Animal(final String name, final int age) {
        this.name = name;
        this.age = age;
    }

    public abstract void move();

    public abstract void makeSound();
}