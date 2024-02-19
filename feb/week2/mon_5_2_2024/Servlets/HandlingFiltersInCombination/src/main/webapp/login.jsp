<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
    <h1>Login</h1>
    <% if (request.getParameter("error") != null && request.getParameter("error").equals("2")) { %>
        <p style="color: red;">Invalid username or password. Please try again.</p>
    <% } %>
    <% if (request.getParameter("error") != null && request.getParameter("error").equals("1")) { %>
        <p style="color: red;">Required username, password and role.</p>
    <% } %>
    <form action="login" method="post">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username"><br>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password"><br>
        <label for="role">Role:</label>
        <input type="text" id="role" name="role"><br>
        <input type="submit" value="Login">
    </form>
</body>
</html>