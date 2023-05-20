package com.prodius.module3.lesson20hw.repository;

import com.prodius.module3.lesson20hw.mapper.CourseMapper;
import com.prodius.module3.lesson20hw.model.Course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
            preparedStatement.setString(5, course.getFacultyId());
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

    public Set<Object> getDataAboutCourse() { // TODO: 20/05/23
        final Set<Object> objects = new LinkedHashSet<>();
        try (
                final Connection connection = getConnection();
                final Statement statement = connection.createStatement()
        ) {
            final ResultSet resultSet = statement.executeQuery("SELECT student.*, course.group_name, results_exam.grade FROM course\n"
                    + "        join results_exam On results_exam.id_course = course.id\n"
                    + "        join student On results_exam.id_student = student.id");
            while (resultSet.next()) {
                System.out.println(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return objects;
    }
}