package com.prodius.module3.lesson24hw.repository;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.prodius.module3.lesson24hw.model.Group;
import com.prodius.module3.lesson24hw.model.StatusGroup;
import com.prodius.module3.lesson24hw.util.MongoUtil;
import org.bson.Document;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class GroupRepository implements Crud<String>{

    public final MongoDatabase database = MongoUtil.connect("testHW");

    private static final String COLLECTION_NAME = "group";

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

    @Override
    public void create() {
        final Group group = createGroup(StatusGroup.INACTIVE);

        final Document document = new Document();
        document.append("_id", group.getId());
        document.append("count_person", group.getCountPerson());
        document.append("name", group.getName());
        document.append("date_start", group.getStartDate());
        document.append("status", group.getStatusGroup());

        final MongoCollection<Document> groups = database.getCollection(COLLECTION_NAME);
        groups.insertOne(document);
    }

    @Override
    public void read() {
        final MongoCollection<Document> group = database.getCollection(COLLECTION_NAME);

        final FindIterable<Document> documents = group.find();

        for (Document doc : documents) {
            System.out.println(doc);
        }
    }

    @Override
    public void updateOfName(String before, String after) {
        final MongoCollection<Document> group = database.getCollection(COLLECTION_NAME);

        final Document filter = new Document();
        filter.append("name", before);

        final Document newData = new Document();
        newData.append("name", after);

        final Document updateObject = new Document();
        updateObject.append("$set", newData);

        group.updateOne(filter, updateObject);
    }

    @Override
    public void deleteOfName(String name) {
        final MongoCollection<Document> group = database.getCollection(COLLECTION_NAME);

        final Document filter = new Document();
        filter.append("name", name);

        group.deleteOne(filter);
    }

    private Group createGroup(StatusGroup statusGroup){
        final Group group = new Group();
        group.setId(UUID.randomUUID().toString());
        group.setCountPerson(20);
        group.setName("Java");
        group.setStartDate(LocalDate.parse("09/05/2023", formatter));
        group.setStatusGroup(String.valueOf(statusGroup));
        return group;
    }
}
