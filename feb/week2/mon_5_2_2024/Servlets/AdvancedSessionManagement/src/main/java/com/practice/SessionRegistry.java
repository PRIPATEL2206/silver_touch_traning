package com.practice;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class SessionRegistry {
    private static final Map<String, HttpSession> sessionMap = new HashMap<>();

    public static void addSession(String sessionId, HttpSession session) {
        sessionMap.put(sessionId, session);
    }

    public static void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static HttpSession getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }
}
