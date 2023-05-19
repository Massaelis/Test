package com.prodius.module3.lesson20hw.controller;


import com.prodius.module3.lesson20hw.model.Student;
import com.prodius.module3.lesson20hw.services.StudentServices;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class StudentController {
    private final StudentServices studentServices;

    public StudentController(StudentServices studentServices) {
        this.studentServices = studentServices;
    }
    private static final String FACULTY_FILE = "src/main/java/com/prodius/module3/lesson20hw/txt/student";

    public void createFacultyFromFile() {
        try (final BufferedReader reader = new BufferedReader(new FileReader(FACULTY_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                final String[] parts = line.split(",");
                final String id = parts[0];
                final String name = parts[1];
                final String surname = parts[2];

                final DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
                java.util.Date dateJava = df.parse(parts[3]);
                java.sql.Date dateSql = new java.sql.Date(dateJava.getTime());

                final String email = parts[4];
                final String id_faculty = parts[5];
                final Student student = new Student(id, name, surname, dateSql, email, id_faculty);
                studentServices.save(student);
                System.out.println(student);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Can't find file");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public void printAll() {
        studentServices.printAll();
    }
}