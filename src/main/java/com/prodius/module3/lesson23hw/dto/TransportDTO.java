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
public class TransportDTO {
    @Id
    public String id;

    public String dtype;

    public int loadCapacity;

    public int maintenanceCost;

    public BigInteger sizeTank;

    public BigInteger countWagon;

    public BigInteger countCrew;

    public String name;
}