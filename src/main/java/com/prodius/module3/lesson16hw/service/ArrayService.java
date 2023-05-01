package com.prodius.module3.lesson16hw.service;

import com.prodius.module3.lesson16hw.repository.Repository;

@Singleton
public class ArrayService {
    private final Repository repository;

    @Autowired
    public ArrayService(final Repository repository) {
        this.repository = repository;
    }
}
