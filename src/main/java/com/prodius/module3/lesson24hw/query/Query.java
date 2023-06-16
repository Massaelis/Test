package com.prodius.module3.lesson24hw.query;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.time.LocalDate;

import static com.prodius.module3.lesson24hw.repository.GroupRepository.COLLECTION_NAME;
import static com.prodius.module3.lesson24hw.repository.GroupRepository.database;

public class Query {
    final MongoCollection<Document> groups = database.getCollection(COLLECTION_NAME);

    public final void countPerson(int count) {
        Bson filter = Filters.gt("count_person", count);
        FindIterable<Document> documents = groups.find(filter);

        MongoCursor<Document> cursor = documents.iterator();
        while (cursor.hasNext()) {
            System.out.println(cursor.next());
        }
    }

    public final void dateStart(LocalDate date) {
        Bson filter3 = Filters.eq("date_start", date);

        FindIterable<Document> documents3 = groups.find(filter3);

        MongoCursor<Document> cursor3 = documents3.iterator();
        while (cursor3.hasNext()) {
            System.out.println(cursor3.next());
        }
    }

    public final void nameSearch(String s1, String s2) {
        Bson filter4 = Filters.in("name", s1, s2);
        FindIterable<Document> documents4 = groups.find(filter4);

        MongoCursor<Document> cursor4 = documents4.iterator();
        while (cursor4.hasNext()) {
            System.out.println(cursor4.next());
        }
    }

    public final void statusSearch(String s) {
        Bson filter2 = Filters.eq("status", s);

        FindIterable<Document> documents2 = groups.find(filter2);

        MongoCursor<Document> cursor2 = documents2.iterator();
        while (cursor2.hasNext()) {
            System.out.println(cursor2.next());
        }
    }
}