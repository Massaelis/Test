package com.prodius.module3.module3.action;

import com.prodius.module3.module3.dto.MiddleGradeDto;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MiddleGroupsGrade implements Command {
    private static final Logger logger = LoggerFactory.getLogger(MiddleGroupsGrade.class);

    @Override
    public void execute() {
        try (final Session session = sessionFactory.openSession()) {
            session.createNativeQuery("SELECT groups.name,\n" +
                            "AVG(grade) AS middle_grade\n" +
                            "FROM groups\n" +
                            "INNER JOIN student ON groups.name = student.groups_name\n" +
                            "INNER JOIN grade ON grade.student_surname = student.surname\n" +
                            "GROUP BY groups.name")
                    .setResultTransformer(Transformers.aliasToBean(MiddleGradeDto.class))
                    .getResultList()
                    .forEach(System.out::println);
        }
        logger.info("User search middle group grade");
    }
}