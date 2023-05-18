package com.prodius.module3.lesson20hw.mapper;

import com.prodius.module3.lesson20hw.model.Course;
import lombok.SneakyThrows;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.function.Function;

public class CourseMapper {
    private static final CourseMapper COURSE_MAPPER = new CourseMapper();
    private CourseMapper(){
    }
    public static Function<ResultSet, Course> getMapper(){return COURSE_MAPPER::map;}

    @SneakyThrows
    private Course map(final ResultSet resultSet) {
        final String id = resultSet.getString("id");
        final String group_name = resultSet.getString(" group_name");
        final Date date_start = (resultSet.getDate("date_start"));
        final Date date_end = (resultSet.getDate("date_end"));
        final String id_faculty = resultSet.getString("id_faculty");
        final Course course = new Course(id, group_name, date_start, date_end, id_faculty);
        return course;
    }
}
