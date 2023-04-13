package com.prodius.module2.lesson15hw.notebook;

import lombok.Data;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Data
public class Notebook {
    public final List<Note> noteList = new ArrayList<>();

    public void addNote(Note note) {
        try {
            Optional.ofNullable(note).ifPresent(
                    note1 -> noteList.add(note)
            );
        } catch (NullPointerException e) {
            System.out.println("Not add a null");
        }
//        noteList.add(note);
    }

    public void removeNote(Note note) {
//        try {
//            Optional.ofNullable(note).ifPresent(
//                    note1 -> noteList.remove(note)
//            );
//        } catch (NullPointerException e) {
//            System.out.println("Not remove a null");
//        }
        noteList.remove(note);
    }

    public void saveNotesToFile(List<Note> list) throws IOException {
        FileWriter writer = new FileWriter("src/main/java/com/prodius/module2/lesson15hw/notebook/note.txt");
        for (Note note : list) {
            String title = note.getTitle();
            String text = note.getText();
            SimpleDateFormat dateCreated = note.getDateCreated();
            Date date = new Date();
            writer.write(title + " | " + text + " | " + dateCreated.format(date) + "\n");
        }
        writer.close();
    }
}