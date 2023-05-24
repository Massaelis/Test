package com.prodius.module3.lesson20hw.services;

import com.prodius.module3.lesson20hw.dto.JoinFacultyCourse;
import com.prodius.module3.lesson20hw.model.Faculty;
import com.prodius.module3.lesson20hw.repository.FacultyRepository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Set;

public class FacultyServices {
    private final FacultyRepository facultyRepository;

    public FacultyServices(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public void loadDataFromFile(final String filename) {
        final InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream(filename);
        try (final BufferedReader reader = new BufferedReader(
                new InputStreamReader(Objects.requireNonNull(resourceAsStream)))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                final String[] parts = line.split(",");
                final String id = parts[0];
                final String faculty_name = parts[1];
                final String dean = parts[2];
                final Faculty faculty = new Faculty(id, faculty_name, dean);
                facultyRepository.save(faculty);
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


    public void getFacultyWithMoreThen(final int studentCount) {
        facultyRepository.getFacultyWithMoreThen(studentCount).forEach(System.out::println);
    }

    public Set<JoinFacultyCourse> getFacultyWithCountCourses() {
        return facultyRepository.getFacultyWithCountCourses();
    }
}