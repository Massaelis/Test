package com.prodius.module3.lesson22.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
public class CountCustomerDTO {
    private BigInteger c;

    public CountCustomerDTO(final long c) {
        this.c = BigInteger.valueOf(c);
    }

    public CountCustomerDTO() {
    }
}
