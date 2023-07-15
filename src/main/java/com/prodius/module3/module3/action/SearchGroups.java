package com.prodius.module3.module3.action;

import com.prodius.module3.module3.config.UserInputUtil;
import com.prodius.module3.module3.model.Group;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SearchGroups implements Command {
    private static final Logger logger = LoggerFactory.getLogger(SearchGroups.class);

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
        logger.info("User search group with name {}", name);
    }

}