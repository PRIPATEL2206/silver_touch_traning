package com.practice;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSession;

@WebListener
public class SessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        HttpSession session = event.getSession();
        String username = (String) session.getAttribute("username");

        if (username != null) {
            // Increment the session count for the user
            SessionLimitFilter.updateUserSessionCount(username, SessionLimitFilter.userSessionCountMap.getOrDefault(username, 0) + 1);
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        HttpSession session = event.getSession();
        String username = (String) session.getAttribute("username");

        if (username != null) {
            // Decrement the session count for the user
            int count = SessionLimitFilter.userSessionCountMap.getOrDefault(username, 0) - 1;
            count = count < 0 ? 0 : count; // Ensure count doesn't go negative
            SessionLimitFilter.updateUserSessionCount(username, count);
        }
    }
}
