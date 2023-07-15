package com.prodius.module3.module3.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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

    @ToString.Exclude
    @ManyToOne
    private Group groups;

    public void setGrade(final Set<Grade> grade) {
        this.grade = grade;
        grade.forEach(grade1 -> grade1.setStudent(this));
    }
}