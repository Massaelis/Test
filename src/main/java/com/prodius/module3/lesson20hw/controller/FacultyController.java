package com.prodius.module3.lesson20hw.controller;

import com.prodius.module3.lesson20hw.services.FacultyServices;

public class FacultyController {
    private final FacultyServices facultyServices;

    public FacultyController(FacultyServices facultyServices) {
        this.facultyServices = facultyServices;
    }

    private static final String FACULTY_FILE = "lesson20/faculty.csv";

    public void createFacultyFromFile() {
        facultyServices.loadDataFromFile(FACULTY_FILE);
    }

    public void getFacultyWithMoreThen() {
        facultyServices.getFacultyWithMoreThen(1);
    }

    public void getFacultyWithCountCourses() {
        facultyServices.getFacultyWithCountCourses().forEach(System.out::println);
    }
}