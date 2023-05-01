package com.prodius.module3.lesson16hw.service;

import com.prodius.module3.lesson16hw.repository.Repository;

@Singleton
public class MapService {
    private final Repository repository;

    @Autowired
    public MapService(final Repository repository) {
        this.repository = repository;
    }
}
