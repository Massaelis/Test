package com.prodius.module3.lesson17hw.zoo;

import com.prodius.module3.lesson17hw.animal.Animal;
import lombok.ToString;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@ToString
public class Zoo<T extends Animal> {
    public final void add(final T object, final List<T> list) {
        try {
            list.add(object);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public final void remove(final T object, final List<T> list) {
        try {
            list.remove(object);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public final void makeAllSounds(final List<T> list) {
        for (Animal object : list) {
            object.makeSound();
        }
    }

    public final List<String> getAnimalNames(final List<T> list) {
        return list.stream()
                .map(Animal::getName)
                .peek(System.out::println)
                .collect(Collectors.toList());
    }

    public final List<Animal> getAnimalsSortedByName(final List<T> list) {
        return list.stream()
                .sorted(Comparator.comparing(Animal::getName))
                .peek(System.out::println)
                .collect(Collectors.toList());
    }

    public final void moveAllAnimals(final List<T> list) {
        for (Animal object : list) {
            object.move();
        }
    }

    public final void show(final List<T> list) {
        System.out.println(list);
    }
}