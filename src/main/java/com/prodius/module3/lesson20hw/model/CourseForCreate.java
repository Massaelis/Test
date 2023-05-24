package com.prodius.module3.lesson20hw.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;
@Getter
@Setter
@ToString
public class CourseForCreate {
    private final String id;

    private final String groupName;

    private final Date dateStart;

    private final Date dateEnd;

    private final Faculty faculty;

    public CourseForCreate(String id, String groupName, Date dateStart, Date dateEnd, Faculty faculty) {
        this.id = id;
        this.groupName = groupName;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.faculty = faculty;
    }
}
