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

@WebServlet(name = "StatsId", value = "/stats-id")
public class StatsId extends HttpServlet {
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
            out.println("<h3>Details</h3>");
            out.println(
                    "<table border=1><tr>"
                            + "<td><b>id</b></td>"
                            + "<td><b>brokeschemas</b></td>"
                            + "<td><b>date</b></td>"
                            + "<td><b>fuel</b></td>" + "<td><b>time</b></td></tr>"
            );
            out.println(service.getStatsIds());
            out.println("</tr></table></body></html>");
        }
    }
}