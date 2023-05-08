package com.prodius.module3.lesson17hw.zoo;

import com.prodius.module3.lesson17hw.animal.Animal;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
public class Zoo<T extends Animal> {

    private final String id = UUID.randomUUID().toString();

    private final List<T> list = new ArrayList<>();

    public final void add(final T animal) {
        if (Objects.isNull(animal)) {
            throw new IllegalArgumentException("animal cannot be null");
        }

        list.add(animal);
    }

    public final void remove(final T animal) {
        if (Objects.isNull(animal)) {
            throw new IllegalArgumentException("animal cannot be null");
        }

        list.remove(animal);
    }

    public final void makeAllSounds() {
        list.forEach(Animal::makeSound);
    }

    public final void moveAllAnimals() {
        list.forEach(Animal::move);
    }

    public final List<String> getAnimalNames() {
        return list.stream()
                .map(Animal::getName)
                .peek(System.out::println)
                .collect(Collectors.toList());
    }

    public final List<Animal> getAnimalsSortedByName() {
        return list.stream()
                .sorted(Comparator.comparing(Animal::getName))
                .peek(System.out::println)
                .collect(Collectors.toList());
    }

    public final void show() {
        System.out.println(list);
    }
}