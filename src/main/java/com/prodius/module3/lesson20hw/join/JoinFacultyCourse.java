package com.prodius.module3.lesson20hw.join;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class JoinFacultyCourse {
    private final String facultyName;
    private final int countCourses;

    public JoinFacultyCourse(String facultyName, int countCourses) {
        this.facultyName = facultyName;
        this.countCourses = countCourses;
    }
}
