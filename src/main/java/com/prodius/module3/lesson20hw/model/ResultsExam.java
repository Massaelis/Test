package com.prodius.module3.lesson20hw.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
@Getter
@Setter
@ToString
public class ResultsExam {
    //id_results_exam, id_student, id_course, date_exam, grade
    private final String id_results_exam;
    private final String id_student;
    private final String id_course;
    private final Date date_exam;
    private final int grade;

    public ResultsExam(String id_results_exam, String id_student, String id_course, Date date_exam, int grade) {
        this.id_results_exam = id_results_exam;
        this.id_student = id_student;
        this.id_course = id_course;
        this.date_exam = date_exam;
        this.grade = grade;
    }
}
