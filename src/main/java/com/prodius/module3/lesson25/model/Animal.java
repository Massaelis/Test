package com.prodius.module3.lesson25.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Animal {

    @SerializedName("_id")
    private final String id;

    private final String registered; // TODO

    private String name;

    private int age;

    private Kennel kennel;

    protected Animal(final String id, final String name, final int age, final String registered) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.registered = registered;
        this.kennel = Kennel.PUBLIC;
    }
}
