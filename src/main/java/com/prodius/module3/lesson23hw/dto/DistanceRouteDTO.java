package com.prodius.module3.lesson23hw.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@ToString
public class DistanceRouteDTO {
    @Id
    private int distance;
}