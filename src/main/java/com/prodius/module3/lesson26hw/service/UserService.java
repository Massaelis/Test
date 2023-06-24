package com.prodius.module3.lesson26hw.service;

import com.prodius.module3.lesson26hw.model.TelephoneNumber;
import com.prodius.module3.lesson26hw.model.User;
import com.prodius.module3.lesson26hw.repository.UserRepository;

import org.hibernate.Transaction;
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
        return repository.save(created(id));
    }

    public void read() {
        repository.read();
        logger.info("Logging message: read users");
    }

    public void updateNameOfId(String id, String newName) {
        updateName(id, newName);
        logger.info("Logging message: update name user with id {}. New name: {}", id, newName);
    }

    public void updateAgeOfId(String id, Integer newAge) {
        updateAge(id, newAge);
        logger.info("Logging message: update age user with id {}. New age: {}", id, newAge);
    }


    public void deleteOfId(String value) {
        repository.deleteOfId(value);
        logger.info("Logging message: delete user with id {}", value);
    }

    public void updateName(String id, String after) {
        Transaction transaction = repository.session.beginTransaction();
        User user = repository.update(id);
        user.setName(after);
        repository.session.save(user);
        transaction.commit();
        System.out.println("Updated name: " + user);
    }

    public void updateAge(String id, Integer after) {
        Transaction transaction = repository.session.beginTransaction();
        User user = repository.update(id);
        user.setAge(after);
        repository.session.save(user);
        transaction.commit();
        System.out.println("Updated age: " + user);
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