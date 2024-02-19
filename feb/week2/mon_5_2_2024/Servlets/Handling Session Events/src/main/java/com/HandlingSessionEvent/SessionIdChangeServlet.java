package com.HandlingSessionEvent;
//SessionIdChangeServlet.java
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/SessionIdChangeServlet") // Update URL pattern to match your application
public class SessionIdChangeServlet extends HttpServlet {

 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    
 }
}
