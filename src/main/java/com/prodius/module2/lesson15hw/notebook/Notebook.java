package com.prodius.module2.lesson15hw.notebook;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Notebook {
    private final List<Note> noteList = new ArrayList<>();

    private static final String NOTES_FILE = "src/main/java/com/prodius/module2/lesson15hw/notebook/note.txt";

    public void addNote(Note note) {
        Optional.ofNullable(note).ifPresent(
                note1 -> noteList.add(note)
        );
    }

    public void removeNote(Note note) {
        noteList.remove(note);
    }

    public List<Note> getNoteList() {
        return noteList;
    }

    public void saveNotesToFile() {
        try (final BufferedWriter writer = new BufferedWriter(new FileWriter(NOTES_FILE, true))) {
            for (Note note : noteList) {
                final String title = note.getTitle();
                final String text = note.getText();
                final String dateCreated = note.getDateCreated();
                writer.write(String.format("%s | %s | %s%n", title, text, dateCreated));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readeNotesFromFile() {
        try (final BufferedReader reader = new BufferedReader(new FileReader(NOTES_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                final String[] parts = line.split(" \\| ");

                final String title = parts[0];
                final String text = parts[1];
                final String date = parts[2];
                if (checkDate(date)) {
                    final Note note = new Note(title, text, date);
                    System.out.println(note);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Can't find file");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private boolean checkDate(final String dateString) {
        try {
            Note.DATE_CREATED_FORMATTER.parse(dateString);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}