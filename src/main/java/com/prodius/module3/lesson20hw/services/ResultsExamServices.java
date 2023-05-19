package com.prodius.module3.lesson20hw.services;

import com.prodius.module3.lesson20hw.model.ResultsExam;
import com.prodius.module3.lesson20hw.repository.Crud;

public class ResultsExamServices {
    private final Crud<ResultsExam, String> resultsExamRepository;

    public ResultsExamServices(Crud<ResultsExam, String> resultsExamRepository) {
        this.resultsExamRepository = resultsExamRepository;
    }

    public void save(final ResultsExam resultsExam) {
        resultsExamRepository.save(resultsExam);
    }

    public void printAll() {
        resultsExamRepository.getAll().forEach(System.out::println);
    }
}