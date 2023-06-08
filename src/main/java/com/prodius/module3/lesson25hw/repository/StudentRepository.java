package com.prodius.module3.lesson25hw.repository;

import com.mongodb.client.MongoCollection;
import com.prodius.module3.lesson25hw.model.Student;
import org.bson.Document;

import java.util.Random;
import java.util.Set;

public class StudentRepository extends AbstractRepository<Student> {
    private static final String COLLECTION_NAME = "students";

    private static final Random RANDOM = new Random();

    private static StudentRepository instance;

    public StudentRepository() {
        super(COLLECTION_NAME);
    }

    public static StudentRepository getInstance() {
        if (instance == null) {
            instance = new StudentRepository();
        }
        return instance;
    }

    public Set<Student> findAll() {
        return super.findAll(Student.class);
    }


    public void updateOfId(String id) {
        final MongoCollection<Document> group = DATABASE.getCollection(COLLECTION_NAME);

        final Document filter = new Document();
        filter.append("_id", id);

        final Document newData = new Document();
        newData.append("name", "Student-" + RANDOM.nextInt(100));

        final Document updateObject = new Document();
        updateObject.append("$set", newData);

        group.updateOne(filter, updateObject);
    }

    public void deleteOfId(String id) {
        final MongoCollection<Document> group = DATABASE.getCollection(COLLECTION_NAME);

        final Document filter = new Document();
        filter.append("_id", id);

        group.deleteOne(filter);
    }
}