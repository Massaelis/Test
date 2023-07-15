package com.prodius.module3.module3.model;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
@Getter
@Setter
@ToString
public class StudentKey implements Serializable {

    private String name;

    private String surname;
}