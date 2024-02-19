package com.HandlingSessionEvent;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionIdListener;

@WebServlet("/MySessionIdListener")
public class MySessionIdListener implements HttpSessionIdListener {

    @Override
    public void sessionIdChanged(HttpSessionEvent event, String oldSessionId) {
        System.out.println("Session ID changed. Old Session ID: " + oldSessionId +
                           ", New Session ID: " + event.getSession().getId());
    }
}
