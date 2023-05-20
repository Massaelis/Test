package com.prodius.module3.lesson20hw.repository;

import com.prodius.module3.lesson20hw.mapper.OffsetsMapper;
import com.prodius.module3.lesson20hw.model.Offsets;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashSet;
import java.util.Set;

import static com.prodius.module3.lesson20hw.DatabaseUtil.getConnection;

public class OffsetsRepository implements Crud<Offsets, String> {

    @Override
    public void save(Offsets offsets) {
        final String query = "INSERT INTO \"offsets\"(id_offsets, id_student, id_course, date_offsets, grade) " +
                "VALUES(?, ?, ?, ?, ?)";
        try (
                final Connection connection = getConnection();
                final PreparedStatement preparedStatement = connection.prepareStatement(query)
        ) {
            preparedStatement.setString(1, offsets.getIdOffsets());
            preparedStatement.setString(2, offsets.getStudentId());
            preparedStatement.setString(3, offsets.getCourseId());
            preparedStatement.setDate(4, (Date) offsets.getDateOffsets());
            preparedStatement.setString(5, offsets.getGrade());
            final int execute = preparedStatement.executeUpdate();
            System.out.println("Offsets saved: " + (execute == 1));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Set<Offsets> getAll() {
        final Set<Offsets> offsets = new LinkedHashSet<>();
        try (
                final Connection connection = getConnection();
                final Statement statement = connection.createStatement()
        ) {
            final ResultSet resultSet = statement.executeQuery("SELECT * FROM \"offsets\"");
            while (resultSet.next()) {
                final Offsets offset = OffsetsMapper.getMapper().apply(resultSet);
                offsets.add(offset);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return offsets;
    }

    public int getCompletedOffset() { // TODO: 20/05/23
        try (
                final Connection connection = getConnection();
                final Statement statement = connection.createStatement()
        ) {
            final ResultSet resultSet = statement.executeQuery("SELECT count(*) as c FROM offsets\n" +
                    "WHERE (grade = 'completed');");
            return 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}