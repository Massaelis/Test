package com.prodius.module4.module4.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
public class Details {
    ///stats/{id} - відображає інформацію про конкретну деталь:

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    //дата проведення
    private LocalDate date;

    //кількість витраченого часу (секунди)
    private long time;
//    unixTime = System.currentTimeMillis() / 1000L

    //кількість видобутого палива
    private int fuel;

    //кількість зламаних мікросхем
    private int brokeSchemas;
}
