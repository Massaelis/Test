package com.prodius.module3.lesson25.repository.typeAdapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.prodius.module3.lesson25.model.Kennel;

import java.io.IOException;

public class KennelTypeAdapter extends TypeAdapter<Kennel> {
    @Override
    public void write(final JsonWriter out, final Kennel value) throws IOException {
        out.beginObject()
                .name("kennelType")
                .value(value.toString())
                .endObject();
    }

    @Override
    public Kennel read(final JsonReader in) throws IOException {
        in.beginObject();

        if (in.hasNext()) {
            final JsonToken token = in.peek();
            System.out.println("Token: " + token);
            final String name = in.nextName();
            System.out.println("Name: " + name);
            final String value = in.nextString();
            in.endObject();
            return Kennel.valueOf(value);
        }

        in.endObject();
        return null;
    }
}
