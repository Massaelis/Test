package com.prodius.module3.lesson26hw.service;

import com.prodius.module3.lesson26hw.model.User;
import com.prodius.module3.lesson26hw.repository.UserRepository;
import org.apache.logging.log4j.LogManager;

import java.util.Random;

public class UserService {
    private static final org.apache.logging.log4j.Logger logger =  LogManager.getLogger(UserService.class);

    private static final Random RANDOM = new Random();
    private final UserRepository repository;
    public UserService(UserRepository repository) {
        this.repository = repository;
    }
    public void create(String id) {
        repository.create(created(id));
    }
    public void read() {
        repository.read();
    }
    public void updateNameOfId(String before, String after){
        repository.updateNameOfId(before, after);
    }
    public void updateAgeOfId(String before, Integer after) {
        repository.updateAgeOfId(before, after);
    }
    public void deleteOfId(String value) {
        repository.deleteOfId(value);
    }
    private User created(String id) {
        final User user = new User();
        logger.trace("We've just greeted the user!");
        logger.debug("We've just greeted the user!");
        logger.info("We've just greeted the user!");
        logger.warn("We've just greeted the user!");
        logger.error("We've just greeted the user!");
        logger.fatal("We've just greeted the user!");
        user.setId(id);
        user.setName("user-" + RANDOM.nextInt(100));
        user.setAge(RANDOM.nextInt(16, 80));
        return user;
    }
}