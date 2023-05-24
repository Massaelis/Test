package com.prodius.module3.lesson20hw.join;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
@Getter
@Setter
@ToString
public class JoinStudentCourse {
    private final String id;
    private final String name;
    private final String surname;
    private final Date date;
    private final String email;
    private final String facultyId;
    private final String groupNameCourse;
    private final int gradeResultExam;

    public JoinStudentCourse(String id, String name, String surname, Date date, String email,
                             String facultyId, String groupNameCourse, int gradeResultExam) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.date = date;
        this.email = email;
        this.facultyId = facultyId;
        this.groupNameCourse = groupNameCourse;
        this.gradeResultExam = gradeResultExam;
    }
}