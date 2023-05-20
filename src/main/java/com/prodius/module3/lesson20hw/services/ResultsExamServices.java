package com.prodius.module3.lesson20hw.services;

import com.prodius.module3.lesson20hw.model.ResultsExam;
import com.prodius.module3.lesson20hw.repository.Crud;
import com.prodius.module3.lesson20hw.repository.ResultsExamRepository;

public class ResultsExamServices {
    private final ResultsExamRepository resultsExamRepository;

    public ResultsExamServices(ResultsExamRepository resultsExamRepository) {
        this.resultsExamRepository = resultsExamRepository;
    }

    public void save(final ResultsExam resultsExam) {
        resultsExamRepository.save(resultsExam);
    }

    public void printAll() {
        resultsExamRepository.getAll().forEach(System.out::println);
    }

    public void getHighGrade() {
        resultsExamRepository.getHighGrade().forEach(System.out::println);
    }
}