package com.prodius.module3.lesson20hw.controller;

import com.prodius.module3.lesson20hw.services.OffsetsServices;

public class OffsetsController {
    private static final String OFFSETS_FILE = "lesson20/offsets.csv";

    private final OffsetsServices offsetsServices;

    public OffsetsController(OffsetsServices offsetsServices) {
        this.offsetsServices = offsetsServices;
    }

    public void createFacultyFromFile() {
        offsetsServices.loadDataFromFile(OFFSETS_FILE);
    }
    public void getCompletedOffset() {
        System.out.println(offsetsServices.getCompletedOffset());
    }
}
