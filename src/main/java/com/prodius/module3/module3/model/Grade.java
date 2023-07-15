package com.prodius.module3.module3.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Embeddable
public class Grade implements Serializable {
    @Id
    @OneToOne(cascade = CascadeType.PERSIST)
    private Clazz clazz;

    private int grade;

    @ManyToOne
    private Student student;
}