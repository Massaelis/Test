package com.prodius.module4.module4.servlets;

import com.prodius.module4.module4.config.HibernateFactoryUtil;
import com.prodius.module4.module4.threads.MyThreadStarter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.IOException;

@WebServlet(name = "Start", value = "/start")
public class Start extends HttpServlet {
    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/start.jsp").forward(req, resp);
    }

    @SneakyThrows
    @Override
    protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/index.jsp").forward(req, resp);

        MyThreadStarter starter = new MyThreadStarter();
        starter.start();

        final SessionFactory sessionFactory = HibernateFactoryUtil.getSessionFactory();
        final Session session1 = sessionFactory.openSession();
        session1.beginTransaction();
        session1.save(starter.createDetails());
        session1.getTransaction().commit();
        session1.close();
    }
}