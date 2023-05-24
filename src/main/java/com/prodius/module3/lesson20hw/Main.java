package com.prodius.module3.lesson20hw;

import com.prodius.module3.lesson20hw.controller.CourseController;
import com.prodius.module3.lesson20hw.controller.FacultyController;
import com.prodius.module3.lesson20hw.controller.OffsetsController;
import com.prodius.module3.lesson20hw.controller.ResultsExamController;
import com.prodius.module3.lesson20hw.controller.StudentController;
import com.prodius.module3.lesson20hw.createTable.CreateTable;
import com.prodius.module3.lesson20hw.model.Student;
import com.prodius.module3.lesson20hw.repository.CourseRepository;
import com.prodius.module3.lesson20hw.repository.Crud;
import com.prodius.module3.lesson20hw.repository.FacultyRepository;
import com.prodius.module3.lesson20hw.repository.OffsetsRepository;
import com.prodius.module3.lesson20hw.repository.ResultsExamRepository;
import com.prodius.module3.lesson20hw.repository.StudentRepository;
import com.prodius.module3.lesson20hw.services.CourseServices;
import com.prodius.module3.lesson20hw.services.FacultyServices;
import com.prodius.module3.lesson20hw.services.OffsetsServices;
import com.prodius.module3.lesson20hw.services.ResultsExamServices;
import com.prodius.module3.lesson20hw.services.StudentServices;

public class Main {
    public static void main(String[] args) {
        final CreateTable createTable = new CreateTable();
        createTable.createTable();

        final FacultyController facultyController = initFacultyDomain();
        final CourseController courseController = initCourseDomain();
        final StudentController studentController = initStudentDomain();
        final OffsetsController offsetsController = initOffsetsDomain();
        final ResultsExamController resultsExamController = initResultsExamDomain();

        facultyController.getFacultyWithMoreThen();
//        facultyController.getFacultyWithCountCourses();
//        courseController.getDataAboutCourse();
//        offsetsController.getCompletedOffset();
//        resultsExamController.getHighGrade();
    }

    private static FacultyController initFacultyDomain() {
        final FacultyRepository facultyRepository = new FacultyRepository();
        final FacultyServices facultyServices = new FacultyServices(facultyRepository);
        final FacultyController facultyController = new FacultyController(facultyServices);
//        facultyController.createFacultyFromFile();
        return facultyController;
    }

    private static CourseController initCourseDomain() {
        final CourseRepository courseRepository = new CourseRepository();
        final CourseServices courseServices = new CourseServices(courseRepository);
        final CourseController courseController = new CourseController(courseServices);
//        courseController.createFacultyFromFile();
        return courseController;
    }

    private static StudentController initStudentDomain() {
        final Crud<Student, String> studentRepository = new StudentRepository();
        final StudentServices studentServices = new StudentServices(studentRepository);
        final StudentController studentController = new StudentController(studentServices);
//        studentController.createFacultyFromFile();
        return studentController;
    }

    private static OffsetsController initOffsetsDomain() {
        final OffsetsRepository offsetsRepository = new OffsetsRepository();
        final OffsetsServices offsetsServices = new OffsetsServices(offsetsRepository);
        final OffsetsController offsetsController = new OffsetsController(offsetsServices);
//        offsetsController.createFacultyFromFile();
        return offsetsController;
    }

    private static ResultsExamController initResultsExamDomain() {
        final ResultsExamRepository resultsExamRepository = new ResultsExamRepository();
        final ResultsExamServices resultsExamServices = new ResultsExamServices(resultsExamRepository);
        final ResultsExamController resultsExamController = new ResultsExamController(resultsExamServices);
//        resultsExamController.createFacultyFromFile();
        return resultsExamController;
    }
}