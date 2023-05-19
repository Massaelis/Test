package com.prodius.module3.lesson20hw.controller;

import com.prodius.module3.lesson20hw.model.Offsets;
import com.prodius.module3.lesson20hw.services.OffsetsServices;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class OffsetsController {
    private final OffsetsServices offsetsServices;

    public OffsetsController(OffsetsServices offsetsServices) {
        this.offsetsServices = offsetsServices;
    }
    private static final String OFFSETS_FILE = "src/main/java/com/prodius/module3/lesson20hw/txt/offsets";

    public void createFacultyFromFile() {
        try (final BufferedReader reader = new BufferedReader(new FileReader(OFFSETS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                final String[] parts = line.split(",");
                final String id_offsets = parts[0];
                final String id_student = parts[1];
                final String id_course = parts[2];

                final DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH);
                java.util.Date date = df.parse(parts[3]);
                java.sql.Date date_offsets = new java.sql.Date(date.getTime());

                final String grade = parts[4];
                final Offsets offsets = new Offsets(id_offsets, id_student, id_course, date_offsets, grade);
                offsetsServices.save(offsets);
                System.out.println(offsets);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Can't find file");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public void printAll() {
        offsetsServices.printAll();
    }
}
