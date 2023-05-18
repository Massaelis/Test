package com.prodius.module3.lesson20hw;

import com.prodius.module3.lesson20hw.controller.CourseController;
import com.prodius.module3.lesson20hw.controller.FacultyController;
import com.prodius.module3.lesson20hw.createTable.CreateTable;
import com.prodius.module3.lesson20hw.model.Course;
import com.prodius.module3.lesson20hw.model.Faculty;
import com.prodius.module3.lesson20hw.repository.CourseRepository;
import com.prodius.module3.lesson20hw.repository.Crud;
import com.prodius.module3.lesson20hw.repository.FacultyRepository;
import com.prodius.module3.lesson20hw.services.CourseServices;
import com.prodius.module3.lesson20hw.services.FacultyServices;


import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        final CreateTable createTable = new CreateTable();
//        createTable.createTable();

        final Crud<Faculty, String> facultyRepository = new FacultyRepository();
        final FacultyServices facultyServices = new FacultyServices(facultyRepository);
        final FacultyController facultyController = new FacultyController(facultyServices);

//        facultyController.createFacultyFromFile();
//        facultyController.printAll();


        final Crud<Course, String> courseRepository = new CourseRepository();
        final CourseServices courseServices = new CourseServices(courseRepository);
        final CourseController courseController = new CourseController(courseServices);

        courseController.createFacultyFromFile();
        courseController.printAll();
    }
}