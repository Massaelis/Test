package com.prodius.module3.lesson26hw.service;

import com.prodius.module3.lesson26hw.model.TelephoneNumber;
import com.prodius.module3.lesson26hw.model.User;
import com.prodius.module3.lesson26hw.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private static final Random RANDOM = new Random();

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User create(String id) {
        logger.info("Logging message: create user with id {}", id);
        return repository.create(created(id));
    }

    public void read() {
        repository.getAll();
        logger.info("Logging message: getAll users");
    }

    public void updateNameOfId(String id, String newName) {
        User user = repository.getById(id);
        user.setName(newName);
        repository.update(user);
        logger.info("Logging message: getById name user with id {}. New name: {}", id, newName);
    }

    public void updateAgeOfId(String id, Integer newAge) {
        User user = repository.getById(id);
        user.setAge(newAge);
        repository.update(user);
        logger.info("Logging message: getById age user with id {}. New age: {}", id, newAge);
    }


    public void deleteOfId(String value) {
        repository.deleteOfId(value);
        logger.info("Logging message: delete user with id {}", value);
    }

    private User created(String id) {
        final User user = new User();
        user.setId(id);
        user.setName("user-" + RANDOM.nextInt(100));
        user.setAge(RANDOM.nextInt(16, 80));
        TelephoneNumber telephoneNumber = new TelephoneNumber("+" + RANDOM.nextInt(2000000, 9000000));
        user.setTelephoneNumber(String.valueOf(telephoneNumber));
        return user;
    }
}