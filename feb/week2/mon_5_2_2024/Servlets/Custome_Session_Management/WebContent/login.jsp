<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h2>Login</h2>
<% if (request.getAttribute("errorMessage") != null) { %>
    <p style="color:red;"><%= request.getAttribute("errorMessage") %></p>
<% } %>
<form action="login" method="post">
    <div>
        <label for="username">Username:</label>
        <input type="text" id="name" name="name" required>
    </div>
    <div>
        <label for="password">Password:</label>
        <input type="password" id="pass" name="pass" required>
    </div>
    <div>
        <button type="submit">Login</button>
    </div>
</form>
</body>
</html>
