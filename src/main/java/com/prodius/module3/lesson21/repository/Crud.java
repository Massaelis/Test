package com.prodius.module3.lesson21.repository;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Set;

public interface Crud<T, K> {
    void save(T value);

    T getById(K id);

    Set<T> getAll();

    void delete(K id);

    String URL = "jdbc:postgresql://localhost:5432/test"; // TODO: 17/05/23 show work with property

    String USERNAME = "postgres";

    String PASSWORD = "root";

    @SneakyThrows
    default Connection getConnection() {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }


}
