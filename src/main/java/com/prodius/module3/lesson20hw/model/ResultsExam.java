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

    private final Student student;

    private final String studentId; // TODO: 20/05/23 remove

    private final Course course;

    private final String courseId; // TODO: 20/05/23 remove

    private final Date dateExam;

    private final int grade;

    public ResultsExam(String idResultsExam, Student student, final String studentId, Course course, final String courseId, Date dateExam, int grade) {
        this.idResultsExam = idResultsExam;
        this.student = student;
        this.studentId = studentId;
        this.course = course;
        this.courseId = courseId;
        this.dateExam = dateExam;
        this.grade = grade;
    }
}