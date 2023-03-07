package com.prodius.lesson6;

import java.util.Arrays;

public class Polymorphism {
    public static void main(String[] args) {
        final Animal cat = new Cat();
        final Animal dog = new Dog();

        final Animal[] animals = new Animal[] { cat, dog };

        Arrays.stream(animals).forEach(animal -> animal.live(2));

        final Cat realCat = new Cat();
        realCat.meow();
        if (cat instanceof final Cat realCat2) {
            System.out.println("realCat2 from Cat");
        }
        if (cat instanceof Dog) {
            final Cat realCat2 = (Cat) dog;
            System.out.println("realCat2 from Dog");
        }

        byte a = 8;
        int b = a;
        a = (byte) b;
        System.out.println(a);

    }
}

abstract class Animal {
    public void live(final int count) {
        for (int i = 0; i < count; i++) {
            eat();
            sleep();
        }
        System.out.println("Dead :(");
    }

    protected abstract void eat();

    protected abstract void sleep();
}

class Cat extends Animal {
    @Override
    protected void eat() {
        System.out.println(Cat.class.getSimpleName() + " is eating");
    }

    @Override
    protected void sleep() {
        System.out.println(Cat.class.getSimpleName() + " is sleeping");
    }

    public void meow() {
        System.out.println(Cat.class.getSimpleName() + " meow");
    }
}

class Dog extends Animal {
    @Override
    protected void eat() {
        System.out.println(Dog.class.getSimpleName() + " is eating");
    }

    @Override
    protected void sleep() {
        System.out.println(Dog.class.getSimpleName() + " is sleeping");
    }
}

