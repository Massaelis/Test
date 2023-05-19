package com.prodius.module3.lesson20hw.controller;

import com.prodius.module3.lesson20hw.model.Faculty;
import com.prodius.module3.lesson20hw.services.FacultyServices;

import java.io.*;

public class FacultyController {
    private final FacultyServices facultyServices;

    public FacultyController(FacultyServices facultyServices) {
        this.facultyServices = facultyServices;
    }
    private static final String FACULTY_FILE = "src/main/java/com/prodius/module3/lesson20hw/txt/faculty";

    public void createFacultyFromFile() {
        try (final BufferedReader reader = new BufferedReader(new FileReader(FACULTY_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                final String[] parts = line.split(",");
                final String id = parts[0];
                final String faculty_name = parts[1];
                final String dean = parts[2];
                final Faculty faculty = new Faculty(id, faculty_name, dean);
                facultyServices.save(faculty);
                System.out.println(faculty);
            }
        } catch (RuntimeException e) {
            System.out.println("Duplicate key value violates unique constraint \"faculty_pkey\"");
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            System.out.println("Can't find file");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printAll() {
        facultyServices.printAll();
    }
}