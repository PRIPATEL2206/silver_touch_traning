package com.session;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/SessionTimeoutDemo")
public class SessionTimeoutDemo extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();

        if (session.isNew()) {
            session.setAttribute("username", "tony");
            session.setAttribute("email", "tony@example.com");

            session.setMaxInactiveInterval(10);
            out.println("Session created with timeout of 10 seconds.<br>");
        } else {
            out.println("Session already exists.<br>");
        }

        out.println("Session ID: " + session.getId() + "<br>");
        out.println("Session Timeout (seconds): " + session.getMaxInactiveInterval() + "<br>");

        if (request.getParameter("expire") != null && request.getParameter("expire").equals("true")) {
            session.invalidate();
            out.println("<br>Session has been invalidated (expired).<br>");
        }

        out.println("<br><a href='SessionTimeoutDemo?expire=true'>Expire Session</a>");
    }
}
