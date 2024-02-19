package com.practice;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.UUID;

@WebFilter(filterName = "SessionFixationFilter", urlPatterns = {"/*"})
public class SessionFixationFilter implements Filter {

    private String sessionAttributeName = "preventSessionFixation";

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        HttpSession session = httpRequest.getSession(false);

        if (session != null && session.getAttribute(sessionAttributeName) == null) {
        	System.out.println("Fixation Filter worked");
            session.invalidate(); 

            session = httpRequest.getSession(true);
            session.setAttribute(sessionAttributeName, true);

            httpResponse.sendRedirect("login.html");
            return;
        }

        chain.doFilter(request, response);
    }

   
}
