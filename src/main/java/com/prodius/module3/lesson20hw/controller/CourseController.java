package com.prodius.module3.lesson20hw.controller;

import com.prodius.module3.lesson20hw.model.Course;
import com.prodius.module3.lesson20hw.services.CourseServices;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class CourseController {
    private final CourseServices courseServices;

    public CourseController(CourseServices courseServices) {
        this.courseServices = courseServices;
    }
    private static final String FACULTY_FILE = "src/main/java/com/prodius/module3/lesson20hw/txt/course";

    public void createFacultyFromFile() {
        try (final BufferedReader reader = new BufferedReader(new FileReader(FACULTY_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                final String[] parts = line.split(",");
                final String id = parts[0];
                final String group_name = parts[1];

                final DateFormat df = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                java.util.Date dateStart = df.parse(parts[2]);
                java.sql.Date date_start = new java.sql.Date(dateStart.getTime());
                java.util.Date dateEnd = df.parse(parts[3]);
                java.sql.Date date_end = new java.sql.Date(dateEnd.getTime());

                final String id_faculty = parts[4];
                final Course course = new Course(id, group_name, date_start, date_end, id_faculty);
                courseServices.save(course);
                System.out.println(course);
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
        courseServices.printAll();
    }
}