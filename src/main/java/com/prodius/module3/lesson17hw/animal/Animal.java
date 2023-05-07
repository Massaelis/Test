package com.prodius.module3.lesson17hw.animal;

import lombok.Getter;

@Getter
public abstract class Animal {
    public String name;
    public abstract void move();
    public abstract void makeSound();
}
