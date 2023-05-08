package com.prodius.module3.lesson17;

import java.util.Set;

public class Note {
    private Notebook notebook; // ONE-to-ONE

    private Set<Comment> comments; // ONE-to-MANY

    private Set<Author> authors; // MANY-to-MANY
}
