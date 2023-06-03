package com.prodius.module3.lesson24hw.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class Group {
    private String id;
    private int countPerson;
    private String name;
    private LocalDate startDate;
    private String statusGroup;
}
