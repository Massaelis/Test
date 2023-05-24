package com.prodius.module3.lesson20hw.dto;

import com.prodius.module3.lesson20hw.model.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
@AllArgsConstructor
public class JoinStudentCourse {
    private final Student student;

    private final String groupNameCourse;
    private final int gradeResultExam;
}