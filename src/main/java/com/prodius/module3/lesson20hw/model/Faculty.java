package com.prodius.module3.lesson20hw.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Faculty {
    //id, faculty_name, dean
    private final String id;
    private final String faculty_name;
    private final String dean;

    public Faculty(String id, String faculty_name, String dean) {
        this.id = id;
        this.faculty_name = faculty_name;
        this.dean = dean;
    }
}
