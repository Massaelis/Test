package com.prodius.module3.lesson22hw;

import com.prodius.module3.lesson22hw.builder.QueryBuilder;
import com.prodius.module3.lesson22hw.builder.StudentBuilder;

public class Main {

    public static void main(String[] args) {
        StudentBuilder studentBuilder = new StudentBuilder();
        studentBuilder.loadDataFromFile();
        QueryBuilder.query();
    }
}