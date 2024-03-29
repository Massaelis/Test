package com.prodius.module3.lesson20hw.repository;

import com.prodius.module3.lesson20hw.dto.JoinFacultyCourse;
import com.prodius.module3.lesson20hw.dto.JoinFacultyStudent;
import com.prodius.module3.lesson20hw.mapper.FacultyMapper;
import com.prodius.module3.lesson20hw.model.Faculty;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashSet;
import java.util.Set;

import static com.prodius.module3.lesson20hw.DatabaseUtil.getConnection;

public class FacultyRepository implements Crud<Faculty, String> {

    @Override
    public Faculty getById(final String id) {
        final String query = "SELECT * FROM faculty WHERE id = ?";

        try (
                final Connection connection = getConnection();
                final PreparedStatement statement = connection.prepareStatement(query)
        ) {
            statement.setString(1, id);
            final ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return FacultyMapper.getMapper().apply(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void save(Faculty faculty) {
        final String query = "INSERT INTO \"faculty\"(id, faculty_name, dean) VALUES(?, ?, ?)";
        try (
                final Connection connection = getConnection();
                final PreparedStatement preparedStatement = connection.prepareStatement(query)
        ) {
            preparedStatement.setString(1, faculty.getId());
            preparedStatement.setString(2, faculty.getFacultyName());
            preparedStatement.setString(3, faculty.getDean());
            final int execute = preparedStatement.executeUpdate();
            System.out.println("Faculty saved: " + (execute == 1));
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

    public Set<JoinFacultyStudent> getFacultyWithMoreThen(final int studentCount) {
        final Set<JoinFacultyStudent> faculties = new LinkedHashSet<>();

        final String query = "SELECT faculty_name FROM faculty\n"
                + "        JOIN student On faculty.id = student.id_faculty\n"
                + "        GROUP BY faculty_name\n"
                + "        HAVING COUNT (id_faculty) > ?";

        try (
                final Connection connection = getConnection();
                final PreparedStatement statement = connection.prepareStatement(query)
        ) {
            statement.setInt(1, studentCount);
            final ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                final JoinFacultyStudent faculty = FacultyMapper.getMapperJoinStudent().apply(resultSet);
                faculties.add(faculty);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return faculties;
    }

    public Set<JoinFacultyCourse> getFacultyWithCountCourses() {
        final String query = "SELECT faculty.faculty_name as facultyName, count(course.group_name) as countCourses "
                + "        FROM course\n"
                + "        JOIN faculty ON faculty.id = course.id_faculty\n"
                + "        GROUP BY faculty.faculty_name";
        final Set<JoinFacultyCourse> faculties = new LinkedHashSet<>();

        try (
                final Connection connection = getConnection();
                final Statement statement = connection.createStatement()
        ) {
            final ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                final JoinFacultyCourse faculty = FacultyMapper.getMapperJoinCourse().apply(resultSet);
                faculties.add(faculty);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return faculties;
    }
}