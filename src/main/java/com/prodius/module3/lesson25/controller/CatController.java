package com.prodius.module3.lesson25.controller;

import com.prodius.module3.lesson25.service.CatService;

public class CatController {
    private static CatController instance;

    private final CatService service;

    private CatController(final CatService service) {
        this.service = service;
    }

    public static CatController getInstance() {
        if (instance == null) {
            instance = new CatController(CatService.getInstance());
        }
        return instance;
    }

    public void create(final Integer count) {
        if (count == null) {
            throw new IllegalArgumentException("count must not be null");
        }

        service.createAndSave(count).forEach(System.out::println);
    }

    public void printAll() {
        service.getAll().forEach(System.out::println);
    }
}
