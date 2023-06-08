package com.prodius.module3.lesson25hw;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.time.LocalDate;

public class DataTypeAdapter extends TypeAdapter<LocalDate> {

    @Override
    public void write(JsonWriter out, LocalDate localDate) throws IOException {
        out.beginObject()
                .name("dateOfBirth")
                .value(localDate.toString())
                .endObject();
    }

    @Override
    public LocalDate read(final JsonReader in) throws IOException {
        in.beginObject();

        if (in.hasNext()) {
            final JsonToken token = in.peek();
//            System.out.println("Token: " + token);
            final String name = in.nextName();
//            System.out.println("Name: " + name);
            final String value = in.nextString();
            in.endObject();
            return LocalDate.parse(value);
        }
        in.endObject();
        return null;
    }
}