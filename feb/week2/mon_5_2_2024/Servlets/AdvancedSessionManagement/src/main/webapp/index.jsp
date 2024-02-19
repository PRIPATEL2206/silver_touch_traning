<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Advanced Session Management</title>
</head>
<body>
	<%
		HttpSession sess = request.getSession();
		sess.setAttribute("username", "Tony Stark");
		sess.setAttribute("preventSessionFixation",null);
		
	%>
	<a href="userContent">1 Implement a servlet to display user-specific content based on session attributes. </a> <br>
	<a href="SessionFixationServlet">2 Create a filter to prevent session fixation attacks</a> <br>
	<a href="SessionFixationServlet">3 Implement a session listener to track user activity and log out idle users. </a> <br>
	<a href="SessionFixationServlet">4 Use a filter to enforce a maximum number of simultaneous sessions per user.</a> <br>
	<a href=""> </a> <br>
</body>
</html>