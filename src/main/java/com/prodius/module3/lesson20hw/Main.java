package com.prodius.module3.lesson20hw;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        final CreateTable createTable = new CreateTable();
        createTable.createTable();
    }
}