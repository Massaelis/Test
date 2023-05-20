package com.prodius.module3.lesson20hw.services;

import com.prodius.module3.lesson20hw.model.ResultsExam;
import com.prodius.module3.lesson20hw.repository.ResultsExamRepository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;

public class ResultsExamServices {
    private final ResultsExamRepository resultsExamRepository;

    public ResultsExamServices(ResultsExamRepository resultsExamRepository) {
        this.resultsExamRepository = resultsExamRepository;
    }

    public void loadDataFromFile(final String filename) {
        final InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream(filename);
        try (final BufferedReader reader = new BufferedReader(
                new InputStreamReader(Objects.requireNonNull(resourceAsStream)))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                final String[] parts = line.split(",");
                final String id_results_exam = parts[0];
                final String id_student = parts[1];
                final String id_course = parts[2];

                final DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH);
                java.sql.Date dateExam = new java.sql.Date(df.parse(parts[3]).getTime());

                final int grade = Integer.parseInt(parts[4]);
                final ResultsExam resultsExam = new ResultsExam(id_results_exam, null, id_student,
                        null, id_course, dateExam, grade);
                resultsExamRepository.save(resultsExam);
                System.out.println(resultsExam);
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
        resultsExamRepository.getAll().forEach(System.out::println);
    }

    public Set<ResultsExam> getHighGrade(final List<Integer> marks) {
        return resultsExamRepository.getHighGrade(marks);
    }
}