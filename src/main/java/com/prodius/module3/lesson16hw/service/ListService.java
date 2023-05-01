package com.prodius.module3.lesson16hw.service;

import com.prodius.module3.lesson16hw.repository.Repository;

@Singleton
public class ListService {
    private final Repository repository;

    @Autowired
    public ListService(final Repository repository) {
        this.repository = repository;
    }
}
