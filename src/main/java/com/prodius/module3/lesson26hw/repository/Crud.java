package com.prodius.module3.lesson26hw.repository;

import com.prodius.module3.lesson26hw.model.User;

public interface Crud<O> {
    User save(O object);

    void read();

    User update(String id);

    void deleteOfId(String id);
}