package com.prodius.module3.lesson20hw.controller;


import com.prodius.module3.lesson20hw.services.StudentServices;

public class StudentController {
    private final StudentServices studentServices;

    public StudentController(StudentServices studentServices) {
        this.studentServices = studentServices;
    }
    private static final String FACULTY_FILE = "lesson20/student.csv";

    public void createFacultyFromFile() {
        studentServices.loadDataFromFile(FACULTY_FILE);
    }

    public void printAll() {
        studentServices.printAll();
    }
}