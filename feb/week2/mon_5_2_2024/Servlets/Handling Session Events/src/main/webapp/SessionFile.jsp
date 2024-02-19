<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Session ID Listener Demo</title>
</head>
<body>

    <h1>Session ID Listener Demo</h1>

    <%
     
        HttpSession mysession = request.getSession(true);
        String sessionId = session.getId();
    %>

    <p>Session ID: <%= sessionId %></p>

    <form action="MySessionIdListener" method="post">
    <input type="submit" value="Change Session ID">
</form>


</body>
</html>

