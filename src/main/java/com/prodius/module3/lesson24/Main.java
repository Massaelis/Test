package com.prodius.module3.lesson24;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Random;
import java.util.UUID;

public class Main {

    private static final Random RANDOM = new Random();

    private static final String COLLECTION_NAME = "persons";

    public static void main(String[] args) {
        final MongoDatabase database = MongoUtil.connect("test");
        database.drop();

        create(database);

        read(database);

        update(database);
        read(database);

//        delete(database);
//        read(database);
    }

    private static void create(final MongoDatabase database) {
        final Person person = createPerson();

        final Document document = new Document();
        document.append("_id", person.getId());
        document.append("name", person.getName());
        document.append("age", person.getAge());

        final MongoCollection<Document> persons = database.getCollection(COLLECTION_NAME);
        persons.insertOne(document);
    }

    private static void read(final MongoDatabase database) {
        final MongoCollection<Document> persons = database.getCollection(COLLECTION_NAME);

        final FindIterable<Document> documents = persons.find();

        for (Document doc : documents) {
            System.out.println(doc);
        }
    }

    private static void update(final MongoDatabase database) {
        final MongoCollection<Document> persons = database.getCollection(COLLECTION_NAME);

        final Document filter = new Document();
        filter.append("age", 80);

        final Document newData = new Document();
        newData.append("age", 50);

        final Document updateObject = new Document();
        updateObject.append("$set", newData);

        persons.updateOne(filter, updateObject);
    }

    private static void delete(final MongoDatabase database) {
        final MongoCollection<Document> persons = database.getCollection(COLLECTION_NAME);

        final Document filter = new Document();
        filter.append("age", 50);

        persons.deleteOne(filter);
    }

    private static Person createPerson() {
        final Person person = new Person();
        person.setId(UUID.randomUUID().toString());
        person.setName("Name" + RANDOM.nextInt());
        person.setAge(80);
        return person;
    }
}
