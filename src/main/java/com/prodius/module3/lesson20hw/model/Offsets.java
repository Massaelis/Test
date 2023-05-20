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

    private final Student student;

    private final String studentId; // TODO: 20/05/23 remove

    private final Course course;

    private final String courseId; // TODO: 20/05/23 remove

    private final Date dateOffsets;

    private final String grade; // TODO: 20/05/23 remove
//    private final OffsetGrade offsetGrade;

    public Offsets(String idOffsets, Student student, final String studentId, Course course, final String courseId,
                   Date dateOffsets, String grade) {
        this.idOffsets = idOffsets;
        this.student = student;
        this.studentId = studentId;
        this.course = course;
        this.courseId = courseId;
        this.dateOffsets = dateOffsets;
        this.grade = grade;
    }
}