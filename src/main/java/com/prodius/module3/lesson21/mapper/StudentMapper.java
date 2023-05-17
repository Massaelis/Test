package com.prodius.module3.lesson21.mapper;

import com.prodius.module3.lesson21.model.Student;
import lombok.SneakyThrows;

import java.sql.ResultSet;
import java.util.function.Function;

public class StudentMapper {

    private static final StudentMapper MAPPER = new StudentMapper();

    private StudentMapper() {
    }

    public static Function<ResultSet, Student> getMapper() {
        return MAPPER::map;
    }

    @SneakyThrows
    private Student map(final ResultSet resultSet) {
        final String id = resultSet.getString("id");
        final Student student = new Student(id);
        student.setName(resultSet.getString("name"));
        student.setAge(resultSet.getInt("age"));
        return student;
    }


}
