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
    private final String idResultsExam;
    private final String idStudent;
    private final String idCourse;
    private final Date dateExam;
    private final int grade;

    public ResultsExam(String idResultsExam, String idStudent, String idCourse, Date dateExam, int grade) {
        this.idResultsExam = idResultsExam;
        this.idStudent = idStudent;
        this.idCourse = idCourse;
        this.dateExam = dateExam;
        this.grade = grade;
    }
}