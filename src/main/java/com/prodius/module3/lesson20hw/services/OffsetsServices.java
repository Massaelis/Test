package com.prodius.module3.lesson20hw.services;

import com.prodius.module3.lesson20hw.model.Offsets;
import com.prodius.module3.lesson20hw.repository.Crud;

public class OffsetsServices {
    private final Crud<Offsets, String> offsetsRepository;

    public OffsetsServices(Crud<Offsets, String> offsetsRepository) {
        this.offsetsRepository = offsetsRepository;
    }

    public void save(final Offsets offsets) {
        offsetsRepository.save(offsets);
    }

    public void printAll() {
        offsetsRepository.getAll().forEach(System.out::println);
    }
}