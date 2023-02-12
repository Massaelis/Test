package com.prodius.lesson1.array.util;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public final class StringInputUtil {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));


    @SneakyThrows
    public static String getString(final int minLength) {
        String line;
        System.out.println("Input your line");
        do {
            System.out.println("Line must contains minimum 3 characters");
            line = READER.readLine();
        } while (line.length() <= minLength);
        return line;
    }
}
