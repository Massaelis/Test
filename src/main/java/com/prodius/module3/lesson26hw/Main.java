package com.prodius.module3.lesson26hw;

import com.prodius.module3.lesson26hw.config.FlywayUtil;
import com.prodius.module3.lesson26hw.config.HibernateFactoryUtil;
import com.prodius.module3.lesson26hw.controller.UserController;
import com.prodius.module3.lesson26hw.model.Group;
import com.prodius.module3.lesson26hw.model.User;
import com.prodius.module3.lesson26hw.repository.UserRepository;
import com.prodius.module3.lesson26hw.service.UserService;

import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {
        HibernateFactoryUtil.init();
        FlywayUtil.initMigration();

        UserRepository userRepository = new UserRepository();
        UserService userService = new UserService(userRepository);
        UserController userController = new UserController(userService);

        User user = userController.create("111");
        User user2 = userController.create("222");
        User user3 = userController.create("333");

        userController.updateNameOfId("111", "jo-jo");
        userController.updateAgeOfId("111", 44);
        userController.updateNameOfId("333", "jotaro");
        userController.deleteOfId("222");
        userController.read();

        final ArrayList<User> users = new ArrayList<>();
        users.add(user);
        users.add(user3);

        Group group = new Group("Java", users);
        System.out.println(group);

        final Group clone = group.clone();
        System.out.println(clone);

        user.setAge(999);
        group.getUsers().add(user2);
        System.out.println(clone);

    }
}