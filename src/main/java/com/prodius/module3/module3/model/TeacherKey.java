package com.prodius.module3.module3.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
@Getter
@Setter
@ToString
public class TeacherKey implements Serializable {

    private String name;

    private String surname;
}