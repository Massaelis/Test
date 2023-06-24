package com.prodius.module3.lesson26hw.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "person")
public class User {
    @Id
    private String id;

    private String name;

    private int age;

    private String telephoneNumber;

    @Override
    public String toString() {
        return "User{"
                + "id ='" + id
                + ", name=" + name
                + ", age=" + age
                + ", telephoneNumber=" + telephoneNumber
                + '}';
    }
}