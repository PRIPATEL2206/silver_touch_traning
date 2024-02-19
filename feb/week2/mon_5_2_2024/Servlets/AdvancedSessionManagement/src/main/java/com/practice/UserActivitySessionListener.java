package com.practice;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.HashMap;
import java.util.Map;


@WebFilter(filterName = "SessionIdleListner", urlPatterns = {"/*"})
public class UserActivitySessionListener implements HttpSessionListener {

    private static final Map<String, Long> sessionLastAccessTimeMap = new HashMap<>();
    private static final long SESSION_TIMEOUT_THRESHOLD = 1;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        String sessionId = session.getId();
        sessionLastAccessTimeMap.put(sessionId, System.currentTimeMillis());
        System.out.print("SessionCreated called");

		new IdleUserCheckerThread().start();
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        String sessionId = session.getId();
        sessionLastAccessTimeMap.remove(sessionId);
    }

    public static void checkIdleUsers() {   	
        long currentTime = System.currentTimeMillis();
        for (String sessionId : sessionLastAccessTimeMap.keySet()) {
            long lastAccessTime = sessionLastAccessTimeMap.get(sessionId);
            if (currentTime - lastAccessTime > SESSION_TIMEOUT_THRESHOLD) {
                HttpSession session = SessionRegistry.getSession(sessionId);
                if (session != null) {

                    System.out.println("Session with ID " + sessionId + " was inactive and has been invalidated.");
                    session.invalidate();
                    sessionLastAccessTimeMap.remove(sessionId);
                }
            }
        }
    }
}
