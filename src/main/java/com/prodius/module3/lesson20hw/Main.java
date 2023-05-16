package com.prodius.module3.lesson20hw;

import java.sql.*;

public class Main {
    final static Connection connection = DatabaseUtil.getConnection();
    public static void main(String[] args) throws ClassNotFoundException, SQLException {


        String student = "CREATE TABLE student " +
                " (id_group TEXT PRIMARY KEY, " +
                " name VARCHAR(50), " +
                " surname VARCHAR(50), " +
                " date DATE, " +
                " email VARCHAR(100))";

        String course = "CREATE TABLE course " +
                " (id_group TEXT PRIMARY KEY, " +
                " group_name VARCHAR(100), " +
                " date_start DATE, " +
                " date_end DATE)";

        String faculty = "CREATE TABLE faculty " +
                " (id_faculty TEXT PRIMARY KEY, " +
                " faculty_name VARCHAR(100), " +
                " dean VARCHAR(100))";

        String results_exam = "CREATE TABLE results_exam " +
                " (id_results_exam TEXT PRIMARY KEY, " +
                " id_student TEXT, " +
                " id_group TEXT, " +
                " date_exam DATE, " +
                " grade INTEGER CHECK\n" +
                "       (grade > -1 and grade < 11))";

        String offsets = "CREATE TABLE offsets " +
                " (id_offsets TEXT PRIMARY KEY, " +
                " id_student TEXT, " +
                " id_group TEXT, " +
                " date_offsets DATE, " +
                " grade VARCHAR CHECK\n" +
                "       (grade = 'completed' or grade = 'process'))";

        createTable( student);
        createTable( faculty);
        createTable( course);
        createTable( results_exam);
        createTable( offsets);

        connection.close();

    }

    private static void createTable( final String sql) throws SQLException {
        Statement statement = null;

        System.out.println("Creating table in selected database...");
        statement = connection.createStatement();

        statement.executeUpdate(sql);
        System.out.println("Table successfully created...");

    }
}