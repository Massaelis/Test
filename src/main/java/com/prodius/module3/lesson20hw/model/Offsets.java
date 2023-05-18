package com.prodius.module3.lesson20hw.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
@Getter
@Setter
@ToString
public class Offsets {
    //id_offsets, id_student, id_course, date_offsets, grade
    private final String id_offsets;
    private final String id_student;
    private final String id_course;
    private final Date date_offsets;
    private final String grade;

    public Offsets(String id_offsets, String id_student, String id_course, Date date_offsets, String grade) {
        this.id_offsets = id_offsets;
        this.id_student = id_student;
        this.id_course = id_course;
        this.date_offsets = date_offsets;
        this.grade = grade;
    }
}
