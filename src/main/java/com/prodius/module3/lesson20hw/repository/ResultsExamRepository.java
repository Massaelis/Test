package com.prodius.module3.lesson20hw.repository;

import com.prodius.module3.lesson20hw.mapper.ResultsExamMapper;
import com.prodius.module3.lesson20hw.model.ResultsExam;

import java.sql.Array;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static com.prodius.module3.lesson20hw.DatabaseUtil.getConnection;

public class ResultsExamRepository implements Crud<ResultsExam, String> {
    @Override
    public void save(ResultsExam resultsExam) {
        final String query = "INSERT INTO \"results_exam\"(id_results_exam, id_student, id_course, date_exam, grade) " +
                "VALUES(?, ?, ?, ?, ?)";
        try (
                final Connection connection = getConnection();
                final PreparedStatement preparedStatement = connection.prepareStatement(query)
        ) {
            preparedStatement.setString(1, resultsExam.getIdResultsExam());
            preparedStatement.setString(2, resultsExam.getStudentId());
            preparedStatement.setString(3, resultsExam.getCourseId());
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

    public Set<ResultsExam> getHighGrade(final List<Integer> marks) {
        final Set<ResultsExam> resultsExams = new LinkedHashSet<>();

        final String query = "SELECT * FROM results_exam\n" +
                "WHERE grade = ANY (?)";

        try (
                final Connection connection = getConnection();
                final PreparedStatement statement = connection.prepareStatement(query)
        ) {
            final Array integers = connection.createArrayOf("INTEGER", marks.toArray());
            statement.setArray(1, integers);
            final ResultSet resultSet = statement.executeQuery();
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