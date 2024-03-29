package com.prodius.module3.lesson16hw.service;

import com.prodius.module3.lesson16hw.annotation.Autowired;
import com.prodius.module3.lesson16hw.annotation.Singleton;
import com.prodius.module3.lesson16hw.repository.ListRepository;
import com.prodius.module3.lesson16hw.repository.Repository;

@Singleton
public class ListService {
    private final Repository<String, Integer> repository;

    @Autowired(aClass = ListRepository.class)
    public ListService(final Repository<String, Integer> repository) {
        this.repository = repository;
    }
}
