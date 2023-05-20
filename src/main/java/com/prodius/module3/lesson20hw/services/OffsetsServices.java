package com.prodius.module3.lesson20hw.services;

import com.prodius.module3.lesson20hw.model.Offsets;
import com.prodius.module3.lesson20hw.repository.OffsetsRepository;

public class OffsetsServices {
    private final OffsetsRepository offsetsRepository;

    public OffsetsServices(OffsetsRepository offsetsRepository) {
        this.offsetsRepository = offsetsRepository;
    }

    public void save(final Offsets offsets) {
        offsetsRepository.save(offsets);
    }

    public void printAll() {
        offsetsRepository.getAll().forEach(System.out::println);
    }

    public void getCompletedOffset() {
        offsetsRepository.getCompletedOffset().forEach(System.out::println);
    }
}