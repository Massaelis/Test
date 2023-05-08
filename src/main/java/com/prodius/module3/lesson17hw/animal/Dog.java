package com.prodius.module3.lesson17hw.animal;

import lombok.ToString;

@ToString(callSuper = true)
public class Dog extends Animal {

    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public void move() {
        System.out.println("Dog " + getName() + " move");
    }

    @Override
    public void makeSound() {
        System.out.println("гав-гав");
    }
}