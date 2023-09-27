package com.prodius.module4.module4.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "Stats", value = "/stats")
public class Stats extends HttpServlet {

    private static final long serialVersionUID = 1L;
    final String URL = "jdbc:postgresql://localhost:5432/module4";
    final String USER = "postgres";
    final String PASSWORD = "route";
    final String DRIVER = "org.postgresql.Driver";
    Connection conn = null;

    public void init() throws ServletException {
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }
    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        try {

            resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();

            out.println("<html><body>");
            out.println("<h3>All statistic details</h3>");
            out.println("<table border=1><tr>"
                    + "<td><b>count</b></td>" + "<td><b>all brokeschemas</b></td>" + "<td><b>all fuels</b></td></tr>");

            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM details ;";
            ResultSet rs = stmt.executeQuery(sql);
            int count = 0;
            int fuels = 0;
            int brokeschema = 0;
            while (rs.next()) {
                int brokeschemas = rs.getInt("brokeschemas");
                int fuel = rs.getInt("fuel");

                count++;
                fuels = fuels + fuel;
                brokeschema = brokeschemas + brokeschema;
            }
            out.println( "<td>" + count + "</td>");
            out.println( "<td>" + brokeschema + "</td>");
            out.println("<td>" + fuels + "</td>" + "</tr>");
            out.println("</table></body></html>");

            rs.close();
            stmt.close();
            out.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    @Override
    protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}