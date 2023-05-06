package com.prodius.module3.lesson16hw.service;

import com.prodius.module3.lesson16hw.annotation.Autowired;
import com.prodius.module3.lesson16hw.annotation.Singleton;
import com.prodius.module3.lesson16hw.repository.MapRepository;
import com.prodius.module3.lesson16hw.repository.Repository;

@Singleton
public class MapService {
    private final Repository<String, String> repository;

    @Autowired(aClass = MapRepository.class)
    public MapService(final Repository<String, String> repository) {
        this.repository = repository;
    }
}
