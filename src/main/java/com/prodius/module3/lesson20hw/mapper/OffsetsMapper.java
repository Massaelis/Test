package com.prodius.module3.lesson20hw.mapper;

import com.prodius.module3.lesson20hw.model.Offsets;
import lombok.SneakyThrows;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.function.Function;

public class OffsetsMapper {
    private static final OffsetsMapper OFFSETS_MAPPER = new OffsetsMapper();

    private OffsetsMapper() {
    }

    public static Function<ResultSet, Offsets> getMapper() {
        return OFFSETS_MAPPER::map;
    }

    @SneakyThrows
    private Offsets map(final ResultSet resultSet) {
        final String idOffsets = resultSet.getString("id_offsets");
        final String idStudent = resultSet.getString("id_student");
        final String idCourse = resultSet.getString("id_course");
        final Date dateOffsets = (resultSet.getDate("date_offsets"));
        final String grade = resultSet.getString("grade");

        return new Offsets(idOffsets, null, idStudent, null, idCourse, dateOffsets, grade);
    }
}