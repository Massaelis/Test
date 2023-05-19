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
    private final String groupName;
    private final Date dateStart;
    private final Date dateEnd;
    private final String idFaculty;

    public Course(String id, String groupName, Date dateStart, Date dateEnd, String idFaculty) {
        this.id = id;
        this.groupName = groupName;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.idFaculty = idFaculty;
    }
}