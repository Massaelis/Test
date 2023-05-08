package com.prodius.module3.lesson17hw;

import com.prodius.module3.lesson17hw.animal.Cat;
import com.prodius.module3.lesson17hw.animal.Dog;
import com.prodius.module3.lesson17hw.zoo.Zoo;
import com.prodius.module3.lesson17hw.zoo.ZooManager;

public class Main {
    public static void main(String[] args) {
        Zoo<Dog> dogZoo = new Zoo<>();
        Dog dog1 = new Dog("Pushok", 5);
        Dog dog2 = new Dog("Alpha", 0);
        dogZoo.add(dog1);
        dogZoo.add(dog2);
        dogZoo.show();
        Dog dog22 = new Dog("Alpha", 0);
        dogZoo.remove(dog22);
        dogZoo.show();

        Zoo<Cat> catZoo = new Zoo<>();
        Cat cat1 = new Cat("Jofre", 10);
        Cat cat2 = new Cat("Zosia", 11);
        Cat cat3 = new Cat("Kyzia", 3);
        Cat cat4 = new Cat("Myrka", 14);

        catZoo.add(cat1);
        catZoo.add(cat2);
        catZoo.add(cat3);
        catZoo.add(cat4);

        System.out.println("~".repeat(10) + " All noise animal");
        catZoo.makeAllSounds();

        System.out.println("~".repeat(10) + " Animal name");
        catZoo.getAnimalNames();

        System.out.println("~".repeat(10) + " Sort by name");
        catZoo.getAnimalsSortedByName();

        System.out.println("~".repeat(10) + " All animal move");
        catZoo.moveAllAnimals();

        System.out.println("~".repeat(10) + " Show all list in manager list");
        ZooManager zooManager = new ZooManager();
        zooManager.add(dogZoo);
        zooManager.add(catZoo);
        zooManager.show();

        System.out.println("~".repeat(10) + " Sort by name all animal");
        zooManager.showAnimalsSortedByName();
    }
}
