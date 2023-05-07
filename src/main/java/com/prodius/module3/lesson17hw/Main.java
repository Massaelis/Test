package com.prodius.module3.lesson17hw;

import com.prodius.module3.lesson17hw.animal.Cat;
import com.prodius.module3.lesson17hw.animal.Dog;
import com.prodius.module3.lesson17hw.zoo.Zoo;

public class Main {
    public static void main(String[] args) {
        Dog dog1 = new Dog("Pushok", 5);
        Cat cat1 = new Cat("Jofre", 10);
        Cat cat2 = new Cat("Zosia", 11);

        Zoo zoo = new Zoo();

        zoo.add(dog1);
        zoo.add(cat1);
        zoo.add(cat2);
        System.out.println(zoo.getList());

        zoo.remove(cat2);

        System.out.println(zoo.getList());

        zoo.makeAllSounds();

        zoo.getAnimalNames();

        Dog dog2 = new Dog("Alpha", 0);
        zoo.add(dog2);
        zoo.getAnimalsSortedByName();

        zoo.moveAllAnimals();
    }
}
