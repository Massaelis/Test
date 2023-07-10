package com.prodius.module3.module3.action;

import com.prodius.module3.module3.config.HibernateFactoryUtil;
import com.prodius.module3.module3.dto.MiddleGradeDto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;

public class MaxClazzGrade implements Command {
    private final SessionFactory sessionFactory = HibernateFactoryUtil.getSessionFactory();

    @Override
    public void execute() {
        try (final Session session = sessionFactory.openSession()) {
            session.createNativeQuery("SELECT clazz.name, AVG(grade ) AS middle_grade\n" +
                            "FROM clazz\n" +
                            "JOIN grade ON grade.clazz_name = clazz.name\n" +
                            "GROUP BY name\n" +
                            "ORDER BY middle_grade desc \n" +
                            "LIMIT 1")
                    .setResultTransformer(Transformers.aliasToBean(MiddleGradeDto.class))
                    .getResultList()
                    .forEach(System.out::println);
        }
        Commands.logger.info("User search max class grade");
    }
}
