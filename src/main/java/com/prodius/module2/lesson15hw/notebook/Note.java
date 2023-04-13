package com.prodius.module2.lesson15hw.notebook;

import lombok.Data;

import java.text.SimpleDateFormat;

@Data
public class Note {
    private final String title;
    private final String text;
    private final SimpleDateFormat dateCreated = new SimpleDateFormat("dd.MM.yyyy");
}
