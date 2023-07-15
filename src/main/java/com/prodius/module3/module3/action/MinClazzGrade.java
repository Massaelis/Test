package com.prodius.module3.module3.action;

import com.prodius.module3.module3.dto.MiddleGradeDto;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MinClazzGrade implements Command {
    private static final Logger logger = LoggerFactory.getLogger(MinClazzGrade.class);

    @Override
    public void execute() {
        try (final Session session = sessionFactory.openSession()) {
            session.createNativeQuery("SELECT clazz.name, AVG(grade ) AS middle_grade\n" +
                            "FROM clazz\n" +
                            "JOIN grade ON grade.clazz_name = clazz.name\n" +
                            "GROUP BY name\n" +
                            "ORDER BY middle_grade \n" +
                            "LIMIT 1")
                    .setResultTransformer(Transformers.aliasToBean(MiddleGradeDto.class))
                    .getResultList()
                    .forEach(System.out::println);
        }
        logger.info("User search min class grade");
    }
}
