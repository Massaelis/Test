package com.prodius.module3.lesson22hw.builder;

import com.prodius.module3.lesson22hw.module.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class StudentBuilder {
    public static void students(SessionFactory sessionFactory) {
        final Session session1 = sessionFactory.openSession();
        StudentBuilder studentBuilder = new StudentBuilder();
        session1.beginTransaction();
        try {
        session1.save(studentBuilder.student("86f76591-ce83-4212-9fb5-4bed6cd28440",
                "Rudolfo", "Whitehorne", "gwhitehorne0@slashdot.org", "6/20/1995", 27));
        session1.save(studentBuilder.student("e635eb5b-b37c-42a4-b7f8-45b7afa8ce69",
                "Renaldo","Webberley","rwebberley1@squidoo.com","3/4/1999",24));
        session1.save(studentBuilder.student("df1887b3-1456-4d8a-bea9-656c384db0ea",
                "Malvina","Samuels","msamuels2@nytimes.com","11/24/1990",32));
        session1.save(studentBuilder.student("e4e76ac3-8ab6-4f58-94e0-409cdc2a5031",
                "Broddy","Shout","bshout3@opera.com","10/2/1995",27));
        session1.save(studentBuilder.student("b76a9c6f-ff42-40f0-b3cd-765a138aa785",
                "Brendan","Fair","bfair4@cloudflare.com","7/28/1998",24));
        session1.save(studentBuilder.student("163c6ac5-5a4c-494e-84b3-6073ba45be43",
                "Robyn","Schapiro","rschapiro5@china.com","11/12/1992",30));
        session1.save(studentBuilder.student("119c501c-e725-4e6a-ab52-2baba4832ea9",
                "Alonzo","Stiggers","astiggers6@angelfire.com","3/24/1996",27));
        session1.save(studentBuilder.student("606fdc5b-ce44-4709-9675-963bf8d1b20a",
                "Jerrylee","Stuehmeyer","jstuehmeyer7@jigsy.com","12/10/1991",31));
        session1.save(studentBuilder.student("2b0b5c51-a67d-4f23-a437-6329cc955c8b",
                "Barbara-anne","Cullin","bcullin8@scribd.com","1/29/1999",24));
        session1.save(studentBuilder.student("24cba5c4-fedd-438d-896b-7a1084fef243",
                "Rudolfo","Saynor","rsaynor9@domainmarket.com","4/13/1991",32));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        session1.getTransaction().commit();
        session1.close();
    }

    public Student student(String id,String name, String surname, String email, String data, int age) throws ParseException {
        final Student student = new Student();
        student.setId(id);
        student.setName(name);
        student.setSurname(surname);
        student.setEmail(email);
        final DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        java.sql.Date dateSql = new java.sql.Date(df.parse(data).getTime());
        student.setDateOfBirth(dateSql);
        student.setAge(age);

        return student;
    }
}