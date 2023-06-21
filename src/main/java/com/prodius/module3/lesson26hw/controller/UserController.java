package com.prodius.module3.lesson26hw.controller;

import com.prodius.module3.lesson26hw.service.UserService;

public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    public void create(String id) {
       service.create(id);
    }

    public void read() {
        service.read();
    }

    public void updateNameOfId(String before, String after){
        service.updateNameOfId(before, after);
    }

    public void updateAgeOfId(String before, Integer after) {
        service.updateAgeOfId(before, after);
    }

    public void deleteOfId(String value) {
        service.deleteOfId(value);
    }
}
