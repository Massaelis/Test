package com.prodius.module3.lesson22hw.builder;

import com.prodius.module3.lesson22hw.config.HibernateFactoryUtil;
import com.prodius.module3.lesson22hw.dto.StudentHqlDTO;
import com.prodius.module3.lesson22hw.dto.StudentSqlDTO;
import com.prodius.module3.lesson22hw.module.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.hibernate.type.IntegerType;

public class QueryBuilder {
    public static void query() {
        final SessionFactory sessionFactory = HibernateFactoryUtil.getSessionFactory();

        try (final Session session = sessionFactory.openSession()) {
            System.out.println("Name bigger than 10 symbols");
            session.createQuery("from Student s WHERE length(s.name) > :nameLength", Student.class)
                    .setParameter("nameLength", 10)
                    .list()
                    .forEach(System.out::println);


            System.out.println("Show DTO from HQL");
            session.createQuery("select new com.prodius.module3.lesson22hw.dto.StudentHqlDTO(id, name, email) " +
                                    "from Student",
                            StudentHqlDTO.class)
                    .list()
                    .forEach(System.out::println);

            System.out.println("Show all student from SQL");
            session.createNativeQuery("SELECT * FROM Student ORDER BY surname", Student.class)
                    .list()
                    .forEach(System.out::println);

            System.out.println("Show max age from SQL");
            session.createNativeQuery("SELECT max(age) as maxAge FROM Student")
                    .addScalar("maxAge", IntegerType.INSTANCE)
                    .list()
                    .forEach(System.out::println);

            System.out.println("Show DTO from SQL");
            session.createNativeQuery("select name, count(name) as studentCount from Student GROUP BY name")
                    .setResultTransformer(Transformers.aliasToBean(StudentSqlDTO.class))
                    .list()
                    .forEach(System.out::println);
        }
    }
}