package com.prodius.module3.lesson20hw.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class JoinFacultyCourse {
    private final String facultyName;
    private final int countCourses;
}
