package com.prodius.module3.lesson20;

import lombok.SneakyThrows;

import java.sql.ResultSet;
import java.util.function.Function;

public class Mapper {

    private static final Mapper MAPPER = new Mapper();

    private Mapper() {
    }

    public static Function<ResultSet, Student> getMapper() {
        return MAPPER::mapWithDecorator;
    }

    @SneakyThrows
    private Student mapWithDecorator(final ResultSet resultSet) {
        final String id = resultSet.getString("id");
        final Student student = new Student(id);
        student.setName("***" + resultSet.getString("name") + "***");
        student.setAge(resultSet.getInt("age"));
        return student;
    }


}
