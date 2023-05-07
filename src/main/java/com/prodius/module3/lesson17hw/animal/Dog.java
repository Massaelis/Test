package com.prodius.module3.lesson17hw.animal;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class Dog extends Animal {
    public final String name;
    private final int age;
    public Dog(String name, int age){
        this.name = name;
        this.age = age;
    }
    @Override
    public void move() {
        System.out.println("Dog " + getName()+ " move");
    }

    @Override
    public void makeSound() {
        System.out.println("гав-гав");
    }
}
