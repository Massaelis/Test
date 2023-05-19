package com.prodius.module3.lesson20hw.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
@Getter
@Setter
@ToString
public class Student {
   // id, name, surname, date, email, id_faculty
    private final String id;
    private final String name;
    private final String surname;
    private final Date date;
    private final String email;
    private final String idFaculty;

    public Student(String id, String name, String surname, Date date, String email, String idFaculty) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.date = date;
        this.email = email;
        this.idFaculty = idFaculty;
    }
}