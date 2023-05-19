package com.prodius.module3.lesson20hw.services;

import com.prodius.module3.lesson20hw.model.Student;
import com.prodius.module3.lesson20hw.repository.Crud;

public class StudentServices {
    private final Crud<Student, String> studentRepository;

    public StudentServices(Crud<Student, String> studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void save(final Student student) {
        studentRepository.save(student);
    }

    public void printAll() {
        studentRepository.getAll().forEach(System.out::println);
    }
}