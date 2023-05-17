package com.prodius.module3.lesson20hw;

import java.sql.*;

import static com.prodius.module3.lesson20hw.CreateTable.connection;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        CreateTable createTable = new CreateTable();
        connection.setAutoCommit(false);

        createTable.createFaculty();
        createTable.createStudent();
        createTable.createCourse();
        createTable.createResults_exam();
        createTable.createOffsets();

        connection.commit();
        connection.close();
    }
}