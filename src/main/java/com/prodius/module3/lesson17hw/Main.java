package com.prodius.module3.lesson17hw;

import com.prodius.module3.lesson17hw.animal.Animal;
import com.prodius.module3.lesson17hw.animal.Cat;
import com.prodius.module3.lesson17hw.animal.Dog;
import com.prodius.module3.lesson17hw.zoo.Zoo;
import com.prodius.module3.lesson17hw.zoo.ZooManager;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Zoo<Animal> zoo = new Zoo<>();
        ZooManager<Animal> zooManager = new ZooManager<>();

        final List<Animal> list1 = new ArrayList<>();
        final List<Animal> list2 = new ArrayList<>();
        final List<Animal> list3 = new ArrayList<>();

        Dog dog1_1 = new Dog("Pushok", 5);
        Dog dog2_1 = new Dog("Alpha", 0);
        Cat cat1_1 = new Cat("Jofre", 10);
        Cat cat2_1 = new Cat("Zosia", 11);

        Cat cat1_2 = new Cat("Kyzia", 3);

        Cat cat1_3 = new Cat("Myrka", 14);

        zoo.add(dog1_1, list1);
        zoo.add(cat1_1, list1);
        zoo.add(cat2_1, list1);
        zoo.add(dog2_1, list1);
        zoo.remove(cat2_1, list1);
        zoo.show(list1);

        System.out.println("~".repeat(10) + " All noise animal");

        zoo.makeAllSounds(list1);

        System.out.println("~".repeat(10) + " Animal name");

        zoo.getAnimalNames(list1);

        System.out.println("~".repeat(10) + " Sort by name");

        zoo.getAnimalsSortedByName(list1);

        System.out.println("~".repeat(10) + " All animal move");

        zoo.moveAllAnimals(list1);

        System.out.println("~".repeat(10) + " Show all list in manager list");

        zoo.add(cat1_2, list2);
        zoo.add(cat1_3, list3);

        zooManager.add(list1);
        zooManager.add(list2);
        zooManager.add(list3);

        zooManager.show();

        System.out.println("~".repeat(10) + " Remove some list in manager list");

        zooManager.remove(list2);

        zooManager.show();

        System.out.println("~".repeat(10) + " Sort by name all animal");

        zooManager.getAnimalsSortedByName();
    }
}
