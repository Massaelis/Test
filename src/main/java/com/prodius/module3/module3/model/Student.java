package com.prodius.module3.module3.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
public class Student {
    @EmbeddedId
    private StudentKey studentKey;

    private int age;

    private LocalDate dateStartStudy;
    @ToString.Exclude
    @OneToMany(mappedBy = "student", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<Grade> grade;

    public void setGrade(final Set<Grade> grade) {
        this.grade = grade;
        grade.forEach(grade1 -> grade1.setStudent(this));
    }
    @ToString.Exclude
    @ManyToOne
    private Group groups;
}