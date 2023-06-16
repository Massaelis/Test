package com.prodius.module3.lesson25.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cat extends Animal {

    private double weight;

    public Cat(final String id, final String name, final int age, final String registered) {
        super(id, name, age, registered);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "id='" + getId() + '\'' +
                ", registered='" + getRegistered() + '\'' +
                ", name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", kennel=" + getKennel() +
                ", weight=" + weight +
                '}';
    }
}
