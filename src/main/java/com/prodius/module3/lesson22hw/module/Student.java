package com.prodius.module3.lesson22hw.module;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
public class Student {
    @Id
//    @GeneratedValue(generator = "UUID")
//    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(length = 50)
    private String name;

    @Column(length = 50)
    private String surname;

    private LocalDate dateOfBirth;

    @Column(unique = true, length = 100)
    private String email;

    private int age;
}