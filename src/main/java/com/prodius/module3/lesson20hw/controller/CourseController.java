package com.prodius.module3.lesson20hw.controller;

import com.prodius.module3.lesson20hw.services.CourseServices;

public class CourseController {
    private final CourseServices courseServices;

    public CourseController(CourseServices courseServices) {
        this.courseServices = courseServices;
    }

    private static final String FACULTY_FILE = "lesson20/course.csv";

    public void createFacultyFromFile() {
        courseServices.loadDataFromFile(FACULTY_FILE);
    }

    public void getDataAboutCourse() {
        courseServices.getDataAboutCourse().forEach(System.out::println);
    }
}