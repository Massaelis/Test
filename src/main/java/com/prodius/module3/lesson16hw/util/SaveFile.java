package com.prodius.module3.lesson16hw.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class SaveFile {
    private static final String NOTES_FILE = "src/main/output/save.txt";

    public static void saveToFile(final Map<Class<?>, Object> map) {
        try (final BufferedWriter writer = new BufferedWriter(new FileWriter(NOTES_FILE))) {
            map.values().forEach(object -> {
                final String simpleName = object.getClass().getSimpleName();

                write(writer, String.format("Class: %s%n", simpleName));

                Arrays.stream(object.getClass().getDeclaredMethods())
                        .forEach(method -> {
                            final String parameters = Arrays.stream(method.getParameters())
                                    .map(parameter -> parameter.getType().getSimpleName())
                                    .collect(Collectors.joining(", "));

                            final String line = String.format("\tMethod: %s, Parameters: %s%n",
                                    method.getName(), parameters);
                            write(writer, line);
                        });

                write(writer, "\n");
            });
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    private static void write(final BufferedWriter writer, final String line) {
        try {
            writer.write(line);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}