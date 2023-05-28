package com.prodius.module3.lesson22hw.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class StudentHqlDTO {
    private final String id;
    private final String name;
    private final String email;

    public StudentHqlDTO(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}