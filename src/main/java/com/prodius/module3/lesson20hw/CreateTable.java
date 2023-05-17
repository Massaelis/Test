package com.prodius.module3.lesson20hw;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
    public static void createTable() {
        try (final Connection connection = DatabaseUtil.getConnection()) {

            connection.setAutoCommit(false);
            final Statement statement = connection.createStatement();

            final String faculty = "CREATE TABLE IF NOT EXISTS faculty " +
                    " (id TEXT PRIMARY KEY, " +
                    " faculty_name VARCHAR(100), " +
                    " dean VARCHAR(100))";

            final String student = "CREATE TABLE IF NOT EXISTS student " +
                    " (id TEXT PRIMARY KEY, " +
                    " name VARCHAR(50), " +
                    " surname VARCHAR(50), " +
                    " date DATE, " +
                    " email VARCHAR(100), " +
                    " id_faculty TEXT, " +
                    " FOREIGN KEY (id_faculty) REFERENCES faculty(id))";

            final String course = "CREATE TABLE IF NOT EXISTS course " +
                    " (id TEXT PRIMARY KEY, " +
                    " group_name VARCHAR(100), " +
                    " date_start DATE, " +
                    " date_end DATE, " +
                    " id_faculty TEXT, " +
                    " FOREIGN KEY (id_faculty) REFERENCES faculty(id))";

            final String results_exam = "CREATE TABLE IF NOT EXISTS results_exam " +
                    " (id_results_exam TEXT PRIMARY KEY, " +
                    " id_student TEXT, " +
                    " id_group TEXT, " +
                    " date_exam DATE, " +
                    " FOREIGN KEY (id_student) REFERENCES student(id), " +
                    " FOREIGN KEY (id_group) REFERENCES course(id), " +
                    " grade INTEGER CHECK\n" +
                    "       (grade > -1 and grade < 11))";

            final String offsets = "CREATE TABLE IF NOT EXISTS offsets " +
                    " (id_offsets TEXT PRIMARY KEY, " +
                    " id_student TEXT, " +
                    " id_group TEXT, " +
                    " date_offsets DATE, " +
                    " FOREIGN KEY (id_student) REFERENCES student(id), " +
                    " FOREIGN KEY (id_group) REFERENCES course(id), " +
                    " grade VARCHAR CHECK\n" +
                    "       (grade = 'completed' or grade = 'process'))";

            statement.executeUpdate(faculty);
            statement.executeUpdate(student);
            statement.executeUpdate(course);
            statement.executeUpdate(results_exam);
            statement.executeUpdate(offsets);

            connection.commit();
            connection.close();

            System.out.println("All table successfully created...");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}