package com.prodius.module2.lesson15hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.regex.Pattern;

public class ListDate {
    private static final String FILE_PATH = "file.txt";

    private static final Pattern p1 = Pattern.compile("^[0-3]\\d-(0\\d|1[0-2])-\\d{4}");

    private static final Pattern p2 = Pattern.compile("^\\d{4}-\\d{2}");

    private static final Pattern p3 = Pattern.compile("^\\d{2}/\\d{2}");

    private static final Pattern p4 = Pattern.compile("^[0-3]\\d \\S* \\d{4}");

    public static void readAndCheck() {
        final ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();

        try (final InputStream resourceAsStream = contextClassLoader.getResourceAsStream(FILE_PATH);
             final BufferedReader reader = new BufferedReader(new InputStreamReader(
                     Objects.requireNonNull(resourceAsStream))
             )
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                checkLine(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static void checkLine(final String line) {
        if (p1.matcher(line).find()) {
            System.out.println("Date in format \"dd-mm-yyyy\": " + line);
            return;
        }

        if (p2.matcher(line).find()) {
            System.out.println("Date in format \"yyyy-mm-dd\": " + line);
            return;
        }

        if (p3.matcher(line).find()) {
            System.out.println("Date in format \"mm/dd/yyyy\": " + line);
            return;
        }

        if (p4.matcher(line).find()) {
            System.out.println("Date in format \"dd month yyyy\": " + line);
        }
    }
}
