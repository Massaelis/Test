package com.prodius.module3.lesson20hw.join;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class JoinFacultyStudent {
    private final String facultyName;

    public JoinFacultyStudent(String facultyName) {
        this.facultyName = facultyName;
    }
}
