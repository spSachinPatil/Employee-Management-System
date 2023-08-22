package com.handler;

import java.io.IOException;
import java.io.PrintWriter;

import com.bin.login_do;
import com.dao.login_dao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login_handler")
public class login_handler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public login_handler() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

		String l_name = request.getParameter("name");
		String l_email = request.getParameter("email");
		String l_pass = request.getParameter("pass_1");
		String l_pass_2 = request.getParameter("pass_2");

		login_do ps = new login_do(l_name, l_email, l_pass, l_pass_2);

		int status = login_dao.insert(ps);

		if (status > 0) {
			pw.print("<center><h2><Data is inserted></h2></center>");
			RequestDispatcher rd = request.getRequestDispatcher("login.html");
			rd.include(request, response);
		} else {
			pw.print("somthing is wrong please try again...");
			RequestDispatcher rd = request.getRequestDispatcher("sign_up.html");
			rd.include(request, response);
		}
	}

}