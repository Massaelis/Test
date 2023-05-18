package com.prodius.module3.lesson20hw.createTable;

import com.prodius.module3.lesson20hw.DatabaseUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTableEx {
    public void createTable() {
        try (final Connection connection = DatabaseUtil.getConnection()) {
            connection.setAutoCommit(false);

            createTable(connection, CreateTables.FACULTY);
            createTable(connection, CreateTables.STUDENT);
            createTable(connection, CreateTables.COURSE);
            createTable(connection, CreateTables.RESULTS_EXAM);
            createTable(connection, CreateTables.OFFSETS);

            connection.commit();
            System.out.println("All table successfully created...");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void createTable(final Connection connection, final CreateTables createTables) throws SQLException {
        System.out.println("Creating table in selected database...");

        try (final Statement statement = connection.createStatement()) {
            statement.executeUpdate(createTables.getQuery());
        }

        System.out.println("Table successfully created...");
    }
}