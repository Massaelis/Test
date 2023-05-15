package com.prodius.module3.lesson20;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class Main {

    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        try (final Connection connection = DatabaseUtil.getConnection()) {
            workWithStatement(connection);
            workWithPrepareStatement(connection);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        workWithPrepareStatementTransaction();
    }

    private static void workWithPrepareStatementTransaction() {
        try (final Connection connection = DatabaseUtil.getConnection()) {
            connection.setAutoCommit(false);

            final String studentId = "61f408f8-a40a-4523-91a6-33669ae2b97f";
            final String query = "UPDATE \"Students\" SET age = ? WHERE id = ?";

            final PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, RANDOM.nextInt(10, 90));
            statement.setString(2, studentId);
            statement.execute();
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void workWithPrepareStatement(final Connection connection) throws SQLException {
        final String studentId = "61f408f8-a40a-4523-91a6-33669ae2b97f";
        final String query = "SELECT * FROM \"Students\" WHERE id = ?";
        try (final PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, studentId);
            final boolean execute = statement.execute();
            System.out.println("Execute prepare statement: " + execute);
        }

        final String queryAll = "SELECT * FROM \"Students\"";
        try (final PreparedStatement statementAll = connection.prepareStatement(queryAll)) {
            final ResultSet resultSet = statementAll.executeQuery();
            while (resultSet.next()) {
                final String id = resultSet.getString("id");
                final String name = resultSet.getString("name");
                final int age = resultSet.getInt("age");
                System.out.printf("Student '%s' with id: %s and age: %d%n", name, id, age);
            }
        }
    }

    private static void workWithStatement(final Connection connection) throws SQLException {
        final Statement statement = connection.createStatement();
        final String query = "SELECT * FROM \"Students\" WHERE id = 'de409053-6dfa-48f7-a8af-b0203e58f72f'";
        final boolean execute = statement.execute(query);
        System.out.println("Execute statement: " + execute);

        final String updateQuery = "UPDATE \"Students\" SET age = 21 WHERE id = 'de409053-6dfa-48f7-a8af-b0203e58f72f'";
        final int update = statement.executeUpdate(updateQuery);
        System.out.println("Execute update statement: " + update);

        final ResultSet resultSet = statement.executeQuery(query);
        System.out.println(resultSet);
    }
}
