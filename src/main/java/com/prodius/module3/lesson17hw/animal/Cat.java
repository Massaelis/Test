package com.prodius.module3.lesson17hw.animal;

import lombok.ToString;

@ToString(callSuper = true)
public class Cat extends Animal {
    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public void move() {
        System.out.println("Cat " + getName() + " move");
    }

    @Override
    public void makeSound() {
        System.out.println("мяу-мяу");
    }
}