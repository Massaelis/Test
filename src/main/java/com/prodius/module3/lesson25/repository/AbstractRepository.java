package com.prodius.module3.lesson25.repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.prodius.module3.lesson25.model.Kennel;
import com.prodius.module3.lesson25.repository.typeAdapter.KennelTypeAdapter;
import com.prodius.module3.lesson25.util.MongoUtil;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class AbstractRepository<T> {
    protected static final Gson GSON = new GsonBuilder()
            .setPrettyPrinting()
            .registerTypeAdapter(Kennel.class, new KennelTypeAdapter())
            .create();

    protected static final MongoDatabase DATABASE = MongoUtil.connect("test");

    static {
        DATABASE.drop();
    }

    protected final MongoCollection<Document> collection;


    protected AbstractRepository(final String collectionName) {
        this.collection = DATABASE.getCollection(collectionName);
    }

    protected Document mapFrom(final T value) {
        return Document.parse(GSON.toJson(value));
    }

    protected T mapTo(final Document value, final Class<T> type) {
        return GSON.fromJson(value.toJson(), type);
    }

    public void insertMany(final Set<T> values) {
        final List<Document> collect = values.stream()
                .map(this::mapFrom)
                .collect(Collectors.toList());
        collection.insertMany(collect);
    }

    protected Set<T> findAll(final Class<T> type) {
        return collection.find()
                .map(document -> mapTo(document, type))
                .into(new HashSet<>());
    }

    protected Set<T> findAll(final Class<T> type, final Bson filter) {
        return collection.find(filter)
                .map(document -> mapTo(document, type))
                .into(new HashSet<>());
    }
}
