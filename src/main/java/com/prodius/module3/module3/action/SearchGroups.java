package com.prodius.module3.module3.action;

import com.prodius.module3.module3.config.HibernateFactoryUtil;
import com.prodius.module3.module3.config.UserInputUtil;
import com.prodius.module3.module3.model.Group;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class SearchGroups implements Command {
    private final SessionFactory sessionFactory = HibernateFactoryUtil.getSessionFactory();

    @Override
    public void execute() {
        final String name = UserInputUtil.getUserString("Print name group: ");
        try (final Session session = sessionFactory.openSession()) {
            session.createNativeQuery("SELECT name FROM groups\n" +
                            "WHERE name LIKE :name", Group.class)
                    .setParameter("name", "%" + name + "%")
                    .getResultList()
                    .forEach(System.out::println);
        }
        Commands.logger.info("User search group with name {}", name);
    }

}