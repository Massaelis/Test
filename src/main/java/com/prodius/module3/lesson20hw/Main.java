package com.prodius.module3.lesson20hw;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try (final Connection connection = DatabaseUtil.getConnection()) {

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
