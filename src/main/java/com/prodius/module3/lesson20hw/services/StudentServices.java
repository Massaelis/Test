package com.prodius.module3.lesson20hw.services;

import com.prodius.module3.lesson20hw.model.Student;
import com.prodius.module3.lesson20hw.repository.Crud;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Objects;

public class StudentServices {
    private final Crud<Student, String> studentRepository;

    public StudentServices(Crud<Student, String> studentRepository) {
        this.studentRepository = studentRepository;
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
                final String name = parts[1];
                final String surname = parts[2];

                final DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
                java.sql.Date dateSql = new java.sql.Date(df.parse(parts[3]).getTime());

                final String email = parts[4];
                final String id_faculty = parts[5];
                final Student student = new Student(id, name, surname, dateSql, email, null, id_faculty);
                studentRepository.save(student);
                System.out.println(student);
            }
        } catch (RuntimeException e) {
            System.out.println("Duplicate key value violates unique constraint \"faculty_pkey\"");
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            System.out.println("Can't find file");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }


    public void printAll() {
        studentRepository.getAll().forEach(System.out::println);
    }
}