package com.prodius.module3.lesson20hw.mapper;


import com.prodius.module3.lesson20hw.model.Faculty;
import lombok.SneakyThrows;

import java.sql.ResultSet;
import java.util.function.Function;

public class FacultyMapper {

    private static final FacultyMapper FACULTY_MAPPER = new FacultyMapper();

    private FacultyMapper(){
    }

    public static Function<ResultSet, Faculty> getMapper(){return FACULTY_MAPPER::map;}

    @SneakyThrows
    private Faculty map(final ResultSet resultSet) {
        final String id = resultSet.getString("id");
        final String faculty_name = resultSet.getString("faculty_name");
        final String dean = resultSet.getString("dean");
        final Faculty faculty = new Faculty(id, faculty_name, dean);
        return faculty;
    }

}
