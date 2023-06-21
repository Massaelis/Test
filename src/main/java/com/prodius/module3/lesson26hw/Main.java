package com.prodius.module3.lesson26hw;

import com.prodius.module3.lesson26hw.controller.UserController;
import com.prodius.module3.lesson26hw.repository.UserRepository;
import com.prodius.module3.lesson26hw.service.UserService;

public class Main {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();
        UserService userService = new UserService(userRepository);
        UserController userController = new UserController(userService);

        userController.create("111");
        userController.create("222");
        userController.create("333");

        userController.updateNameOfId("111", "jo-jo");
        userController.deleteOfId("222");
        userController.read();
    }
}