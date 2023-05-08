package com.prodius.module3.lesson17hw.zoo;

import com.prodius.module3.lesson17hw.animal.Animal;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@ToString
public class ZooManager {
    public final List<Zoo<? extends Animal>> listManager = new ArrayList<>();

    public final void add(final Zoo<? extends Animal> zoo) {
        if (Objects.isNull(zoo)) {
            throw new IllegalArgumentException("Zoo must not be null");
        }

        listManager.add(zoo);
    }

    public final void remove(final String zooId) {
        if (Objects.isNull(zooId)) {
            throw new IllegalArgumentException("Zoo id must not be null");
        }

        listManager.removeIf(innerZoo -> innerZoo.getId().equals(zooId));
    }

    public final void show() {
        listManager.stream()
                .flatMap(zoo -> zoo.getList().stream())
                .forEach(System.out::println);

    }

    public final void showAnimalsSortedByName() {
        listManager.stream()
                .flatMap(zoo -> zoo.getList().stream())
                .sorted(Comparator.comparing(Animal::getName))
                .forEach(System.out::println);
    }
}