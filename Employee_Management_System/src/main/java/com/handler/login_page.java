package com.handler;

import java.io.IOException;
import java.io.PrintWriter;

import com.dao.login_dao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login_page")
public class login_page extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public login_page() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		PrintWriter pw = response.getWriter();

		String Email = request.getParameter("name");
		String pass = request.getParameter("pass");

		if (login_dao.user_logine(Email, pass)) {
			RequestDispatcher rd = request.getRequestDispatcher("home.html");
			rd.forward(request, response);
		} else {
			pw.write("<center><h1 style='color: white';>somthing went wrong !!! please try again</h1></center> ");
			RequestDispatcher rd = request.getRequestDispatcher("login.html");
			rd.include(request, response);
		}

	}

}