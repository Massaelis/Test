package com.prodius.module4.lesson29hw.servlets;

import com.prodius.module4.lesson29hw.model.Task;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "CreateServlet", value = "/create")
public class CreateServlet extends HttpServlet {
    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        final Task task = new Task("");
        req.setAttribute("task", task);
        req.getRequestDispatcher("/update.jsp").forward(req, resp);
    }
}
