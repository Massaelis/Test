package com.prodius.module3.lesson17hw.zoo;

import com.prodius.module3.lesson17hw.animal.Animal;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@ToString
public class Zoo <T extends Animal>{
    @Getter
    private final List<T> list = new ArrayList<>();

    public final void add(T object){
        try {
            list.add(object);
        }catch (IllegalArgumentException e){
            e.printStackTrace();
        }
    }
    public final void remove(T object){
        try {
            list.remove(object);
        }catch (IllegalArgumentException e){
            e.printStackTrace();
        }
    }

    public final void makeAllSounds(){
        for (Animal object : list){
            object.makeSound();
        }
    }
    public final List<String> getAnimalNames(){
        return list.stream()
                .map(Animal::getName)
                .peek(System.out::println)
                .collect(Collectors.toList());
    }

    public final List<Animal> getAnimalsSortedByName(){
        return list.stream()
                .sorted(Comparator.comparing(Animal::getName))
                .peek(System.out::println)
                .collect(Collectors.toList());


    }
    public final void moveAllAnimals(){
        for (Animal object : list){
            object.move();
        }
    }
}
