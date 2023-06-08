package com.prodius.module3.lesson25hw.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class Student {

    @SerializedName("_id")
    private final ObjectId id;

    private final String name;

    private final LocalDate dateOfBirth;

    private final List<Course> courses;

    public Student(ObjectId id, String name, LocalDate dateOfBirth, List<Course> courses) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", courses=" + courses +
                '}';
    }
}