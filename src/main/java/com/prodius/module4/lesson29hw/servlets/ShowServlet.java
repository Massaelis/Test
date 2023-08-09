package com.prodius.module4.lesson29hw.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "ShowServlet", value = "/show")
public class ShowServlet extends HttpServlet {
    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        // TODO: 09/08/23 get task for current user and add them to req
        req.getRequestDispatcher("/tasks.jsp").forward(req, resp);
    }
}
