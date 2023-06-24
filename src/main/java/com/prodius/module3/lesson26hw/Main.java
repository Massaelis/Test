package com.prodius.module3.lesson26hw;

import com.prodius.module3.lesson26hw.controller.UserController;
import com.prodius.module3.lesson26hw.model.Group;
import com.prodius.module3.lesson26hw.model.User;
import com.prodius.module3.lesson26hw.repository.UserRepository;
import com.prodius.module3.lesson26hw.service.UserService;
import org.flywaydb.core.Flyway;

import java.util.List;


public class Main {

    public static void main(String[] args) {
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

        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:postgresql://localhost:5432/test2", "postgres", "999267")
                .baselineOnMigrate(true)
                .locations("db/migration/lesson26hw")
                .load();
        flyway.migrate();

        userController.read();

        Group group = new Group("Java", List.of(user,user3));

        System.out.println(group);

        System.out.println(group.clone());
    }
}