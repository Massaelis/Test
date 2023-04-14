package com.prodius.module2.lesson15hw.notebook;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class Note {
    public static final SimpleDateFormat DATE_CREATED_FORMATTER = new SimpleDateFormat("dd.MM.yyyy");

    private final String title;

    private final String text;

    private final String dateCreated;

    public Note(final String title, final String text, final Date dateCreated) {
        this.title = title;
        this.text = text;
        this.dateCreated = DATE_CREATED_FORMATTER.format(dateCreated);
    }

    public Note(final String title, final String text, final String dateCreated) {
        this.title = title;
        this.text = text;
        this.dateCreated = dateCreated;
    }
}
