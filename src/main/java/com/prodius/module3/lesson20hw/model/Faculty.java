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
    private final String facultyName;
    private final String dean;

    public Faculty(String id, String facultyName, String dean) {
        this.id = id;
        this.facultyName = facultyName;
        this.dean = dean;
    }
}