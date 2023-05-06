package com.prodius.module3.lesson16hw.service;

import com.prodius.module3.lesson16hw.annotation.Autowired;
import com.prodius.module3.lesson16hw.annotation.Singleton;
import com.prodius.module3.lesson16hw.repository.ArrayRepository;
import com.prodius.module3.lesson16hw.repository.Repository;

@Singleton
public class ArrayService {
    private final Repository<String, Integer> repository;

    @Autowired(aClass = ArrayRepository.class)
    public ArrayService(final Repository<String, Integer> repository) {
        this.repository = repository;
    }
}
