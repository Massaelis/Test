package com.prodius.module3.lesson20hw.repository;

import com.prodius.module3.lesson20hw.mapper.ResultsExamMapper;
import com.prodius.module3.lesson20hw.model.ResultsExam;

import java.sql.*;
import java.util.LinkedHashSet;
import java.util.Set;

import static com.prodius.module3.lesson20hw.DatabaseUtil.getConnection;

public class ResultsExamRepository implements Crud<ResultsExam, String> {
    @Override
    public void save(ResultsExam resultsExam) {
        final String query = "INSERT INTO \"results_exam\"(id_results_exam, id_student, id_group, date_exam, grade) " +
                "VALUES(?, ?, ?, ?, ?)";
        try (
                final Connection connection = getConnection();
                final PreparedStatement preparedStatement = connection.prepareStatement(query)
        ) {
            preparedStatement.setString(1, resultsExam.getIdResultsExam());
            preparedStatement.setString(2, resultsExam.getIdStudent());
            preparedStatement.setString(3, resultsExam.getIdCourse());
            preparedStatement.setDate(4, (Date) resultsExam.getDateExam());
            preparedStatement.setInt(5, resultsExam.getGrade());
            final int execute = preparedStatement.executeUpdate();
            System.out.println("Results exam saved: " + (execute == 1));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Set<ResultsExam> getAll() {
        final Set<ResultsExam> resultsExams = new LinkedHashSet<>();
        try (
                final Connection connection = getConnection();
                final Statement statement = connection.createStatement()
        ) {
            final ResultSet resultSet = statement.executeQuery("SELECT * FROM \"results_exam\"");
            while (resultSet.next()) {
                final ResultsExam resultsExam = ResultsExamMapper.getMapper().apply(resultSet);
                resultsExams.add(resultsExam);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultsExams;
    }
}