package com.prodius.module3.lesson24hw;

import com.prodius.module3.lesson24hw.repository.GroupRepository;

import java.time.format.DateTimeFormatter;

public class Main {
    private static final String COLLECTION_NAME = "group";

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");


    public static void main(String[] args) {
//        final MongoDatabase database = MongoUtil.connect("testHW");
//        database.drop();

        GroupRepository groupRepository = new GroupRepository();
        groupRepository.database.drop();

        groupRepository.create();
        groupRepository.read();
        groupRepository.updateOfName("Java","C++");
        groupRepository.read();
        groupRepository.deleteOfName("C++");
        groupRepository.read();

    }

//    private static void create(final MongoDatabase database) {
//        final Group group = createGroup(StatusGroup.INACTIVE);
//
//        final Document document = new Document();
//        document.append("_id", group.getId());
//        document.append("count_person", group.getCountPerson());
//        document.append("name", group.getName());
//        document.append("date_start", group.getStartDate());
//        document.append("status", group.getStatusGroup());
//
//        final MongoCollection<Document> groups = database.getCollection(COLLECTION_NAME);
//        groups.insertOne(document);
//    }

//    private static Group createGroup(StatusGroup statusGroup){
//        final Group group = new Group();
//        group.setId(UUID.randomUUID().toString());
//        group.setCountPerson(20);
//        group.setName("A-Level");
//        group.setStartDate(LocalDate.parse("09/05/2023", formatter));
//        group.setStatusGroup(String.valueOf(statusGroup));
//        return group;
//    }

//    private static void read(final MongoDatabase database) {
//        final MongoCollection<Document> group = database.getCollection(COLLECTION_NAME);
//
//        final FindIterable<Document> documents = group.find();
//
//        for (Document doc : documents) {
//            System.out.println(doc);
//        }
//    }
}
