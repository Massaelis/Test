package com.prodius.module3.module3.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
@ToString
public class Teacher {
    @EmbeddedId
    private TeacherKey teacherKey;

    private int age;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Clazz clazz;
}
