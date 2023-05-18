package com.prodius.module3.lesson20hw.repository;

import com.prodius.module3.lesson20hw.mapper.FacultyMapper;
import com.prodius.module3.lesson20hw.model.Faculty;

import java.sql.*;
import java.util.LinkedHashSet;
import java.util.Set;

import static com.prodius.module3.lesson20hw.DatabaseUtil.getConnection;

public class FacultyRepository implements Crud<Faculty, String> {
    @Override
    public void save(Faculty faculty) {
        final String query = "INSERT INTO \"faculty\"(id, faculty_name, dean) VALUES(?, ?, ?)";

        try (
            final Connection connection = getConnection();
            final PreparedStatement preparedStatement = connection.prepareStatement(query)
        ) {
            preparedStatement.setString(1, faculty.getId());
            preparedStatement.setString(2, faculty.getFaculty_name());
            preparedStatement.setString(3, faculty.getDean());
            final int execute = preparedStatement.executeUpdate();
            System.out.println("Student saved: " + (execute == 1));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public Set<Faculty> getAll() {
        final Set<Faculty> faculties = new LinkedHashSet<>();

        try (
            final Connection connection = getConnection();
            final Statement statement = connection.createStatement()
        ) {
            final ResultSet resultSet = statement.executeQuery("SELECT * FROM \"faculty\"");
            while (resultSet.next()) {
                final Faculty faculty = FacultyMapper.getMapper().apply(resultSet);
                faculties.add(faculty);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return faculties;
    }
}
