package com.prodius.module2.lesson15hw;

import com.prodius.module2.lesson15hw.notebook.Note;
import com.prodius.module2.lesson15hw.notebook.Notebook;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Notebook notebook = new Notebook();

        //1
        System.out.println("~".repeat(20) + " Part one " + "~".repeat(20));
        notebook.addNote(new Note("10", "11", new Date()));
        notebook.addNote(new Note("20", "22", new Date()));
        System.out.println(notebook.getNoteList());
        notebook.removeNote(new Note("20", "22", new Date()));
        System.out.println(notebook.getNoteList());
        notebook.addNote(new Note("30", "33", new Date()));
        System.out.println(notebook.getNoteList());
        notebook.addNote(null);
        System.out.println(notebook.getNoteList());
        notebook.saveNotesToFile();
        notebook.readeNotesFromFile();

        System.out.println("~".repeat(20) + " Part two " + "~".repeat(20));
        //2
        ListDate.readAndCheck();
    }
}
