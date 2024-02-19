package com.session;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionTimeListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        event.getSession().setAttribute("sessionStartTime", System.currentTimeMillis());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        long startTime = (Long) event.getSession().getAttribute("sessionStartTime");
        long endTime = System.currentTimeMillis();

        long sessionDuration = endTime - startTime;

        long sessionDurationSeconds = sessionDuration / 1000;

        System.out.println("Session duration: " + sessionDurationSeconds + " seconds");
    }
}
