package com.prodius.module3.lesson25.service;

import com.prodius.module3.lesson25.model.Animal;
import com.prodius.module3.lesson25.model.Cat;
import com.prodius.module3.lesson25.repository.CatRepository;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public class CatService {

    private static final Random RANDOM = new Random();

    private final CatRepository repository;

    private static CatService instance;

    private CatService(final CatRepository repository) {
        this.repository = repository;
    }

    public static CatService getInstance() {
        if (instance == null) {
            instance = new CatService(CatRepository.getInstance());
        }
        return instance;
    }

    public Set<String> createAndSave(final int count) {
        if (count <= 0 || count > 100) {
            throw new IllegalArgumentException("count must be between 1 and 100");
        }

        Set<Cat> cats = new HashSet<>();
        for (int i = 0; i < count; i++) {
            cats.add(created());
        }
        repository.insertMany(cats);
        return cats.stream()
                .map(Animal::getId)
                .collect(Collectors.toSet());
    }

    private Cat created() {
        final Cat cat = new Cat(
                UUID.randomUUID().toString(),
                "Cat-" + RANDOM.nextInt(100),
                RANDOM.nextInt(1, 30),
                LocalDate.now().minusDays(RANDOM.nextInt(1000)).plusDays(RANDOM.nextInt(1000)).toString()
        );
        cat.setWeight(RANDOM.nextDouble(1, 10));
        return cat;
    }

    public Set<Cat> getAll() {
        return repository.findAll();
    }
}
