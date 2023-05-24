package com.prodius.module3.lesson20hw.repository;

import com.prodius.module3.lesson20hw.mapper.StudentMapper;
import com.prodius.module3.lesson20hw.model.Student;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashSet;
import java.util.Set;

import static com.prodius.module3.lesson20hw.DatabaseUtil.getConnection;

public class StudentRepository implements Crud<Student, String> {

    @Override
    public void save(Student student) {
        final String query = "INSERT INTO \"student\"(id, name, surname, date, email, id_faculty) " +
                "VALUES(?, ?, ?, ?, ?, ?)";
        try (
                final Connection connection = getConnection();
                final PreparedStatement preparedStatement = connection.prepareStatement(query)
        ) {
            preparedStatement.setString(1, student.getId());
            preparedStatement.setString(2, student.getName());
            preparedStatement.setString(3, student.getSurname());
            preparedStatement.setDate(4, (Date) student.getDate());
            preparedStatement.setString(5, student.getEmail());
            preparedStatement.setString(6, student.getFacultyId());
            final int execute = preparedStatement.executeUpdate();
            System.out.println("Student saved: " + (execute == 1));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Set<Student> getAll() {
        final Set<Student> students = new LinkedHashSet<>();
        try (
                final Connection connection = getConnection();
                final Statement statement = connection.createStatement()
        ) {
            final ResultSet resultSet = statement.executeQuery("SELECT * FROM \"student\"");
            while (resultSet.next()) {
                final Student student = StudentMapper.getMapper().apply(resultSet);
                students.add(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;
    }
}