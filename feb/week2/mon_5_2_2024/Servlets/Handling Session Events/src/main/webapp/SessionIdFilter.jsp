<!-- sessionChangeExample.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Session ID Change Example</title>
</head>
<body>
    <h2>Session ID Change Example</h2>
 
    <%
        String sessionId = session.getId();
        out.println("Current Session ID: " + sessionId);
    %>

    <br>

    <%
        String newSessionId = (String) request.getAttribute("newSessionId");
        if (newSessionId != null) {
            out.println("Session ID changed! New Session ID: " + newSessionId);
        }
    %>
</body>
</html>
