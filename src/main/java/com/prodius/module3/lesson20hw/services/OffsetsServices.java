package com.prodius.module3.lesson20hw.services;

import com.prodius.module3.lesson20hw.model.Offsets;
import com.prodius.module3.lesson20hw.repository.OffsetsRepository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Objects;

public class OffsetsServices {
    private final OffsetsRepository offsetsRepository;

    public OffsetsServices(OffsetsRepository offsetsRepository) {
        this.offsetsRepository = offsetsRepository;
    }

    public void loadDataFromFile(final String filename) {
        final InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream(filename);
        try (final BufferedReader reader = new BufferedReader(
                new InputStreamReader(Objects.requireNonNull(resourceAsStream)))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                final String[] parts = line.split(",");
                final String id_offsets = parts[0];
                final String id_student = parts[1];
                final String id_course = parts[2];

                final DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH);
                java.sql.Date dateOffsets = new java.sql.Date(df.parse(parts[3]).getTime());

                final String grade = parts[4];
                final Offsets offsets = new Offsets(id_offsets, null, id_student, null, id_course, dateOffsets, grade);
                offsetsRepository.save(offsets);
                System.out.println(offsets);
            }
        } catch (RuntimeException e) {
            System.out.println("Duplicate key value violates unique constraint \"faculty_pkey\"");
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            System.out.println("Can't find file");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public int getCompletedOffset() {
        return offsetsRepository.getCompletedOffset();
    }
}