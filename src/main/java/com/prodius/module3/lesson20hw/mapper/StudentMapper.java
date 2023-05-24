package com.prodius.module3.lesson20hw.mapper;

import com.prodius.module3.lesson20hw.model.Faculty;
import com.prodius.module3.lesson20hw.model.Student;
import com.prodius.module3.lesson20hw.repository.FacultyRepository;
import lombok.SneakyThrows;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.function.Function;

public class StudentMapper {
    private static final StudentMapper STUDENT_MAPPER = new StudentMapper();

    private static final FacultyRepository FACULTY_REPOSITORY = new FacultyRepository();

    private StudentMapper() {
    }

    public static Function<ResultSet, Student> getMapper() {
        return STUDENT_MAPPER::map;
    }

    @SneakyThrows
    private Student map(final ResultSet resultSet) {
        final String id = resultSet.getString("id");
        final String name = resultSet.getString("name");
        final String surname = resultSet.getString("surname");
        final Date date = (resultSet.getDate("date"));
        final String email = resultSet.getString("email");
        final String idFaculty = resultSet.getString("id_faculty");

        final Faculty faculty = FACULTY_REPOSITORY.getById(idFaculty);

        return new Student(id, name, surname, date, email, faculty, idFaculty);
    }
}