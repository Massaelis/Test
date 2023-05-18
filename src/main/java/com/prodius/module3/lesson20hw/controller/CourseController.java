package com.prodius.module3.lesson20hw.controller;

import com.prodius.module3.lesson20hw.model.Course;
import com.prodius.module3.lesson20hw.services.CourseServices;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;


import java.text.SimpleDateFormat;
import java.util.Locale;

public class CourseController {
    private final CourseServices courseServices;

    public CourseController(CourseServices courseServices) {
        this.courseServices = courseServices;
    }

    private static final String FACULTY_FILE = "src/main/java/com/prodius/module3/lesson20hw/txt/course";

//    DateFormat format = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
//    java.util.Date utilDate = new java.util.Date();
//    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

    public static String toMysqlDateStr(Date date) {
        String dateForMySql = "";
        if (date == null) {
            dateForMySql = null;
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            dateForMySql = sdf.format(date);
        }
        return dateForMySql;
    }
    public void createFacultyFromFile() {
        try (final BufferedReader reader = new BufferedReader(new FileReader(FACULTY_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                final String[] parts = line.split(",");
                final String id = parts[0];
                final String group_name = parts[1];
                final Date date_start = Date.valueOf(toMysqlDateStr(Date.valueOf(parts[2])));
                final Date date_end = Date.valueOf(toMysqlDateStr(Date.valueOf(parts[3])));
                final String id_faculty = parts[4];
                final Course course = new Course(id, group_name, date_start, date_end, id_faculty);
                courseServices.save(course);
                System.out.println(course);
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Can't find file");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printAll() {
        courseServices.printAll();
    }
}
