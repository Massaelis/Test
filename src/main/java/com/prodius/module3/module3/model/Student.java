package com.prodius.module3.module3.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
public class Student {
    @EmbeddedId
    private StudentKey studentKey;

    private int age;

    private LocalDate dateStartStudy;

    @OneToMany(mappedBy = "student", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<Grade> grade;

    public void setGrade(final Set<Grade> grade) {
        this.grade = grade;
        grade.forEach(grade1 -> grade1.setStudent(this));
    }

    @ManyToOne
    private Group groups;
}