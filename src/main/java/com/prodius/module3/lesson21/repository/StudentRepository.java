package com.prodius.module3.lesson21.repository;

import com.prodius.module3.lesson21.mapper.StudentMapper;
import com.prodius.module3.lesson21.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashSet;
import java.util.Set;

public class StudentRepository implements Crud<Student, String> { // WORK WITH DATABASE
    public StudentRepository() {
        // create a table
    }


    @Override
    public void save(final Student student) {
        final String query = "INSERT INTO \"Students\"(id, name, age) VALUES(?, ?, ?)";

        try (
                final Connection connection = getConnection();
                final PreparedStatement preparedStatement = connection.prepareStatement(query)
        ) {
            preparedStatement.setString(1, student.getId());
            preparedStatement.setString(2, student.getName());
            preparedStatement.setInt(3, student.getAge());
            final int execute = preparedStatement.executeUpdate();
            System.out.println("Student saved: " + (execute == 1));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Student getById(final String id) {
        return null;
    }

    @Override
    public Set<Student> getAll() {
        final Set<Student> students = new LinkedHashSet<>();

        try (
                final Connection connection = getConnection();
                final Statement statement = connection.createStatement()
        ) {
            final ResultSet resultSet = statement.executeQuery("SELECT * FROM \"Students\" ORDER BY age DESC");
            while (resultSet.next()) {
                final Student student0 = StudentMapper.getMapper().apply(resultSet);
                students.add(student0);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return students;
    }

    @Override
    public void delete(final String id) {

    }
}
