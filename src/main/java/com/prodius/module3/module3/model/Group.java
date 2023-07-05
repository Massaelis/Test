package com.prodius.module3.module3.model;

import com.prodius.module3.lesson22.model.Visit;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "groups")
@ToString
public class Group {
    @Id
    private String name;

    @OneToMany(mappedBy = "groups", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<Student> student;

    public void setStudent(final Set<Student> student) {
        this.student = student;
        student.forEach(student1 -> student1.setGroups(this));
    }
}