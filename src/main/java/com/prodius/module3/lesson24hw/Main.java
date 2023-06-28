package com.prodius.module3.lesson24hw;

import com.prodius.module3.lesson24hw.model.Group;
import com.prodius.module3.lesson24hw.model.StatusGroup;
import com.prodius.module3.lesson24hw.query.Query;
import com.prodius.module3.lesson24hw.repository.GroupRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.prodius.module3.lesson24hw.repository.GroupRepository.database;

public class Main {

    public static void main(String[] args) {
        GroupRepository groupRepository = new GroupRepository();
        Query query = new Query();

        database.drop();

        Group groupFirst = groupRepository.createGroup(20, "Java", "09/05/2023", StatusGroup.INACTIVE);
        groupRepository.create(groupFirst);
        Group groupSecond = groupRepository.createGroup(15, "PHP", "05/15/2023", StatusGroup.ACTIVE);
        groupRepository.create(groupSecond);
        groupRepository.read();
        groupRepository.updateOfName("PHP", "C++");
        groupRepository.read();
//        groupRepository.deleteOfName("C++");
//        groupRepository.getAll();

        System.out.println("~".repeat(30));
        query.countPerson(15);

        System.out.println("~".repeat(30));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        query.dateStart(LocalDate.parse("09/05/2023", formatter));

        System.out.println("~".repeat(30));
        query.nameSearch("C++", "Java");

        System.out.println("~".repeat(30));
        query.statusSearch("Inactive");
    }
}