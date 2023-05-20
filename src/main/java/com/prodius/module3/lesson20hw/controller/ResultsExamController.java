package com.prodius.module3.lesson20hw.controller;

import com.prodius.module3.lesson20hw.model.ResultsExam;

import com.prodius.module3.lesson20hw.services.ResultsExamServices;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class ResultsExamController {
    private final ResultsExamServices resultsExamServices;

    public ResultsExamController(ResultsExamServices resultsExamServices) {
        this.resultsExamServices = resultsExamServices;
    }

    private static final String OFFSETS_FILE = "src/main/java/com/prodius/module3/lesson20hw/txt/results_exam";

    public void createFacultyFromFile() {
        try (final BufferedReader reader = new BufferedReader(new FileReader(OFFSETS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                final String[] parts = line.split(",");
                final String id_results_exam = parts[0];
                final String id_student = parts[1];
                final String id_course = parts[2];

                final DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH);
                java.util.Date date = df.parse(parts[3]);
                java.sql.Date date_exam = new java.sql.Date(date.getTime());

                final int grade = Integer.parseInt(parts[4]);
                final ResultsExam resultsExam = new ResultsExam(id_results_exam, id_student, id_course, date_exam, grade);
                resultsExamServices.save(resultsExam);
                System.out.println(resultsExam);
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
        resultsExamServices.printAll();
    }
    public void getHighGrade() {
        resultsExamServices.getHighGrade();
    }
}