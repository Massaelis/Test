package com.prodius.module3.lesson21.services;

import com.prodius.module3.lesson21.model.Student;
import com.prodius.module3.lesson21.repository.Crud;

public class StudentService { // WORK WITH BUSINESS

    private final Crud<Student, String> studentRepository;

    public StudentService(final Crud<Student, String> studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void save(final Student student) {
        if (student.getAge() <= 18) {
            throw new IllegalArgumentException("Student must be higher than 18, current: " + student.getAge());
        }
        studentRepository.save(student);
    }

    public void printAll() {
        studentRepository.getAll().forEach(System.out::println);
    }
}
