package com.prodius.module3.lesson20hw.mapper;

import com.prodius.module3.lesson20hw.join.JoinFacultyCourse;
import com.prodius.module3.lesson20hw.join.JoinFacultyStudent;
import com.prodius.module3.lesson20hw.model.Faculty;
import lombok.SneakyThrows;

import java.sql.ResultSet;
import java.util.function.Function;

public class FacultyMapper {

    private static final FacultyMapper FACULTY_MAPPER = new FacultyMapper();

    private FacultyMapper() {
    }

    public static Function<ResultSet, Faculty> getMapper() {
        return FACULTY_MAPPER::map;
    }

    public static Function<ResultSet, JoinFacultyCourse> getMapperJoinCourse() {
        return FACULTY_MAPPER::mapJoinCourse;
    }
    public static Function<ResultSet, JoinFacultyStudent> getMapperJoinStudent() {
        return FACULTY_MAPPER::mapJoinStudent;
    }


    @SneakyThrows
    private Faculty map(final ResultSet resultSet) {
        final String id = resultSet.getString("id");
        final String facultyName = resultSet.getString("faculty_name");
        final String dean = resultSet.getString("dean");

        return new Faculty(id, facultyName, dean);
    }

    @SneakyThrows
    private JoinFacultyCourse mapJoinCourse(final ResultSet resultSet) {
        final String facultyName = resultSet.getString("facultyName");
        final int countCourses = Integer.parseInt(resultSet.getString("countCourses"));

        return new JoinFacultyCourse(facultyName, countCourses);
    }
    @SneakyThrows
    private JoinFacultyStudent mapJoinStudent(final ResultSet resultSet) {
        final String facultyName = resultSet.getString("faculty_name");

        return new JoinFacultyStudent(facultyName);
    }
}