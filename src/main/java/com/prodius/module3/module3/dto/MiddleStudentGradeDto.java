package com.prodius.module3.module3.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
@Getter
@Setter
@ToString
public class MiddleStudentGradeDto {
    private String name;
    private BigDecimal middle_grade;
}
