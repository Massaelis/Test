package com.prodius.module3.lesson21.controllers;

import com.prodius.module3.lesson21.model.Student;
import com.prodius.module3.lesson21.services.StudentService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StudentController {
    private final StudentService studentService;

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public StudentController(final StudentService studentService) {
        this.studentService = studentService;
    }

    public void createStudent() {
        try {
            final Student student = new Student();
            System.out.println("Write student.csv name");
            student.setName(reader.readLine());
            System.out.println("Write student.csv age");
            student.setAge(Integer.parseInt(reader.readLine()));

            studentService.save(student);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void printAll() {
        studentService.printAll();
    }
}
