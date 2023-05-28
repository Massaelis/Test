package com.prodius.module3.lesson22hw.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigInteger;

@Getter
@Setter
@ToString
public class StudentSqlDTO {
    private final String name;
    private final BigInteger count;

    public StudentSqlDTO(String name, final long count) {
        this.name = name;
        this.count = BigInteger.valueOf(count);
    }
}