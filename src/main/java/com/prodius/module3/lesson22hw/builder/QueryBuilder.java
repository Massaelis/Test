package com.prodius.module3.lesson22hw.builder;

import com.prodius.module3.lesson22hw.dto.StudentHqlDTO;
import com.prodius.module3.lesson22hw.dto.StudentSqlDTO;
import com.prodius.module3.lesson22hw.module.Student;
import org.hibernate.Session;

public class QueryBuilder {
    public static void query(Session session){
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
        session.createQuery("SELECT max(age) FROM Student")
                .list()
                .forEach(System.out::println);

        System.out.println("Show DTO from SQL");
        session.createQuery("select new com.prodius.module3.lesson22hw.dto.StudentSqlDTO(name,count(name)) " +
                                "from Student GROUP BY name",
                        StudentSqlDTO.class)
                .list()
                .forEach(System.out::println);

        session.close();
    }
}