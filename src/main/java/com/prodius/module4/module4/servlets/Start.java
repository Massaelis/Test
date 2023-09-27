package com.prodius.module4.module4.servlets;

import com.prodius.module4.module4.threads.MyThreadStarter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;

@WebServlet(name = "Start", value = "/start")
public class Start extends HttpServlet {

    @SneakyThrows
    @Override
    protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) {
        new MyThreadStarter().start();
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}