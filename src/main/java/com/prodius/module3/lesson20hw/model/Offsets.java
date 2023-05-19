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
    private final String idOffsets;
    private final String idStudent;
    private final String idCourse;
    private final Date dateOffsets;
    private final String grade;

    public Offsets(String idOffsets, String idStudent, String idCourse, Date dateOffsets, String grade) {
        this.idOffsets = idOffsets;
        this.idStudent = idStudent;
        this.idCourse = idCourse;
        this.dateOffsets = dateOffsets;
        this.grade = grade;
    }
}