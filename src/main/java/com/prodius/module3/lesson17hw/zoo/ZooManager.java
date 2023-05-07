package com.prodius.module3.lesson17hw.zoo;

import com.prodius.module3.lesson17hw.animal.Animal;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@ToString
public class ZooManager<T extends Animal> extends Zoo {
    public final List<List<T>> listManager = new ArrayList<>();

    public final void add(final List<T> object) {
        try {
            listManager.add(object);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public final void remove(final List<T> object) {
        try {
            listManager.remove(object);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public final void show() {
        System.out.println(listManager);
    }

    public final List<Animal> getAnimalsSortedByName() {
        return listManager.stream()
                .flatMap(list -> list.stream().sorted(Comparator.comparing(Animal::getName)))
                .peek(System.out::println)
                .collect(Collectors.toList());
    }
}