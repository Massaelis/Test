package com.prodius.module2.lesson15hw;

import com.prodius.module2.lesson15hw.notebook.Note;
import com.prodius.module2.lesson15hw.notebook.Notebook;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        //1
        System.out.println("~".repeat(20) + " Part one " + "~".repeat(20));
        Notebook notebook = new Notebook();
        notebook.addNote(new Note("10", "11"));
        notebook.addNote(new Note("20", "22"));
        System.out.println(notebook.noteList);
        notebook.removeNote(new Note("20", "22"));
        System.out.println(notebook.noteList);
        notebook.addNote(new Note("30", "33"));
        System.out.println(notebook.noteList);
        notebook.addNote(null);
        System.out.println(notebook.noteList);
        notebook.saveNotesToFile(notebook.noteList);

        System.out.println("~".repeat(20) + " Part two " + "~".repeat(20));
        //2
        ListDate.createFile();
        ListDate.checkList(ListDate.createList());
    }
}
