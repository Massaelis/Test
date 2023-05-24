package com.prodius.module3.lesson21.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@ToString
public class Student { // ONLY CONTAINS DATA
    private final String id;

    private String name;

    private int age;

    public Student() {
        this.id = UUID.randomUUID().toString();
    }

    public Student(final String id) {
        this.id = id;
    }
}