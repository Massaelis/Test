package com.prodius.lesson5.repository;

import com.prodius.lesson5.message.Massage;

import java.util.List;
import java.util.Optional;

public class Repository {
    public void save(final Massage massage) {

    }

    public List<Massage> getAll() {
        return null;
    }

    public List<Massage> getAll(final String sender) {
        return null;
    }

    public Massage getById(final Integer id) {
        return null;
    }

    public Optional<Massage> getByMessage(final Massage massage) {
        return Optional.empty();
    }
}
