package com.prodius.module3.lesson25hw.model;

import com.google.gson.annotations.SerializedName;
import org.bson.types.ObjectId;

public class Course {
    @SerializedName("_id")
    private final ObjectId id;

    private final String name;

    private final String description;

    public Course(ObjectId id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description=" + description +
                '}';
    }
}