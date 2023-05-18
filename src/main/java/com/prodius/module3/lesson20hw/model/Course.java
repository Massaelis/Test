package com.prodius.module3.lesson20hw.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@Getter
@Setter
@ToString
public class Course {
    //id, group_name, date_start, date_end, id_faculty
    private final String id;
    private final String group_name;
    private final Date date_start;
    private final Date date_end;
    private final String id_faculty;

    public Course(String id, String group_name, Date date_start, Date date_end, String id_faculty) {
        this.id = id;
        this.group_name = group_name;
        this.date_start = date_start;
        this.date_end = date_end;
        this.id_faculty = id_faculty;
    }
}
