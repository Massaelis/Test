package com.prodius.module3.lesson23hw.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigInteger;

@Entity
@Getter
@Setter
@ToString
public class SumInTransportDTO {
    @Id
    private String sum_loadCapacity;

    private BigInteger sum_maintenanceCost;
}