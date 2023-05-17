package com.prodius.module3.lesson20hw;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseUtil {
    private static final String URL = "jdbc:postgresql://localhost:5432/student";

    private static final String USERNAME = "postgres";

    private static final String PASSWORD = "route";

    @SneakyThrows
    public static Connection getConnection() {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}