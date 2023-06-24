package com.prodius.module3.lesson26hw.repository;

import com.prodius.module3.lesson26hw.model.User;

import java.util.List;

public interface Crud<O> {
    User create(O object);

    void update(O object);

    List<User> getAll();

    User getById(String id);

    void deleteOfId(String id);
}