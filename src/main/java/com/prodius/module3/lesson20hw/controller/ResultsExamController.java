package com.prodius.module3.lesson20hw.controller;

import com.prodius.module3.lesson20hw.services.ResultsExamServices;

import java.util.ArrayList;
import java.util.List;

public class ResultsExamController {
    private final ResultsExamServices resultsExamServices;

    public ResultsExamController(ResultsExamServices resultsExamServices) {
        this.resultsExamServices = resultsExamServices;
    }

    private static final String OFFSETS_FILE = "lesson20/results_exam.csv";

    public void createFacultyFromFile() {
        resultsExamServices.loadDataFromFile(OFFSETS_FILE);
    }

    public void getHighGrade() {
        List<Integer> marks = new ArrayList<>();
        marks.add(7);
        marks.add(9);
        marks.add(10);
        resultsExamServices.getHighGrade(marks).forEach(System.out::println);
    }
}