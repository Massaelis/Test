package com.prodius.module3.lesson20hw.mapper;

import com.prodius.module3.lesson20hw.model.ResultsExam;
import lombok.SneakyThrows;

import java.sql.ResultSet;
import java.util.function.Function;

public class ResultsExamMapper {
    private static final ResultsExamMapper RESULT_EXAM_MAPPER = new ResultsExamMapper();

    private ResultsExamMapper() {
    }

    public static Function<ResultSet, ResultsExam> getMapper() {
        return RESULT_EXAM_MAPPER::map;
    }

    @SneakyThrows
    private ResultsExam map(final ResultSet resultSet) {
        final String idResultsExam = resultSet.getString("id_results_exam");
        final String idStudent = resultSet.getString("id_student");
        final String idCourse = resultSet.getString("id_group");
        final java.sql.Date dateExam = (resultSet.getDate("date_exam"));
        final int grade = resultSet.getInt("grade");

        return new ResultsExam(idResultsExam, idStudent, idCourse, dateExam, grade);
    }
}