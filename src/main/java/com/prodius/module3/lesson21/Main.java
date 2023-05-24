package com.prodius.module3.lesson21;

import com.prodius.module3.lesson21.controllers.StudentController;
import com.prodius.module3.lesson21.model.Student;
import com.prodius.module3.lesson21.repository.Crud;
import com.prodius.module3.lesson21.repository.StudentRepository;
import com.prodius.module3.lesson21.services.StudentService;

public class Main {
    public static void main(String[] args) {
        final Crud<Student, String> studentRepository = new StudentRepository();
        final StudentService studentService = new StudentService(studentRepository);
        final StudentController studentController = new StudentController(studentService);

        studentController.createStudent();
        studentController.printAll();

    }
}
