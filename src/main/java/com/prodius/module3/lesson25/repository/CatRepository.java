package com.prodius.module3.lesson25.repository;

import com.mongodb.client.model.Filters;
import com.prodius.module3.lesson25.model.Cat;

import java.util.Set;

public class CatRepository extends AbstractRepository<Cat> {

    private static final String COLLECTION_NAME = "cats";

    private static CatRepository instance;

    private CatRepository() {
        super(COLLECTION_NAME);
    }

    public static CatRepository getInstance() {
        if (instance == null) {
            instance = new CatRepository();
        }
        return instance;
    }

    public Set<Cat> findAll() {
        return super.findAll(Cat.class);
    }

    public Set<Cat> getCatsWithAge(final int age) {
        return super.findAll(Cat.class, Filters.eq("age", age));
    }
}
