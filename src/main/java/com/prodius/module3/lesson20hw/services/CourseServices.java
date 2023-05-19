package com.prodius.module3.lesson20hw.services;

import com.prodius.module3.lesson20hw.model.Course;
import com.prodius.module3.lesson20hw.repository.Crud;

public class CourseServices {
    private final Crud<Course, String> courseRepository;

    public CourseServices(Crud<Course, String> courseRepository) {
        this.courseRepository = courseRepository;
    }

    public void save(final Course course) {
        courseRepository.save(course);
    }

    public void printAll() {
        courseRepository.getAll().forEach(System.out::println);
    }
}