package com.prodius.module3.module3;


import com.prodius.module3.module3.action.Commands;
import com.prodius.module3.module3.config.FlywayUtil;
import com.prodius.module3.module3.config.HibernateFactoryUtil;
import com.prodius.module3.module3.config.UserInputUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateFactoryUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        t.commit();

        FlywayUtil.initMigration();

        final Commands[] values = Commands.values();

        final List<String> menuItems = Arrays.stream(values)
                .map(Objects::toString)
                .collect(Collectors.toList());

        while (true) {
            final int userChoice = UserInputUtil.getUserChoice("What you want to do?", menuItems);
            values[userChoice].execute();
        }

        //Предмет із найгіршою та найкращою успішністю !!!!!!!!!!!!!!!!!!!!

//        SELECT clazz.name, AVG(grade ) as middle_grade
//          FROM clazz
//        join grade ON grade.clazz_name = clazz.name
//        GROUP BY name
    }
}
