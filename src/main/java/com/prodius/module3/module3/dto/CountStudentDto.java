package com.prodius.module3.module3.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.math.BigInteger;

@Getter
@Setter
@ToString
public class CountStudentDto {
    private String name;
    private BigInteger student_count;
}