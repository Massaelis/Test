package com.prodius.module3.lesson20hw.createTable;


import lombok.Getter;

@Getter
public enum CreateTables {
    FACULTY(
            "CREATE TABLE IF NOT EXISTS faculty " +
                    " (id TEXT PRIMARY KEY, " +
                    " faculty_name VARCHAR(100), " +
                    " dean VARCHAR(100))"
    ),
    STUDENT(
            "CREATE TABLE IF NOT EXISTS student " +
                    " (id TEXT PRIMARY KEY, " +
                    " name VARCHAR(50), " +
                    " surname VARCHAR(50), " +
                    " date DATE, " +
                    " email VARCHAR(100), " +
                    " id_faculty TEXT, " +
                    " FOREIGN KEY (id_faculty) REFERENCES faculty(id))"
    ),
    COURSE(
            "CREATE TABLE IF NOT EXISTS course " +
                    " (id TEXT PRIMARY KEY, " +
                    " group_name VARCHAR(100), " +
                    " date_start DATE, " +
                    " date_end DATE, " +
                    " id_faculty TEXT, " +
                    " FOREIGN KEY (id_faculty) REFERENCES faculty(id))"
    ),
    RESULTS_EXAM(
            "CREATE TABLE IF NOT EXISTS results_exam " +
                    " (id_results_exam TEXT PRIMARY KEY, " +
                    " id_student TEXT, " +
                    " id_course TEXT, " +
                    " date_exam DATE, " +
                    " FOREIGN KEY (id_student) REFERENCES student(id), " +
                    " FOREIGN KEY (id_course) REFERENCES course(id), " +
                    " grade INTEGER CHECK\n" +
                    "       (grade > -1 and grade < 11))"
    ),
    OFFSETS(
            "CREATE TABLE IF NOT EXISTS offsets " +
                    " (id_offsets TEXT PRIMARY KEY, " +
                    " id_student TEXT, " +
                    " id_course TEXT, " +
                    " date_offsets DATE, " +
                    " FOREIGN KEY (id_student) REFERENCES student(id), " +
                    " FOREIGN KEY (id_course) REFERENCES course(id), " +
                    " grade VARCHAR CHECK\n" +
                    "       (grade = 'completed' or grade = 'process'))"
    );

    private final String query;

    CreateTables(final String query) {
        this.query = query;
    }
}
