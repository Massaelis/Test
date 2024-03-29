package com.prodius.module3.lesson25hw.action;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.prodius.module3.lesson25hw.util.MongoUtil;
import com.prodius.module3.lesson25hw.util.UserInputUtil;
import org.bson.Document;
import org.bson.conversions.Bson;

public class SearchStudentByName implements Command {
    protected static final MongoDatabase DATABASE = MongoUtil.connect("university");

    private static final String COLLECTION_NAME = "students";

    static final MongoCollection<Document> university = DATABASE.getCollection(COLLECTION_NAME);

    @Override
    public void execute() { // FIXME: 08/06/23
        final String value = UserInputUtil.getUserString("Print name students: ");
        Bson filter = Filters.eq("name", value);

        FindIterable<Document> documents = university.find(filter);

        MongoCursor<Document> cursor = documents.iterator();
        while (cursor.hasNext()) {
            System.out.println(cursor.next());
        }
    }
}