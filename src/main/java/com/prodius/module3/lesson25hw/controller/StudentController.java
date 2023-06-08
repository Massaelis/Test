package com.prodius.module3.lesson25hw.controller;

import com.prodius.module3.lesson25hw.service.StudentService;

public class StudentController {

    private static StudentController instance;

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    public static StudentController getInstance() {
        if (instance == null) {
            instance = new StudentController(StudentService.getInstance());
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

    public void updateOfId(String id) {
        service.updateOfId(id);
    }

    public void deleteOfId(String id) {
        service.deleteOfId(id);
    }
}