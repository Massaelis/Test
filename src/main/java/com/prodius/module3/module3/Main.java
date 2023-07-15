package com.prodius.module3.module3;


import com.prodius.module3.module3.action.Commands;
import com.prodius.module3.module3.config.FlywayUtil;
import com.prodius.module3.module3.config.HibernateFactoryUtil;
import com.prodius.module3.module3.config.UserInputUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        // for init tables with create mode
        HibernateFactoryUtil.getSessionFactory();
        FlywayUtil.initMigration();

        final Commands[] values = Commands.values();

        final List<String> menuItems = Arrays.stream(values)
                .map(Objects::toString)
                .collect(Collectors.toList());

        logger.info("User start program");

        while (true) {
            final int userChoice = UserInputUtil.getUserChoice("What you want to do?", menuItems);
            values[userChoice].execute();
        }
    }
}
