package com.prodius.module3.lesson22hw.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigInteger;

@Getter
@Setter
@ToString
public class StudentSqlDTO {
    private String name;

    private BigInteger studentcount;
}