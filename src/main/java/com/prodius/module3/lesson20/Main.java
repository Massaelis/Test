package com.prodius.module3.lesson20;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

public class Main {

    private static final Function<ResultSet, Student> STUDENT_MAPPER = resultSet -> {
        try {
            final String id = resultSet.getString("id");
            final Student student = new Student(id);
            student.setName(resultSet.getString("name"));
            student.setAge(resultSet.getInt("age"));
            return student;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    };

    private static final Function<ResultSet, Student> STUDENT_MAPPER2 = Main::map;

    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        try (final Connection connection = DatabaseUtil.getConnection()) {
//            workWithStatement(connection);
//            workWithPrepareStatement(connection);
            workWithData();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
//        workWithPrepareStatementTransaction();
    }

    private static void workWithData() {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            final Student student = new Student();
            System.out.println("Write student.csv name");
            student.setName(reader.readLine());
            System.out.println("Write student.csv age");
            student.setAge(Integer.parseInt(reader.readLine()));

            save(student);

            printAllStudents();
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void printAllStudents() throws SQLException {
        try (
                final Connection connection = DatabaseUtil.getConnection();
                final Statement statement = connection.createStatement()
        ) {
            final ResultSet resultSet = statement.executeQuery("SELECT * FROM \"Students\" ORDER BY age DESC");

            final List<Student> students = new LinkedList<>();

            while (resultSet.next()) {
                final Student student0 = map(resultSet);
                students.add(student0);

                final Student student1 = STUDENT_MAPPER.apply(resultSet);
                students.add(student1);

                final Student student2 = STUDENT_MAPPER2.apply(resultSet);
                students.add(student2);

                final Student student3 = Mapper.getMapper().apply(resultSet);
                students.add(student3);
            }

            students.forEach(System.out::println);
        }
    }

    @SneakyThrows
    private static Student map(final ResultSet resultSet) {
        final String id = resultSet.getString("id");
        final Student student = new Student(id);
        student.setName(resultSet.getString("name"));
        student.setAge(resultSet.getInt("age"));
        return student;
    }

    private static void save(final Student student) throws SQLException {
        final String query = "INSERT INTO \"Students\"(id, name, age) VALUES(?, ?, ?)";

        try (
                final Connection connection = DatabaseUtil.getConnection();
                final PreparedStatement preparedStatement = connection.prepareStatement(query)
        ) {
            preparedStatement.setString(1, student.getId());
            preparedStatement.setString(2, student.getName());
            preparedStatement.setInt(3, student.getAge());
            final int execute = preparedStatement.executeUpdate();
            System.out.println("Student saved: " + (execute == 1));
        }
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
        System.out.println("Execute getById statement: " + update);

        final ResultSet resultSet = statement.executeQuery(query);
        System.out.println(resultSet);
    }
}
