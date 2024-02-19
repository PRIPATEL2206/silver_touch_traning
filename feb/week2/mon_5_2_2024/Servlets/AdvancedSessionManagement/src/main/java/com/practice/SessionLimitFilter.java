package com.practice;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//@WebFilter("/*")
public class SessionLimitFilter implements Filter {

    private static final int MAX_SESSIONS_PER_USER = 3;
    public static final Map<String, Integer> userSessionCountMap = new ConcurrentHashMap<>();

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        HttpSession session = request.getSession(false);

        if (session != null && session.getAttribute("username") != null) {
            String username = (String) session.getAttribute("username");

            // Get the current session count for the user
            int sessionCount = userSessionCountMap.getOrDefault(username, 0);

            // Check if the user already has the maximum allowed sessions
            if (sessionCount >= MAX_SESSIONS_PER_USER) {
                response.sendError(HttpServletResponse.SC_FORBIDDEN, "Maximum sessions per user exceeded.");
                return;
            }
        }

        chain.doFilter(req, res);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization code (if any)
    }

    @Override
    public void destroy() {
        // Cleanup code (if any)
    }

    // This method should be called by HttpSessionListener to update the session count for each user
    public static void updateUserSessionCount(String username, int count) {
        userSessionCountMap.put(username, count);
    }
}
