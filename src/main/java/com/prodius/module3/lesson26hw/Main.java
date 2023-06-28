package com.prodius.module3.lesson26hw;

import com.prodius.module3.lesson26hw.model.Group;
import com.prodius.module3.lesson26hw.model.TelephoneNumber;
import com.prodius.module3.lesson26hw.model.User;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.Random;


public class Main {

    private static final Random RANDOM = new Random();

    @SneakyThrows
    public static void main(String[] args) {
        /*HibernateFactoryUtil.init();
        FlywayUtil.initMigration();

        UserRepository userRepository = new UserRepository();
        UserService userService = new UserService(userRepository);
        UserController userController = new UserController(userService);*/

        User user = create("111");
        User user2 = create("222");
        User user3 = create("333");

        /*userController.updateNameOfId("111", "jo-jo");
        userController.updateAgeOfId("111", 44);
        userController.updateNameOfId("333", "jotaro");
        userController.deleteOfId("222");
        userController.read();*/

        final ArrayList<User> users = new ArrayList<>();
        users.add(user);
        users.add(user3);

        Group group = new Group("Java", users);
        System.out.println(group);

        Group clone = group.clone();
        System.out.println("Cloned Object: " + clone + '\n');

        user.setAge(999);
        group.getUsers().add(user2);
        System.out.println(clone);

    }

    private static User create(String id) {
        final User user = new User();
        user.setId(id);
        user.setName("user-" + RANDOM.nextInt(100));
        user.setAge(RANDOM.nextInt(16, 80));
        TelephoneNumber telephoneNumber = new TelephoneNumber("+" + RANDOM.nextInt(2000000, 9000000));
        user.setTelephoneNumber(String.valueOf(telephoneNumber));
        return user;
    }
}