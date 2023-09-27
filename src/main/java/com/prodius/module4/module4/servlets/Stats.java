package com.prodius.module4.module4.servlets;

import com.prodius.module4.module4.service.Service;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Stats", value = "/stats")
public class Stats extends HttpServlet {

    private Service service;

    @Override
    public void init(final ServletConfig config) throws ServletException {
        this.service = new Service();
    }

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws IOException {
        try (PrintWriter out = resp.getWriter()) {
            resp.setContentType("text/html");

            out.println("<html><body>");
            out.println("<h3>All statistic details</h3>");
            out.println(
                    "<table border=1><tr>"
                            + "<td><b>count</b></td>"
                            + "<td><b>all broke schemas</b></td>"
                            + "<td><b>all fuels</b></td></tr>"
            );

            out.println(service.getStats());
            out.println("</tr></table></body></html>");
        }
    }
}