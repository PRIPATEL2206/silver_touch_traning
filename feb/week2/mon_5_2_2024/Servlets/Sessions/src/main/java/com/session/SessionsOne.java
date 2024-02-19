package com.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sessionOne")
public class SessionsOne extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		String name = req.getParameter("name");
		out.print("Welcome : " + name);
		
		HttpSession session = req.getSession();
		session.setAttribute("name", "jainil");
		RequestDispatcher rd = req.getRequestDispatcher("/Session1Result.jsp");
		rd.forward(req, resp);
	}
	
}
