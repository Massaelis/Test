package com.prodius.module3.lesson20hw.createTable;

import com.prodius.module3.lesson20hw.DatabaseUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
    public void createTable() {
        try (final Connection connection = DatabaseUtil.getConnection()) {
            connection.setAutoCommit(false);

            createFaculty(connection);
            createStudent(connection);
            createCourse(connection);
            createResultsExam(connection);
            createOffsets(connection);

            connection.commit();
            System.out.println("All table successfully created...");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void createStudent(final Connection connection) throws SQLException {
        System.out.println("Creating table in selected database...");
        final Statement statement = connection.createStatement();

        String student = "CREATE TABLE IF NOT EXISTS student " +
                " (id TEXT PRIMARY KEY, " +
                " name VARCHAR(50), " +
                " surname VARCHAR(50), " +
                " date DATE, " +
                " email VARCHAR(100), " +
                " id_faculty TEXT, " +
                " FOREIGN KEY (id_faculty) REFERENCES faculty(id))";

        statement.executeUpdate(student);
        System.out.println("Table successfully created...");
    }

    private void createCourse(final Connection connection) throws SQLException {

        System.out.println("Creating table in selected database...");
        final Statement statement = connection.createStatement();

        String course = "CREATE TABLE IF NOT EXISTS course " +
                " (id TEXT PRIMARY KEY, " +
                " group_name VARCHAR(100), " +
                " date_start DATE, " +
                " date_end DATE, " +
                " id_faculty TEXT, " +
                " FOREIGN KEY (id_faculty) REFERENCES faculty(id))";

        statement.executeUpdate(course);
        System.out.println("Table course.csv created...");
    }

    private void createFaculty(final Connection connection) throws SQLException {
        System.out.println("Creating table in selected database...");
        final Statement statement = connection.createStatement();

        String faculty = "CREATE TABLE IF NOT EXISTS faculty " +
                " (id TEXT PRIMARY KEY, " +
                " faculty_name VARCHAR(100), " +
                " dean VARCHAR(100))";

        statement.executeUpdate(faculty);
        System.out.println("Table faculty.csv created...");
    }

    private void createResultsExam(final Connection connection) throws SQLException {
        System.out.println("Creating table in selected database...");
        final Statement statement = connection.createStatement();

        String results_exam = "CREATE TABLE IF NOT EXISTS results_exam " +
                " (id_results_exam TEXT PRIMARY KEY, " +
                " id_student TEXT, " +
                " id_course TEXT, " +
                " date_exam DATE, " +
                " FOREIGN KEY (id_student) REFERENCES student(id), " +
                " FOREIGN KEY (id_course) REFERENCES course(id), " +
                " grade INTEGER CHECK\n" +
                "       (grade > -1 and grade < 11))";

        statement.executeUpdate(results_exam);
        System.out.println("Table results_exam.csv created...");
    }

    private void createOffsets(final Connection connection) throws SQLException {
        System.out.println("Creating table in selected database...");
        final Statement statement = connection.createStatement();

        String offsets = "CREATE TABLE IF NOT EXISTS offsets " +
                " (id_offsets TEXT PRIMARY KEY, " +
                " id_student TEXT, " +
                " id_course TEXT, " +
                " date_offsets DATE, " +
                " FOREIGN KEY (id_student) REFERENCES student(id), " +
                " FOREIGN KEY (id_course) REFERENCES course(id), " +
                " grade VARCHAR CHECK\n" +
                "       (grade = 'completed' or grade = 'process'))";

        statement.executeUpdate(offsets);
        System.out.println("Table offsets.csv created...");
    }
}