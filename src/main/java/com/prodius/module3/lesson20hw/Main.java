package com.prodius.module3.lesson20hw;

import com.prodius.module3.lesson20hw.controller.*;
import com.prodius.module3.lesson20hw.model.*;
import com.prodius.module3.lesson20hw.repository.*;
import com.prodius.module3.lesson20hw.services.*;


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

//        courseController.createFacultyFromFile();
//        courseController.printAll();

        final Crud<Student, String> studentRepository = new StudentRepository();
        final StudentServices studentServices = new StudentServices(studentRepository);
        final StudentController studentController = new StudentController(studentServices);

//        studentController.createFacultyFromFile();
//        studentController.printAll();

        final Crud<Offsets, String> offsetsRepository = new OffsetsRepository();
        final OffsetsServices offsetsServices = new OffsetsServices(offsetsRepository);
        final OffsetsController offsetsController = new OffsetsController(offsetsServices);

//        offsetsController.createFacultyFromFile();
//        offsetsController.printAll();

        final Crud<ResultsExam, String> resultsExamRepository = new ResultsExamRepository();
        final ResultsExamServices resultsExamServices = new ResultsExamServices(resultsExamRepository);
        final ResultsExamController resultsExamController = new ResultsExamController(resultsExamServices);

//        resultsExamController.createFacultyFromFile();
        resultsExamController.printAll();
    }
}