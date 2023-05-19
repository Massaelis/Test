package com.prodius.module3.lesson20hw.mapper;

import com.prodius.module3.lesson20hw.model.Course;
import lombok.SneakyThrows;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.function.Function;

public class CourseMapper {
    private static final CourseMapper COURSE_MAPPER = new CourseMapper();

    private CourseMapper() {
    }

    public static Function<ResultSet, Course> getMapper() {
        return COURSE_MAPPER::map;
    }

    @SneakyThrows
    private Course map(final ResultSet resultSet) {
        final String id = resultSet.getString("id");
        final String groupName = resultSet.getString("group_name");
        final Date dateStart = (resultSet.getDate("date_start"));
        final Date dateEnd = (resultSet.getDate("date_end"));
        final String idFaculty = resultSet.getString("id_faculty");

        return new Course(id, groupName, dateStart, dateEnd, idFaculty);
    }
}