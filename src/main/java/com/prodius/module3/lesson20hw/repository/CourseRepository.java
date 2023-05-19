package com.prodius.module3.lesson20hw.repository;

import com.prodius.module3.lesson20hw.mapper.CourseMapper;
import com.prodius.module3.lesson20hw.model.Course;

import java.sql.*;
import java.util.LinkedHashSet;
import java.util.Set;

import static com.prodius.module3.lesson20hw.DatabaseUtil.getConnection;

public class CourseRepository implements Crud<Course, String> {

    @Override
    public void save(Course course) {
        final String query = "INSERT INTO \"course\"(id, group_name, date_start, date_end, id_faculty) " +
                "VALUES(?, ?, ?, ?, ?)";
        try (
                final Connection connection = getConnection();
                final PreparedStatement preparedStatement = connection.prepareStatement(query)
        ) {
            preparedStatement.setString(1, course.getId());
            preparedStatement.setString(2, course.getGroupName());
            preparedStatement.setDate(3, course.getDateStart());
            preparedStatement.setDate(4, course.getDateEnd());
            preparedStatement.setString(5, course.getIdFaculty());
            final int execute = preparedStatement.executeUpdate();
            System.out.println("Course saved: " + (execute == 1));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Set<Course> getAll() {
        final Set<Course> courses = new LinkedHashSet<>();
        try (
                final Connection connection = getConnection();
                final Statement statement = connection.createStatement()
        ) {
            final ResultSet resultSet = statement.executeQuery("SELECT * FROM \"course\"");
            while (resultSet.next()) {
                final Course course = CourseMapper.getMapper().apply(resultSet);
                courses.add(course);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return courses;
    }
}