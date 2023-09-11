package com.prodius.module4.lesson29hw.servlets;

import com.prodius.module4.lesson29hw.model.Task;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "CreateServlet", value = "/create")
public class CreateServlet extends HttpServlet {

    static final Map<String, List<String>> NAMES = new HashMap<>();

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        final Task task = new Task("");
        req.setAttribute("task", task);
        req.getRequestDispatcher("/update.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name").trim();

        if (StringUtils.isNotBlank(name)) {
            final String agent = req.getHeader("User-Agent");
            NAMES.merge(agent, Collections.singletonList(name), (oldV, newV) -> {
                oldV.addAll(newV);
                return oldV;
            });
        }

        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}